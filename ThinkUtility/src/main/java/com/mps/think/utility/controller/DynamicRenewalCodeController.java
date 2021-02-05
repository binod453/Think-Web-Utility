package com.mps.think.utility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.paging.Page;
import com.mps.think.utility.model.paging.PagingRequest;
import com.mps.think.utility.service.DynamicRenewalCodeService;

@RestController
public class DynamicRenewalCodeController {
	
	@Autowired
	DynamicRenewalCodeService dynamicRenewalCodeService;
	
	@PostMapping(value = "/dynamicRenewalCodeList")
	public Page<DynamicRenewalCodeModel> dynamicRenewalCodeList(@RequestBody PagingRequest pagingRequest) {
		return dynamicRenewalCodeService.getDynamicCodes(pagingRequest);
	}

}
