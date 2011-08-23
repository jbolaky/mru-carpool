package com.javaid.bolaky.carpool.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaid.bolaky.carpool.service.vo.ContactDriverVO;

@Controller
public class ContactDriverController {

	private static final String CONTACT_DRIVER_PAGE = "contactdriver";

	@RequestMapping(value = "/contactdriver", method = RequestMethod.GET)
	public String setUpContactDriverForm(@RequestParam("id") Long poolId,
			Model model) {

		ContactDriverVO contactDriverVO = new ContactDriverVO();
		contactDriverVO.setPoolId(poolId);

		model.addAttribute(contactDriverVO);

		return CONTACT_DRIVER_PAGE;
	}

	@RequestMapping(value = "/requestcontactdriver", method = RequestMethod.POST)
	public String setUpContactDriverForm(ContactDriverVO contactDriverVO,
			Model model) {

		return CONTACT_DRIVER_PAGE;
	}
}
