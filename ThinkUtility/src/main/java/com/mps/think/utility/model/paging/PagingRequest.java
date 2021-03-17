package com.mps.think.utility.model.paging;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class PagingRequest {

	private int start;
	private int length;
	private int draw;
	private List<Order> order;
	private List<Column> columns;
	private Search search;

}