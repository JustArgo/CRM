package com.pakin.crm.query;

import lombok.Getter;
import lombok.Setter;

import com.pakin.crm.util.StringUtil;

@Getter
@Setter
public class PotentialCustomerQueryObject extends QueryObject {
	private String keyword;
	private Long inputId=-1L;
	@Override
	protected void CustomizedQuery() {
		if(StringUtil.hasLength(keyword)){
			addCondition("p.name like ?","%"+keyword+"%");
		}
		if(inputId!=null&&inputId>0){
			addCondition("i.id=?", inputId);
		}
	}
}
