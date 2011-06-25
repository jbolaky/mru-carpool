package com.javaid.bolaky.carpool.web.controller;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaid.bolaky.carpool.service.vo.CountryVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.thoughtworks.xstream.XStream;

@Controller
public class RegistrationController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegistrationController.class);

	@RequestMapping(value = "registeruser", method = RequestMethod.GET)
	public String populateUserRegistrationForm(Model model) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In populateForm method with Model " + model);
		}

		Set<CountryVO> countryVOs = new HashSet<CountryVO>();
		countryVOs.add(new CountryVO(1L, "Mauritius"));
		countryVOs.add(new CountryVO(2L, "Reunion"));

		model.addAttribute("countries", countryVOs);
		model.addAttribute(new UserVO());
		return "register";
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String procesSaveUserRegistrationForm(UserVO userVO, Model model) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In registerUser method with Model " + model);
		}
		System.out.println(new XStream().toXML(userVO));
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
		return "homepage";
	}

}
