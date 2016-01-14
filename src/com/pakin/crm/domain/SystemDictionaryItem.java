package com.pakin.crm.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 字典明细
 * @author Pakin
 *
 */
@Entity
@Getter
@Setter
public class SystemDictionaryItem extends BaseDomain{
	@ManyToOne
	@JoinColumn(name="systemDictionary_id")
	private SystemDictionary parent;//字典目录
	private String name;//字典明细名称
	private String sn;//字典明细编号
	private String intro;//字典明细简介
}
