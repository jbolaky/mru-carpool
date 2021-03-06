package com.javaid.bolaky.carpool.web.controller;

import static com.javaid.bolaky.carpool.web.controller.util.ControllerUtility.getUsername;
import static com.javaid.bolaky.carpool.web.controller.util.ControllerUtility.setUsername;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;
import com.javaid.bolaky.carpool.service.vo.enumerated.CarPoolError;
import com.javaid.bolaky.carpool.web.controller.util.ControllerUtility;

@Controller
public class UserRegistrationController {

	@Resource(name = "carPoolService")
	private CarPoolService carPoolService;

	private final String registerPageName = "register";
	private final String homePageName = "homepage";

	@RequestMapping(value = "registeruser", method = RequestMethod.GET)
	public String populateUserRegistrationForm(Model model) {

		model.addAttribute(new UserVO());
		this.populateListOfCountriesInModel(model);
		return registerPageName;
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String procesSaveUserRegistrationForm(@Valid UserVO userVO,
			BindingResult bindingResult, Model model) {

		ControllerUtility.assignAllEmptyStringTypeAttributeToNull(userVO);

		List<String> errorMessages = new ArrayList<String>();
		Set<CarPoolError> carPoolErrors = carPoolService.validate(userVO);

		if (bindingResult.hasErrors()
				|| (carPoolErrors != null && !carPoolErrors.isEmpty())) {

			List<ObjectError> objectErrors = bindingResult.getAllErrors();

			if (objectErrors != null && !objectErrors.isEmpty()) {

				for (ObjectError objectError : objectErrors) {
					errorMessages.add(CarPoolError.getCarPoolError(
							objectError.getDefaultMessage()).getDescripion());
				}
			}

			if (carPoolErrors != null && !carPoolErrors.isEmpty()) {

				for (CarPoolError carPoolError : carPoolErrors) {

					if (carPoolError != null) {
						errorMessages.add(carPoolError.getDescripion());
					}
				}
			}

			model.addAttribute("errorMessages", errorMessages);
			this.populateListOfCountriesInModel(model);
			return registerPageName;
		}

		// this.setSecurityContext(userVO.getUsername(),userVO.getPassword());

		if (getUsername() != null
				&& !getUsername().equalsIgnoreCase("anonymousUser")) {

			Assert.isTrue(carPoolService.update(userVO),
					"Is expected to be true");
		} else {

			setUsername(userVO.getUsername(), userVO.getPassword());
			Assert.isTrue(carPoolService.store(userVO),
					"Is expected to be true");
		}

		return homePageName;
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

	private void populateListOfCountriesInModel(Model model) {

		Set<LocationVO> locationVOs = this.getListOfCountries();

		model.addAttribute("countries", locationVOs);
	}

	/*
	 * private void setSecurityContext(String username, String password) {
	 * 
	 * Authentication authentication = new UsernamePasswordAuthenticationToken(
	 * username, password);
	 * SecurityContextHolder.getContext().setAuthentication(authentication); }
	 */

	private Set<LocationVO> getListOfCountries() {

		/*Set<LocationVO> locationVOs = new HashSet<LocationVO>();
		locationVOs
				.add(new LocationVO(1L, "Mauritius", null, null, null, null));*/
		return carPoolService.getAllCountries();
	}

	private Set<LocationVO> getListOfAreas(Long countryId) {

		/*Set<LocationVO> locationVOs = new HashSet<LocationVO>();
		locationVOs.add(new LocationVO(null, null, 1L, "Black River", null,
				null));
		locationVOs.add(new LocationVO(null, null, 2L, "Flacq", null, null));
		locationVOs
				.add(new LocationVO(null, null, 3L, "Port Louis", null, null));*/
		return carPoolService.getAreas(countryId);

	}

	private Set<LocationVO> getListOfDistrcts(Long areaId) {

		/*Set<LocationVO> locationVOs = new HashSet<LocationVO>();

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
		}*/
		return carPoolService.getDistricts(areaId);

	}
}
