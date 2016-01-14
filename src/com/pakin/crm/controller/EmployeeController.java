package com.pakin.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.Employee;
import com.pakin.crm.query.EmployeeQueryObject;
import com.pakin.crm.service.IEmployeeService;

@Controller
public class EmployeeController extends BaseController{
	
	
	@RequestMapping("/login")
	@ResponseBody
	public AjaxResult login(String username,String password,HttpServletRequest request){
		return employeeService.login(username,password);
	}
	
	
	@RequestMapping("/employee_list")
	@ResponseBody
	public Map<String,Object> list(EmployeeQueryObject qo){
		Map<String,Object> map = new HashMap<String,Object>;
		map = employeeService.query(qo)
		return map;
	}
	@RequestMapping("/employee_save")
	@ResponseBody
	public Map save(Employee emp){
		Map<String,Object> map=new HashMap<>();
		if(emp.getDept().getId()==null){
			emp.setDept(null);
		}
		if(emp.getId()==null){
			try{
				emp.setPassword("666666");
				emp.setStatus(1);
			employeeService.save(emp);
			map.put("success", true);
			map.put("msg","保存成功");
			return map;
			}catch (Exception e) {
				map.put("success", false);
				map.put("msg","保存失败，请联系管理员");
				e.printStackTrace();
				return map;
			}
		}else{
			try{
			employeeService.update(emp);
			map.put("success", true);
			map.put("msg","编辑成功");
			return map;
			}catch (Exception e) {
				map.put("success", false);
				map.put("msg","编辑失败，请联系管理员");
				e.printStackTrace();
				return map;
			}
		}
	}
	
	@ModelAttribute
	public void preSave(@RequestParam(value="id",defaultValue="-1")Long id,Model model){
		if(id!=-1){
		Employee emp=employeeService.get(id);
		emp.setRoles(null);
		model.addAttribute(emp);
		}
	}
	
	@RequestMapping("/employee")
	public String index(){
		return "employee";
	}
	
	/**
	 * 把员工离职
	 * @param id
	 * @return
	 */
	@RequestMapping("/employee_del")
	@ResponseBody
	public Map updateStatus(@RequestParam(value="id",defaultValue="-1")Long id){
		Map<String,Object> map=new HashMap<>();
		if(id!=-1){
			try{
			employeeService.updateStatus(id);
			map.put("success",true);
			map.put("msg", "删除成功");
			}catch(Exception e){
				e.printStackTrace();
				map.put("success", false);
				map.put("msg","删除失败，请联系管理员");
			}
		}
		return map;
	}
	
	@RequestMapping("/employee_queryForCustomer")
	@ResponseBody
	public List queryForCustomer(){
		return employeeService.queryForCustomer();
	}
	
	@RequestMapping("/employee_shuffle")
	@ResponseBody
	public Map<String,Object> shuffle(){
		
		return new HashMap<String,Object>();
		
	}
	
}
