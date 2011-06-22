package com.javaid.bolaky.carpool.web.controller;

import java.util.Set;

import org.apache.commons.collections15.set.ListOrderedSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.CountryVO;

@Controller
public class RegistrationController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegistrationController.class);

	private CarPoolService carPoolService;

	@RequestMapping(value = "registeruser", method = RequestMethod.GET)
	public String populateForm(Model model) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In populateForm method with Model " + model);
		}

		Set<CountryVO> countryVOs = new ListOrderedSet<CountryVO>();
		countryVOs.add(new CountryVO(1L, "Mauritius"));
		countryVOs.add(new CountryVO(2L, "Reunion"));

		model.addAttribute("countries", countryVOs);
		return "register";
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String registerUser(Model model) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("In registerUser method with Model " + model);
		}

		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
		return "homepage";
	}

}
