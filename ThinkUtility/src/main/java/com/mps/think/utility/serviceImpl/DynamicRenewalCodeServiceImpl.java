package com.mps.think.utility.serviceImpl;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.utility.model.DynamicRenewalCodeComparator;
import com.mps.think.utility.model.DynamicRenewalCodeModel;
import com.mps.think.utility.model.paging.Column;
import com.mps.think.utility.model.paging.Order;
import com.mps.think.utility.model.paging.Page;
import com.mps.think.utility.model.paging.PagingRequest;
import com.mps.think.utility.service.DynamicRenewalCodeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DynamicRenewalCodeServiceImpl implements DynamicRenewalCodeService{

	private static final Comparator<DynamicRenewalCodeModel> EMPTY_COMPARATOR = (e1, e2) -> 0;

	@Override
	public Page<DynamicRenewalCodeModel> getDynamicCodes(PagingRequest pagingRequest) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			List<DynamicRenewalCodeModel> dynamicCodes = objectMapper.readValue(
					getClass().getClassLoader().getResourceAsStream("DummyData.json"),
					new TypeReference<List<DynamicRenewalCodeModel>>() {
					});

			return getPage(dynamicCodes, pagingRequest);

		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

		return new Page<>();
	}

	private Page<DynamicRenewalCodeModel> getPage(List<DynamicRenewalCodeModel> dynamicCodes,
			PagingRequest pagingRequest) {
		List<DynamicRenewalCodeModel> filtered = dynamicCodes.stream().sorted(sortDynamicCodes(pagingRequest))
				.filter(filterDynamicCodes(pagingRequest)).skip(pagingRequest.getStart())
				.limit(pagingRequest.getLength()).collect(Collectors.toList());

		long count = dynamicCodes.stream().filter(filterDynamicCodes(pagingRequest)).count();

		Page<DynamicRenewalCodeModel> page = new Page<>(filtered);
		page.setRecordsFiltered((int) count);
		page.setRecordsTotal((int) count);
		page.setDraw(pagingRequest.getDraw());

		return page;
	}

	private Predicate<DynamicRenewalCodeModel> filterDynamicCodes(PagingRequest pagingRequest) {
		if (pagingRequest.getSearch() == null || StringUtils.isEmpty(pagingRequest.getSearch().getValue())) {
			return employee -> true;
		}

		String value = pagingRequest.getSearch().getValue();

		return dynamicCode -> dynamicCode.getDynamicCode().toLowerCase().contains(value)
				|| dynamicCode.getOfferType().toLowerCase().contains(value)
				|| dynamicCode.getDescription().toLowerCase().contains(value);
	}

	private Comparator<DynamicRenewalCodeModel> sortDynamicCodes(PagingRequest pagingRequest) {
		if (pagingRequest.getOrder() == null) {
			return EMPTY_COMPARATOR;
		}

		try {
			Order order = pagingRequest.getOrder().get(0);

			int columnIndex = order.getColumn();
			Column column = pagingRequest.getColumns().get(columnIndex);

			Comparator<DynamicRenewalCodeModel> comparator = DynamicRenewalCodeComparator
					.getComparator(column.getData(), order.getDir());
			if (comparator == null) {
				return EMPTY_COMPARATOR;
			}

			return comparator;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return EMPTY_COMPARATOR;
	}
}
