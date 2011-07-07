package com.javaid.bolaky.carpool.web.webflow.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.binding.message.Message;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.javaid.bolaky.carpool.service.vo.CarPoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolView;
import com.thoughtworks.xstream.XStream;

@Component
public class CarPoolRegistrationVOValidator {

	public void validateRegistercarpoolpage1(
			CarPoolRegistrationVO carPoolRegistrationVO,
			ValidationContext context) {

		this.filterMessageForSpecificCarPoolView(context.getMessageContext(),
				CarPoolView.REGISTER_CARPOOL_PAGE_1);
	}

	public void validateRegistercarpoolpage2(
			CarPoolRegistrationVO carPoolRegistrationVO,
			ValidationContext context) {

		this.filterMessageForSpecificCarPoolView(context.getMessageContext(),
				CarPoolView.REGISTER_CARPOOL_PAGE_2);
	}

	public void validateRegistercarpoolpage3(
			CarPoolRegistrationVO carPoolRegistrationVO,
			ValidationContext context) {

		this.filterMessageForSpecificCarPoolView(context.getMessageContext(),
				CarPoolView.REGISTER_CARPOOL_PAGE_3);
	}

	private void filterMessageForSpecificCarPoolView(MessageContext messages,
			CarPoolView carPoolView) {

		System.out.println(new XStream().toXML(carPoolView));

		List<MessageResolver> messageResolvers = new ArrayList<MessageResolver>();

		if (messages != null && messages.getAllMessages() != null
				&& messages.getAllMessages().length > 0) {

			for (Message message : messages.getAllMessages()) {

				if (CarPoolError.isApplicationCodeCorrespondsToView(message
						.getText().toString(), carPoolView)) {

					messageResolvers.add(new MessageBuilder()
							.error()
							.source(message.getSource())
							.defaultText(
									CarPoolError.getCarPoolError(
											message.getText()).getDescripion())
							.build());
				}
			}
		}

		messages.clearMessages();

		for (MessageResolver messageResolver : messageResolvers) {
			messages.addMessage(messageResolver);
		}
	}
}
