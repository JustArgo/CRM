package com.pakin.crm.query;

import com.pakin.crm.util.StringUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderQueryObject extends QueryObject {
	public String keyword;
	@Override
	protected void CustomizedQuery() {
		if(StringUtil.hasLength(keyword)){
			addCondition("c.name like ?","%"+keyword+"%");
		}
	}
	
}
