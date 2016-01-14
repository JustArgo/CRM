package com.pakin.crm.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends BaseDomain{
	
	private String username;
	private String password;
	private String nickName;
	private String email;
	private Integer status;//0离职 1正常
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department dept;
	@OneToOne(mappedBy="manager")
	private Department mdept;
	@ManyToMany
	@JoinTable(name="employees_roles",
		joinColumns={@JoinColumn(name="eid")},
		inverseJoinColumns={@JoinColumn(name="rid")})
	private List<Role> roles;
	

	
	
}
