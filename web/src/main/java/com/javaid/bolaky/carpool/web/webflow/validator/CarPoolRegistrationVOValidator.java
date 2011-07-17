package com.javaid.bolaky.carpool.web.webflow.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.binding.message.Message;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.PoolRegistrationVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolView;
import com.thoughtworks.xstream.XStream;

@Component
public class CarPoolRegistrationVOValidator {

	@Resource(name = "carPoolService")
	private CarPoolService carPoolService;

	public void validateRegistercarpoolpage1(
			PoolRegistrationVO carPoolRegistrationVO, ValidationContext context) {

		this.filterMessageForSpecificCarPoolView(
				carPoolService.validate(carPoolRegistrationVO),
				context.getMessageContext(),
				CarPoolView.REGISTER_CARPOOL_PAGE_1);
	}

	public void validateRegistercarpoolpage2(
			PoolRegistrationVO carPoolRegistrationVO, ValidationContext context) {

		this.filterMessageForSpecificCarPoolView(null,
				context.getMessageContext(),
				CarPoolView.REGISTER_CARPOOL_PAGE_2);
	}

	public void validateRegistercarpoolpage3(
			PoolRegistrationVO carPoolRegistrationVO, ValidationContext context) {

		this.filterMessageForSpecificCarPoolView(null,
				context.getMessageContext(),
				CarPoolView.REGISTER_CARPOOL_PAGE_3);
	}

	private void filterMessageForSpecificCarPoolView(
			Set<CarPoolError> carPoolErrors, MessageContext messages,
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

		if (carPoolErrors != null && !carPoolErrors.isEmpty()) {

			for (CarPoolError carPoolError : carPoolErrors) {

				if (carPoolView.equals(carPoolError.getCarPoolView())) {

					messageResolvers.add(new MessageBuilder().error()
							.source(carPoolError.getApplicationCode())
							.defaultText(carPoolError.getDescripion()).build());
				}
			}
		}

		messages.clearMessages();

		for (MessageResolver messageResolver : messageResolvers) {
			messages.addMessage(messageResolver);
		}
	}
}
