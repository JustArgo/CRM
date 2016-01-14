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
import com.pakin.crm.domain.CustomerTransfer;
import com.pakin.crm.query.CustomerTransferQueryObject;

@Controller
public class CustomerTransferController extends BaseController{
	@RequestMapping("/customerTransfer_list")
	@ResponseBody
	public ListResult list(CustomerTransferQueryObject qo){
		return customerTransferService.query(qo);
	}
	@RequestMapping("/customerTransfer_save")
	@ResponseBody
	public AjaxResult save(CustomerTransfer customerTransfer){
		AjaxResult rs=null;
		if(customerTransfer.getId()==null){
			try{
			customerTransferService.save(customerTransfer);
			rs=new AjaxResult("保存成功");
			}catch (Exception e) {
				e.printStackTrace();
				rs=new AjaxResult(false,"保存失败，请联系管理员");
				return rs;
			}
		}
		return rs;
	}
	@ModelAttribute
	public void preSave(@RequestParam(value="id",defaultValue="-1")Long id,Model model){
		if(id!=-1){
		CustomerTransfer customerTransfer=customerTransferService.get(id);
		model.addAttribute(customerTransfer);
		}
	}
	
	@RequestMapping("/customerTransfer")
	public String index(){
		return "customerTransfer";
	}
	
	/*@RequestMapping("/potential_queryForPlan")
	@ResponseBody
	public List queryForPlan(){
		return customerTransferService.queryForPlan();
	}*/
	
}
