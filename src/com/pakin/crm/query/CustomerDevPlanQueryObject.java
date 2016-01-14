package com.pakin.crm.query;

import lombok.Getter;
import lombok.Setter;

import com.pakin.crm.util.StringUtil;
@Getter
@Setter
public class CustomerDevPlanQueryObject extends QueryObject {
	private String keyword;
	@Override
	protected void CustomizedQuery() {
		if(StringUtil.hasLength(keyword)){
			addCondition("(p.name like ?)","%"+keyword+"%");
		}
	}
}
