package com.javaid.bolaky.carpool.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaid.bolaky.carpool.service.acl.email.impl.EmailAclException;
import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.ForgotPasswordVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;

@Controller
public class ForgotPasswordController {
	
	private final String forgotPasswordPage = "forgotpassword";
	private final String loginPage = "login";
	
	@Resource(name = "carpool_service_DefaultCarPoolService")
	private CarPoolService carPoolService;

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String setUpForgotPasswordForm(Model model){
		
		model.addAttribute(new ForgotPasswordVO());
		return forgotPasswordPage;
	}
	
	@RequestMapping(value = "forgotPasswordProcess", method = RequestMethod.POST)
	public String processForgotPasswordForm(
			@Valid ForgotPasswordVO forgotPasswordVO,
			BindingResult bindingResult, Model model) throws EmailAclException {

		if (bindingResult.hasErrors()) {
			
			List<String> errorMessages = new ArrayList<String>();
			
			List<ObjectError> objectErrors = bindingResult.getAllErrors();

			if (objectErrors != null && !objectErrors.isEmpty()) {

				for (ObjectError objectError : objectErrors) {
					errorMessages.add(CarPoolError.getCarPoolError(
							objectError.getDefaultMessage()).getDescripion());
				}
			}
			
			model.addAttribute("errorMessages", errorMessages);
			return forgotPasswordPage;
		}
		
		carPoolService.sendPasswordToEmail("Javaid", "Bolaky", "ash", "gud_boy@live.com");
		return loginPage;
	}
}
