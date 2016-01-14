package com.pakin.crm.service;

import java.util.List;
import java.util.Map;

import com.pakin.crm.domain.Department;
import com.pakin.crm.query.QueryObject;

public interface IDepartmentService extends IBaseService<Department> {

	List<Map> queryDeptsForEmp();
	Map<String, Object> query(QueryObject qo);

	List queryParent();
	void delete(Long id);

}
