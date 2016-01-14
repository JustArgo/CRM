package com.pakin.crm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户跟进历史对象
 * @author Pakin
 */
@Getter
@Setter
@Entity
public class CustomerTraceHistory extends BaseDomain{
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;//跟进的哪一个客户
	@ManyToOne
	@JoinColumn(name="traceUser_id")
	private Employee traceUser;//跟进人
	@Temporal(TemporalType.TIMESTAMP)
	private Date traceTime;//跟进时间
	private String traceType;//跟进方式
	private Integer traceResult;//跟进效果 数字代表：1优   2中  3差
	private String title;//跟进主题
	private String remark;//备注
}
