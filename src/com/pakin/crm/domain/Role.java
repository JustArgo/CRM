package com.pakin.crm.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role extends BaseDomain{
	private String sn;
	private String name;
	@ManyToMany
	@JoinTable(name="roles_permissions",
			joinColumns={@JoinColumn(name="rid")},
			inverseJoinColumns={@JoinColumn(name="pid")}
	)
	private List<Permission> permissions;
	
}
