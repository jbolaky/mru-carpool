package com.javaid.bolaky.carpool.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.thoughtworks.xstream.XStream;

@Controller
public class RegistrationController {

	@RequestMapping(value = "registeruser", method = RequestMethod.GET)
	public String populateUserRegistrationForm(Model model) {

		Set<LocationVO> locationVOs = this.getListOfCountries();

		model.addAttribute("countries", locationVOs);
		model.addAttribute(new UserVO());

		return "register";
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String procesSaveUserRegistrationForm(@Valid UserVO userVO,
			BindingResult bindingResult,Model model) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> objectErrors = bindingResult.getAllErrors();
			List<String> errorMessages = new ArrayList<String>();
			
			for (ObjectError objectError : objectErrors) {
				errorMessages.add(CarPoolError.getCarPoolError(objectError.getDefaultMessage()).getDescripion());
			}
			
			System.out.println(errorMessages);
		}

		System.out.println(new XStream().toXML(userVO));

		return "homepage";
	}

	@RequestMapping(value = "getareas", method = RequestMethod.GET)
	public @ResponseBody
	Set<LocationVO> getListOfAreasOfACountry(@RequestParam Long countryId) {

		return getListOfAreas(countryId);
	}

	@RequestMapping(value = "getdistricts", method = RequestMethod.GET)
	public @ResponseBody
	Set<LocationVO> getListOfDistrictsOfAnArea(@RequestParam Long areaId) {

		return getListOfDistrcts(areaId);
	}

	private Set<LocationVO> getListOfCountries() {

		Set<LocationVO> locationVOs = new HashSet<LocationVO>();
		locationVOs
				.add(new LocationVO(1L, "Mauritius", null, null, null, null));
		return locationVOs;
	}

	private Set<LocationVO> getListOfAreas(Long countryId) {

		Set<LocationVO> locationVOs = new HashSet<LocationVO>();
		locationVOs.add(new LocationVO(null, null, 1L, "Black River", null,
				null));
		locationVOs.add(new LocationVO(null, null, 2L, "Flacq", null, null));
		locationVOs
				.add(new LocationVO(null, null, 3L, "Port Louis", null, null));
		return locationVOs;

	}

	private Set<LocationVO> getListOfDistrcts(Long areaId) {

		Set<LocationVO> locationVOs = new HashSet<LocationVO>();

		if (areaId.equals(1L)) {
			locationVOs.add(new LocationVO(null, null, null, null, 1L,
					"Bambous"));
			locationVOs.add(new LocationVO(null, null, null, null, 2L,
					"Tamarin"));
		} else if (areaId.equals(2L)) {
			locationVOs.add(new LocationVO(null, null, null, null, 1L,
					"Centre de Flacq"));
			locationVOs.add(new LocationVO(null, null, null, null, 2L,
					"Belle Mare"));
		} else {
			locationVOs.add(new LocationVO(null, null, null, null, 1L,
					"Plaine-Verte"));
			locationVOs.add(new LocationVO(null, null, null, null, 2L,
					"Ward Quatre"));
		}
		return locationVOs;

	}
}
