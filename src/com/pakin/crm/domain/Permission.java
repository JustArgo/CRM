package com.pakin.crm.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Permission extends BaseDomain {
	private String sn;
	private String name;
	private String resourceName;
}
