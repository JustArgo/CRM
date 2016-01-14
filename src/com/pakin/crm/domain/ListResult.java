package com.pakin.crm.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ListResult {
	private Integer total;
	private List rows;
	public ListResult(Integer total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	public ListResult() {
		super();
	}
	
}
