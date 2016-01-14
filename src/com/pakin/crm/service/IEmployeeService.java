package com.pakin.crm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.Employee;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.QueryObject;

public interface IEmployeeService extends IBaseService<Employee> {
	Map<String, Object> query(QueryObject qo);
	void updateStatus(Long id);
	ListResult queryForDept();
	AjaxResult login(String username, String password);
	List queryForCustomer();
}
