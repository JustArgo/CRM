package com.pakin.crm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.PotentialCustomer;
import com.pakin.crm.query.PotentialCustomerQueryObject;

@Controller
public class PotentialCustomerController extends BaseController{
	
	
	
	@RequestMapping("/pc_list")
	@ResponseBody
	public ListResult list(PotentialCustomerQueryObject qo){
		return potentialCustomerService.query(qo);
	}
	@RequestMapping("/pc_save")
	@ResponseBody
	public AjaxResult save(PotentialCustomer pc){
		AjaxResult rs;
		pc.setInputTime(new Date());
		if(pc.getId()==null){
			try{
			potentialCustomerService.save(pc);
			rs=new AjaxResult("保存成功");
			}catch (Exception e) {
				e.printStackTrace();
				rs=new AjaxResult(false,"保存失败，请联系管理员");
				return rs;
			}
		}else{
			try{
			potentialCustomerService.update(pc);
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
		PotentialCustomer pc=potentialCustomerService.get(id);
		pc.setInputUser(null);
		model.addAttribute(pc);
		}
	}
	
	@RequestMapping("/pc")
	public String index(){
		return "potentialCustomer";
	}
	
	
	@RequestMapping("/pc_del")
	@ResponseBody
	public AjaxResult del(PotentialCustomer pc){
		AjaxResult rs=null;
		if(pc.getId()!=null){
			try{
			potentialCustomerService.delete(pc);
			rs=new AjaxResult("删除成功");
			}catch(Exception e){
				e.printStackTrace();
				rs=new AjaxResult(false,"删除失败，请联系管理员");
				return rs;
			}
		}
		return rs;
	}
	@RequestMapping("/potential_queryForPlan")
	@ResponseBody
	public List queryForPlan(){
		return potentialCustomerService.queryForPlan();
	}
	
}
