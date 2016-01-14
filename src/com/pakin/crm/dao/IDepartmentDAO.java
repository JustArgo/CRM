package com.pakin.crm.dao;

import java.util.List;
import java.util.Map;

import com.pakin.crm.domain.Department;
import com.pakin.crm.query.QueryObject;

public interface IDepartmentDAO {

	List<Map> queryDeptsForEmp();

	Map<String, Object> query(QueryObject qo);

	List<Map> getParent();

	void removeRelation(Long id);


}
