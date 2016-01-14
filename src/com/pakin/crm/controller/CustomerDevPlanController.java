package com.pakin.crm.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.CustomerDevPlan;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerDevPlanQueryObject;

@Controller
public class CustomerDevPlanController extends BaseController{
	/*
	 * 前台往后台传的时间格式（绑定方式）
	 
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/
	
	
	@RequestMapping("/plan_list")
	@ResponseBody
	public ListResult list(CustomerDevPlanQueryObject qo){
		return customerDevPlanService.query(qo);
	}
	@RequestMapping("/plan_save")
	@ResponseBody
	public AjaxResult save(CustomerDevPlan plan){
		AjaxResult rs;
		plan.setInputTime(new Date());
		if(plan.getId()==null){
			try{
			customerDevPlanService.save(plan);
			rs=new AjaxResult("保存成功");
			}catch (Exception e) {
				e.printStackTrace();
				rs=new AjaxResult(false,"保存失败，请联系管理员");
				return rs;
			}
		}else{
			try{
			customerDevPlanService.update(plan);
			rs=new AjaxResult("编辑成功");
			}catch (Exception e) {
				rs=new AjaxResult(false,"编辑失败，请联系管理员");
				e.printStackTrace();
				return rs;
			}
		}
		return rs;
	}
	@ModelAttribute
	public void preSave(@RequestParam(value="id",defaultValue="-1")Long id,Model model){
		if(id!=-1){
		CustomerDevPlan plan=customerDevPlanService.get(id);
		plan.setInputUser(null);
		plan.setPotentialCustomer(null);
		model.addAttribute(plan);
		}
	}
	
	@RequestMapping("/plan")
	public String index(){
		return "customerDevPlan";
	}
	
	
	@RequestMapping("/plan_del")
	@ResponseBody
	public AjaxResult del(CustomerDevPlan plan){
		AjaxResult rs=null;
		if(plan.getId()!=null){
			try{
			customerDevPlanService.delete(plan);
			rs=new AjaxResult("删除成功");
			}catch(Exception e){
				e.printStackTrace();
				rs=new AjaxResult(false,"删除失败，请联系管理员");
				return rs;
			}
		}
		return rs;
	}
	
	
}
