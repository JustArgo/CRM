package com.pakin.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.OrderBill;
import com.pakin.crm.query.OrderQueryObject;

@Controller
public class OrderController extends BaseController{
	
	
	
	@RequestMapping("/order_list")
	@ResponseBody
	public ListResult list(OrderQueryObject qo){
		return orderService.query(qo);
	}
	@RequestMapping("/order_save")
	@ResponseBody
	public AjaxResult save(OrderBill order){
		AjaxResult rs;
		if(order.getId()==null){
			try{
			orderService.save(order);
			rs=new AjaxResult("保存成功");
			}catch (Exception e) {
				e.printStackTrace();
				rs=new AjaxResult(false,"保存失败，请联系管理员");
				return rs;
			}
		}else{
			try{
			orderService.update(order);
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
		OrderBill order=orderService.get(id);
		order.setSeller(null);
		order.setCustomer(null);
		model.addAttribute(order);
		}
	}
	
	@RequestMapping("/order")
	public String index(){
		return "orderBill";
	}
	
	
	@RequestMapping("/order_del")
	@ResponseBody
	public AjaxResult del(OrderBill order){
		AjaxResult rs=null;
		if(order.getId()!=null){
			try{
			orderService.delete(order);
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
		return orderService.queryForPlan();
	}*/
	
}
