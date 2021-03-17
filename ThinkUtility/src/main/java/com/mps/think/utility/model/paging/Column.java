package com.mps.think.utility.model.paging;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Column {

	private String data;
	private String name;
	private Boolean searchable;
	private Boolean orderable;
	private Search search;
}