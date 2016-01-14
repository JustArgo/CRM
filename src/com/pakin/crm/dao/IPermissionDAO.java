package com.pakin.crm.dao;

import java.util.List;
import java.util.Map;

import com.pakin.crm.domain.Permission;

public interface IPermissionDAO extends IBaseDAO<Permission>{

	List<Map> queryPermissionsForRole();

	Permission queryPermissionByResource(String resourceName);

	List<Permission> queryPemissionByEid(Long id);

}
