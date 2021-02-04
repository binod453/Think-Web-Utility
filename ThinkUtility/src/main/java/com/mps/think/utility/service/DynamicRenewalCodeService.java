package com.mps.think.utility.service;

import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.paging.Page;
import com.mps.think.utility.model.paging.PagingRequest;

public interface DynamicRenewalCodeService {

	public Page<DynamicRenewalCodeModel> getDynamicCodes(PagingRequest pagingRequest) ;

}
