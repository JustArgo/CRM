package com.pakin.crm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.CustomerTraceHistory;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTraceHistoryQueryObject;

@Controller
public class CustomerTraceHistoryController extends BaseController{
	@RequestMapping("/customerTrace_list")
	@ResponseBody
	public ListResult list(CustomerTraceHistoryQueryObject qo){
		return customerTraceHistorySevice.query(qo);
	}
	@RequestMapping("/customerTrace_save")
	@ResponseBody
	public AjaxResult save(CustomerTraceHistory customerTrace){
		AjaxResult rs;
		if(customerTrace.getId()==null){
			try{
			customerTraceHistorySevice.save(customerTrace);
			rs=new AjaxResult("保存成功");
			}catch (Exception e) {
				e.printStackTrace();
				rs=new AjaxResult(false,"保存失败，请联系管理员");
				return rs;
			}
		}else{
			try{
			customerTraceHistorySevice.update(customerTrace);
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
		CustomerTraceHistory customerTrace=customerTraceHistorySevice.get(id);
		customerTrace.setCustomer(null);
		customerTrace.setTraceUser(null);
		model.addAttribute(customerTrace);
		}
	}
	
	@RequestMapping("/customerTrace")
	public String index(){
		return "customerTraceHistory";
	}
	
	
	@RequestMapping("/customerTrace_del")
	@ResponseBody
	public AjaxResult del(CustomerTraceHistory customerTrace){
		AjaxResult rs=null;
		if(customerTrace.getId()!=null){
			try{
			customerTraceHistorySevice.delete(customerTrace);
			rs=new AjaxResult("删除成功");
			}catch(Exception e){
				e.printStackTrace();
				rs=new AjaxResult(false,"删除失败，请联系管理员");
				return rs;
			}
		}
		return rs;
	}
	/*@RequestMapping("/potential_queryForPlan")
	@ResponseBody
	public List queryForPlan(){
		return customerTraceHistorySevice.queryForPlan();
	}*/
	
}
