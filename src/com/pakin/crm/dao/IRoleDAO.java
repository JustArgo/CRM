package com.pakin.crm.dao;

import java.util.List;
import java.util.Map;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.Role;
import com.pakin.crm.query.QueryObject;

public interface IRoleDAO extends IBaseDAO<Role>{

	ListResult query(QueryObject qo);

	List queryOwnPermission(Long id);

	void removeRelation(Long id);

	List<Map> queryForEmp();

	List<Map> queryRoleByEid(Long eid);



}
