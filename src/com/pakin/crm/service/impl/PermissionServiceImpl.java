package com.pakin.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.Permission;
import com.pakin.crm.service.IPermissionService;
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {

	@Override
	public List<Map> queryPermissionsForRole() {
		return permissionDAO.queryPermissionsForRole();
	}

	@Override
	public Permission queryPermissionByResource(String resourceName) {
		return permissionDAO.queryPermissionByResource(resourceName);
	}

	@Override
	public List<Permission> queryPemissionByEid(Long id) {
		return permissionDAO.queryPemissionByEid(id);
	}

}
