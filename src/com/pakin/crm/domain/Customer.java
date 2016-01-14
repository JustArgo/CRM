package com.pakin.crm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
/**
 * 客户信息对象
 * @author Pakin
 *
 */
public class Customer extends BaseDomain {
	//基本信息
	private String name;//客户姓名
	private Integer age;
	private Integer gender;//性别  0 代表女，1代表男
	private String level;//客户等级
	//联系方式
	private String tel;//电话号码
	private String email;
	private String qq;
	private String wechat;//微信
	
	//扩展信息
	@ManyToOne
	@JoinColumn(name="seller_id")
	private Employee seller;//营销人员
	private String job;//职业
	private String salaryLevel;//收入水平
	private String customerSource;//客户来源
	@ManyToOne
	@JoinColumn(name="input_id")
	private Employee inputUser;//创建人
	@Temporal(TemporalType.TIMESTAMP)
	private Date inputTime;//创建时间
}
