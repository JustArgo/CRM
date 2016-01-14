package com.pakin.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AjaxResult {
	private Boolean success=true;
	private String msg;
	public AjaxResult(Boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public AjaxResult(String msg) {
		super();
		this.msg = msg;
	}
	public AjaxResult() {
		super();
	}
	
	
}
