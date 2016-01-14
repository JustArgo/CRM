package com.pakin.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pakin.crm.query.QueryObject;
import com.pakin.crm.service.ICustomerDevPlanService;
import com.pakin.crm.service.ICustomerService;
import com.pakin.crm.service.ICustomerTraceHistoryService;
import com.pakin.crm.service.ICustomerTransferService;
import com.pakin.crm.service.IDepartmentService;
import com.pakin.crm.service.IEmployeeService;
import com.pakin.crm.service.IOrderBillService;
import com.pakin.crm.service.IPermissionService;
import com.pakin.crm.service.IPotentialCustomerService;
import com.pakin.crm.service.IRoleService;
import com.pakin.crm.service.ISystemDictionaryService;

@Controller
public class BaseController {
	@Autowired
	 IEmployeeService employeeService;
	@Autowired
	IDepartmentService departmentService;
	@Autowired
	IRoleService roleService;
	@Autowired
	IPermissionService permissionService;
	@Autowired
	IPotentialCustomerService potentialCustomerService;
	@Autowired
	ICustomerDevPlanService customerDevPlanService;
	@Autowired
	ICustomerService customerService;
	@Autowired
	ICustomerTraceHistoryService customerTraceHistorySevice;
	@Autowired
	ICustomerTransferService customerTransferService;
	@Autowired
	ISystemDictionaryService systemDictionaryService;
	@Autowired
	IOrderBillService orderService;
	@Autowired
	QueryObject qo;
}
