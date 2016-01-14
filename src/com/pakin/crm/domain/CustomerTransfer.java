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
 * 客户移交记录
 * @author Pakin
 */
@Getter
@Setter
@Entity
public class CustomerTransfer extends BaseDomain{
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;//客户
	@ManyToOne
	@JoinColumn(name="transUser_id")
	private Employee transUser;//移交人员
	@Temporal(TemporalType.TIMESTAMP)
	private Date transTime;//移交时间
	@ManyToOne
	@JoinColumn(name="oldSeller_id")
	private Employee oldSeller;//老市场专员
	@ManyToOne
	@JoinColumn(name="newSeller_id")
	private Employee newSeller;//新市场专员
	private String transReason;//移交原因
}
