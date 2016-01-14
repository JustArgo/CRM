package com.pakin.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class PermissionController extends BaseController{
	@RequestMapping("/permisson_queryPermissionisForRole")
	@ResponseBody
	public List<Map> querPermissionisForRole(){
		return permissionService.queryPermissionsForRole();
	}
	
}
