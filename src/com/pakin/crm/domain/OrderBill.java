package com.pakin.crm.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单管理(定金订单)
 * @author Pakin
 *
 */
@Getter
@Setter
@Entity
public class OrderBill extends BaseDomain{
	private String sn;//定金单号
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;//定金客户
	@Temporal(TemporalType.TIMESTAMP)
	private Date signTime;//签订时间
	@ManyToOne
	@JoinColumn(name="seller_id")
	private Employee seller;//销售人员
	private BigDecimal sum;//定金金额
	private String intro;//摘要
}
