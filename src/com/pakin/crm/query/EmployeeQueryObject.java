package com.pakin.crm.query;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;

import com.pakin.crm.util.StringUtil;

@Component
@Getter
@Setter
public class EmployeeQueryObject extends QueryObject{

	private String keyword;
	private Long deptId=-1L;
	@Override
	protected void CustomizedQuery() {
		if(StringUtil.hasLength(keyword)){
			addCondition("(e.username like ? OR e.nickName like ?)","%"+keyword+"%","%"+keyword+"%");
		}
		if(deptId>0){
			addCondition("e.dept.id = ?",deptId);
		}
	}

}
