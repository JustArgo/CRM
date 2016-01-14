package com.pakin.crm.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
@Getter
@Setter
@MappedSuperclass
public  class QueryObject {
	private List<String> conditions = new ArrayList<>();
	private List<Object> params = new ArrayList<>();
	private Integer page = 1;
	private Integer rows = 3;
	private boolean init=false;
	protected void CustomizedQuery(){
	}

	protected void addCondition(String condition, Object... param) {
		conditions.add(condition);
		params.addAll(Arrays.asList(param));
	}

	public String getQuery() {
		init();
		if (conditions.size() > 0) {
			StringBuilder sb = new StringBuilder(100).append(" WHERE ").append(StringUtils.join(conditions, " AND "));
			return sb.toString();
		}
		return "";
	}

	private void init() {
			if(!init){
				CustomizedQuery();
				init=true;
			}
	}

	public List<Object> getParams() {
		init();
		return params;
	}

}
