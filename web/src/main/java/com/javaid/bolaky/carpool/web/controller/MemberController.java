package com.javaid.bolaky.carpool.web.controller;

import static com.javaid.bolaky.carpool.web.controller.util.ControllerUtility.getUsername;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.LocationVO;
import com.javaid.bolaky.carpool.service.vo.PoolVO;
import com.javaid.bolaky.carpool.service.vo.UserVO;

@Controller
public class MemberController {

	private static final String MEMBER_AREA_PAGE = "memberarea";

	@Resource(name = "carPoolService")
	private CarPoolService poolService;

	@RequestMapping(value = "/memberarea", method = RequestMethod.GET)
	public String memberPage(Model model) {

		Set<PoolVO> poolVOs = poolService.findPools(getUsername());
		model.addAttribute("poolVOs", poolVOs);

		UserVO userVO = poolService.findByUsernameAndEmailAddress(
				getUsername(), null);
		model.addAttribute("userVO", userVO);

		this.populateListOfCountriesInModel(model);

		return MEMBER_AREA_PAGE;
	}

	private void populateListOfCountriesInModel(Model model) {

		Set<LocationVO> locationVOs = this.getListOfCountries();

		model.addAttribute("countries", locationVOs);
	}

	private Set<LocationVO> getListOfCountries() {

		Set<LocationVO> locationVOs = new HashSet<LocationVO>();
		locationVOs
				.add(new LocationVO(1L, "Mauritius", null, null, null, null));
		return locationVOs;
	}
}
