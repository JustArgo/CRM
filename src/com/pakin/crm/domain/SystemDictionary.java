package com.pakin.crm.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
/**
 * 字典目录
 * @author Pakin
 *
 */
@Entity
@Getter
@Setter
public class SystemDictionary extends BaseDomain{
	private String sn;//字典目录编号
	private String name;//字典目录名称
	private String intro;//字典目录简介
	private Integer state;//状态
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<SystemDictionaryItem> details;//字典明细
	
}
