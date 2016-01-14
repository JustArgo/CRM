package com.pakin.crm.query;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import com.pakin.crm.util.DateUtil;

public class LogQueryObject extends QueryObject{

	private String operatorName;
	private Date begindate;
	private Date enddate;
	
	@Override
	protected void CustomizedQuery() {
		if(StringUtils.hasLength(operatorName)){
			super.addCondition("l.operator.userName like ?","%"+operatorName+"%");
		}
		if(begindate!=null){
			super.addCondition("l.actionTime >= ?",begindate);
		}
		if(enddate!=null){
			super.addCondition("l.actionTime <= ?",DateUtil.endOfDay(enddate));
		}
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	

	

	
	
	

}
