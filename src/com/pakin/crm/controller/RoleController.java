package com.pakin.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.Role;
import com.pakin.crm.query.QueryObject;

@Controller
public class RoleController extends BaseController{

	@RequestMapping("/role")
	public String index(){
		return "role";
	}
	
	@RequestMapping("/role_list")
	@ResponseBody
	public ListResult list(QueryObject qo){
		return roleService.query(qo);
	}
	@RequestMapping("/role_save")
	@ResponseBody
	public AjaxResult save(Role role){
		AjaxResult ar;
		if(role.getPermissions()==null){
			role.setPermissions(null);
		}
		try{
			roleService.save(role);
			ar=new AjaxResult("保存成功");
			
		}catch(Exception e){
			e.printStackTrace();
			ar=new AjaxResult(false,"保存失败");
		}
		return ar;
	}
	@RequestMapping("/role_queryForEmp")
	@ResponseBody
	public List<Map> queryForEmp(){
		return roleService.queryForEmp();
	}
	
	@RequestMapping("/role_queryRoleByEid")
	@ResponseBody
	public List queryRoleByEid(Long eid){
		return roleService.queryRoleByEid(eid);
	}
	
	/*
	 * 根据角色id查询所拥有的权限
	 */
	@RequestMapping("/role_queryOwnPermission")
	@ResponseBody
	public List queryOwnPermission(@RequestParam(value="id",defaultValue="-1") Long id){
		if(id>0){
			return roleService.queryOwnPermission(id);
		}
		return null;
		
	}
	
	@RequestMapping("/role_update")
	@ResponseBody
	public AjaxResult update(Role role){
		AjaxResult ar;
		try{
			roleService.update(role);
			ar=new AjaxResult("编辑成功");
		}catch(Exception e){
			e.printStackTrace();
			ar=new AjaxResult(false,"编辑失败");
		}
		return ar;
	}
	
	
	@RequestMapping("/role_del")
	@ResponseBody
	public AjaxResult del(Long id){
			try{
			roleService.delete(id);
			}catch(Exception e){
				e.printStackTrace();
				return new AjaxResult(false, "删除失败，请联系管理员");
			}
			return new AjaxResult("删除成功");
	}

}
