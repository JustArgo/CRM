package com.pakin.crm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * (潜在)客户开发计划对象
 * @author Pakin
 *
 */
@Entity
@Getter
@Setter
public class CustomerDevPlan extends BaseDomain{
	@Temporal(TemporalType.TIMESTAMP)
	private Date planTime;//计划时间
	private String planSubject;//计划主题
	private String planDetails;//计划内容
	private String planType;//计划实施方式
	@OneToOne
	@JoinColumn(name="potentialCustomer_id")
	private PotentialCustomer potentialCustomer;//潜在用户
	@ManyToOne
	@JoinColumn(name="inputUser_id")
	private Employee inputUser;//创建人
	@Temporal(TemporalType.TIMESTAMP)
	private Date inputTime;//创建时间
}
