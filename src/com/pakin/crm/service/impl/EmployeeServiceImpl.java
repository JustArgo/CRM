package com.pakin.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.Employee;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.Permission;
import com.pakin.crm.query.QueryObject;
import com.pakin.crm.service.IEmployeeService;
import com.pakin.crm.service.IPermissionService;
import com.pakin.crm.util.ActionContext;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService{
	@Autowired
	private IPermissionService permissionService;
	
	@Override
	public Map<String, Object> query(QueryObject qo) {
		
		return employeeDAO.query(qo);
	}
	@Override
	public void updateStatus(Long id) {
		employeeDAO.updateStatus(id);
	}
	@Override
	public ListResult queryForDept() {
		return employeeDAO.queryForDept();
	}
	@Override
	public AjaxResult login(String username, String password) {
		try{
		Employee emp=employeeDAO.login(username,password);
		if(emp!=null){
			ActionContext.get().setAttribute("USER_IN_SESSION",emp);
			//查询登陆用户的权限集合
			List<Permission> pemissions =permissionService.queryPemissionByEid(emp.getId());
			ActionContext.get().setAttribute("PERMISSION_IN_SESSION", pemissions);
			return new AjaxResult("登录成功");
		}else{
			return new AjaxResult(false,"账号或密码有误");
		}
		}catch(Exception e){
			e.printStackTrace();
			return new AjaxResult(false,e.getMessage());
		}
	}
	@Override
	public List queryForCustomer() {
		return employeeDAO.queryForCustomer();
	}

}
