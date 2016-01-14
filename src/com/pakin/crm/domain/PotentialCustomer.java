package com.pakin.crm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pakin.crm.util.CustomDateFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 潜在客户对象
 * @author  Pakin
 *
 */
@Entity
public class PotentialCustomer extends BaseDomain{
	private String customerSource;//客户来源
	private String name;//客户名称
	private Integer successRate;//成功机率
	private String remark;//客户描述
	private String linkMan;//联系人
	private String linkManTel;//联系人电话
	@ManyToOne
	@JoinColumn(name="eid")
	private Employee inputUser;//负责人
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@JsonSerialize(using=CustomDateFormat.class)
	private Date inputTime;//创建时间
	private Integer isCustomerStatus=0;//0代表潜在用户  1代表正式用户 -1代表开发失败用户
}
