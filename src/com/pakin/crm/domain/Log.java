package com.pakin.crm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用于记录用户操作日志
 * @author argo
 */
@Entity
public class Log extends BaseDomain{
	/** 操作用户 */
	@ManyToOne
	@JoinColumn(name="e_id")
	private Employee operator;
	/** 操作时间 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date actionTime; 
	/** 调用方法 */
	private String actionDetail;
	private String ip;


	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Employee getOperator() {
		return operator;
	}
	public void setOperator(Employee operator) {
		this.operator = operator;
	}
	public Date getActionTime() {
		return actionTime;
	}
	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}
	public String getActionDetail() {
		return actionDetail;
	}
	public void setActionDetail(String actionDetail) {
		this.actionDetail = actionDetail;
	}
	
	
	
}
