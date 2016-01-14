package com.pakin.crm.query;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.pakin.crm.util.DateUtil;
import com.pakin.crm.util.StringUtil;
@Getter
@Setter
public class CustomerQueryObject extends QueryObject {
	public String name;
	public String keyword;
	private Date begindate;
	private Date enddate;
	@Override
	protected void CustomizedQuery() {
		if(StringUtil.hasLength(keyword)){
			addCondition("c.name like ?","%"+keyword+"%");
		}
		if(StringUtil.hasLength(name)){
			addCondition("c2.name like ?", "%"+name+"%");
		}
		if(begindate!=null){
			super.addCondition("o.signTime >= ?",begindate);
		}
		if(enddate!=null){
			super.addCondition("o.signTime <= ?",DateUtil.endOfDay(enddate));
		}
	}
	
}
