package com.javaid.bolaky.carpool.web.webflow.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.javaid.bolaky.carpool.service.vo.CarPoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolView;

@Component
public class CarPoolRegistrationVOValidator {

	public void validateRegistercarpoolpage1(
			CarPoolRegistrationVO carPoolRegistrationVO,
			ValidationContext context) {

		this.filterMessageForSpecificCarPoolView(context.getMessageContext(),
				CarPoolView.REGISTER_CARPOOL_PAGE_1);
	}

	private void filterMessageForSpecificCarPoolView(MessageContext messages,
			CarPoolView carPoolView) {

		List<MessageResolver> messageResolvers = new ArrayList<MessageResolver>();

		for (int i = 0; i < messages.getAllMessages().length; i++) {

			if (CarPoolError.isApplicationCodeCorrespondsToView(
					messages.getAllMessages()[i].getText().toString(),
					carPoolView)) {

				messageResolvers.add(new MessageBuilder()
						.error()
						.source(messages.getAllMessages()[i].getSource())
						.defaultText(
								CarPoolError.getCarPoolError(
										messages.getAllMessages()[i].getText())
										.getDescripion()).build());
			}
		}

		messages.clearMessages();

		for (MessageResolver messageResolver : messageResolvers) {
			messages.addMessage(messageResolver);
		}
	}
}
