package com.javaid.bolaky.carpool.web.controller;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaid.bolaky.carpool.service.api.CarPoolService;
import com.javaid.bolaky.carpool.service.vo.PoolSearchResultVO;
import com.javaid.bolaky.carpool.service.vo.PoolSearchVO;

@Controller
public class SearchPoolController {

	private static final String SEARCH_POOL_FORM_PAGE = "poolsimplesearch";
	private static final String ADVANCE_SEARCH_POOL_FORM_PAGE = "pooladvancedsearch";

	@Resource(name = "carPoolService")
	private CarPoolService carPoolService;

	@RequestMapping(value = "/poolsimplesearch", method = RequestMethod.GET)
	public String setUpSearchPoolForm(Model model) {

		model.addAttribute(new PoolSearchVO());
		return SEARCH_POOL_FORM_PAGE;
	}

	@RequestMapping(value = "/pooladvancesearch", method = RequestMethod.GET)
	public String setUpAdvanceSearchPoolForm(Model model) {

		model.addAttribute(new PoolSearchVO());
		return ADVANCE_SEARCH_POOL_FORM_PAGE;
	}

	@RequestMapping(value = "/searchpool", method = RequestMethod.POST)
	public String searchPool(PoolSearchVO poolSearchVO,
			BindingResult bindingResult, Model model) {

		Set<PoolSearchResultVO> poolSearchResultVOs = carPoolService
				.findPools(poolSearchVO);
		model.addAttribute("poolSearchResultVOs", poolSearchResultVOs);

		return null;
	}
}
