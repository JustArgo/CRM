package com.pakin.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.Role;
import com.pakin.crm.query.QueryObject;
import com.pakin.crm.service.IRoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService{

	@Override
	public ListResult query(QueryObject qo) {
		return roleDAO.query(qo);
	}

	@Override
	public List queryOwnPermission(Long id) {
		return roleDAO.queryOwnPermission(id);
	}

	@Override
	public void delete(Long id) {
		//roleDAO.removeRelation(id);
		Role role = super.get(id);
		super.delete(role);
		
	}

	@Override
	public List<Map> queryForEmp() {
		return roleDAO.queryForEmp();
	}

	@Override
	public List<Map> queryRoleByEid(Long eid) {
		return roleDAO.queryRoleByEid(eid);
	}

}
