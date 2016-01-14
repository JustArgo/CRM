package com.pakin.crm.query;

import com.pakin.crm.util.StringUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerTransferQueryObject extends QueryObject {
	private String keyword;
	@Override
	protected void CustomizedQuery() {
		if(StringUtil.hasLength(keyword)){
			addCondition("(customer.name like ?)","%"+keyword+"%");
		}
	}
}
