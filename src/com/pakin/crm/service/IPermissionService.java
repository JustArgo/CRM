package com.pakin.crm.service;

import java.util.List;
import java.util.Map;

import com.pakin.crm.domain.Permission;

public interface IPermissionService extends IBaseService<Permission>{

	List<Map> queryPermissionsForRole();

	Permission queryPermissionByResource(String resourceName);

	List<Permission> queryPemissionByEid(Long id);


}
