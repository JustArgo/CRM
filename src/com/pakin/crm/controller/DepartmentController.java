package com.pakin.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.Department;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.Node;
import com.pakin.crm.query.QueryObject;

@Controller
public class DepartmentController extends BaseController{

	@RequestMapping("/depts_forEmp")
	@ResponseBody
	public List QueryDeptsForEmp(){
		List<Map> depts=new ArrayList<>();
		depts=departmentService.queryDeptsForEmp();
		return depts;
	}
	@RequestMapping("/department")
	public String index(){
		return "department";
	}
	@RequestMapping("/department_queryParentForDept")
	@ResponseBody
	public List<Node> queryParentForDept(){
		return departmentService.queryParent();
	}
	
	@RequestMapping("/department_list")
	@ResponseBody
	public Map<String,Object> list(QueryObject qo){
		
		return departmentService.query(qo);
	}
	@RequestMapping("/department_save")
	@ResponseBody
	public AjaxResult save(Department dept){
		AjaxResult ar;
		if(dept.getManager().getId()==null){
			dept.setManager(null);
		}if(dept.getParent().getId()==null){
			dept.setParent(null);
		}
		try{
			departmentService.save(dept);
			ar=new AjaxResult("保存成功");
			
		}catch(Exception e){
			e.printStackTrace();
			ar=new AjaxResult(false,"保存失败");
		}
		return ar;
	}
	@RequestMapping("/department_update")
	@ResponseBody
	public AjaxResult update(Department dept){
		AjaxResult ar;
		if(dept.getManager().getId()==null){
			dept.setManager(null);
		}if(dept.getParent().getId()==null){
			dept.setParent(null);
		}
		try{
			departmentService.update(dept);
			ar=new AjaxResult("编辑成功");
		}catch(Exception e){
			e.printStackTrace();
			ar=new AjaxResult(false,"编辑失败");
		}
		return ar;
	}
	
	@ModelAttribute
	public void preSave(@RequestParam(value="id",defaultValue="-1")Long id,Model model){
		if(id!=-1){
			Department department=departmentService.get(id);
		
		model.addAttribute(department);
		}
	}
	@RequestMapping("/department_del")
	@ResponseBody
	public Map del(Long id){
		Map<String,Object> map=new HashMap<>();
			try{
			departmentService.delete(id);
			map.put("success",true);
			map.put("msg", "删除成功");
			}catch(Exception e){
				e.printStackTrace();
				map.put("success", false);
				map.put("msg","删除失败，请联系管理员");
			}
		return map;
	}
	@RequestMapping("/queryManagerForDept")
	@ResponseBody
	public ListResult queryForDept(){
		return employeeService.queryForDept();
	}

}
