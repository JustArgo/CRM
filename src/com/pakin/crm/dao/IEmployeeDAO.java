package com.pakin.crm.dao;

import java.util.List;
import java.util.Map;

import com.pakin.crm.domain.Employee;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.QueryObject;

public interface IEmployeeDAO {
	void save(Employee emp);

	Map<String, Object> query(QueryObject qo);

	void update(Employee emp);

	Employee get(Long id);

	void updateStatus(Long id);

	ListResult queryForDept();

	Employee login(String username, String password);

	List queryForCustomer();
}
