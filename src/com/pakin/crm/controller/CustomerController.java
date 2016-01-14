package com.pakin.crm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.Customer;
import com.pakin.crm.domain.CustomerGc;
import com.pakin.crm.domain.CustomerXs;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerQueryObject;

@Controller
public class CustomerController extends BaseController{
	/*
	 * 前台往后台传的时间格式（绑定方式）
	 
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/
	
	
	@RequestMapping("/customer_list")
	@ResponseBody
	public ListResult list(CustomerQueryObject qo){
		return customerService.query(qo);
	}
	@RequestMapping("/customer_save")
	@ResponseBody
	public AjaxResult save(Customer customer,Long potentialId){
		AjaxResult rs;
		customer.setInputTime(new Date());
		if(customer.getSeller().getId()==null){
			customer.setSeller(null);
		}
		if(customer.getId()==null){
			try{
			customerService.save(customer,potentialId);
			rs=new AjaxResult("保存成功");
			}catch (Exception e) {
				e.printStackTrace();
				rs=new AjaxResult(false,"保存失败，请联系管理员");
				return rs;
			}
		}else{
			try{
			customerService.update(customer);
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
		Customer customer=customerService.get(id);
		customer.setInputUser(null);
		customer.setSeller(null);
		model.addAttribute(customer);
		}
	}
	
	@RequestMapping("/customer")
	public String index(){
		return "customer";
	}
	@RequestMapping("/customerGX")
	public String customerGX(){
		return "khgxfx";
	}
	@RequestMapping("/customerGC")
	public String customerGC(){
		return "khgcfx";
	}
	
	@RequestMapping("/customerXs")
	public String customerXs(){
		return "ygxsfx";
	}
	
	@RequestMapping("/customer_queryForOrder")
	@ResponseBody
	public List queryForOrder(){
		return customerService.queryForOrder();
	}
	
	@RequestMapping("/customer_del")
	@ResponseBody
	public AjaxResult del(Customer customer){
		AjaxResult rs=null;
		if(customer.getId()!=null){
			try{
			customerService.delete(customer);
			rs=new AjaxResult("删除成功");
			}catch(Exception e){
				e.printStackTrace();
				rs=new AjaxResult(false,"删除失败，请联系管理员");
				return rs;
			}
		}
		return rs;
	}
	
	//--------------客户贡献----------------------
	@RequestMapping("/customer/findCutomerGx")
	@ResponseBody
	public ListResult findCutomerGx(CustomerQueryObject qo)throws Exception{
		return customerService.findCutomerGx(qo);
	}
	//--------------客户构成-----------------
	@RequestMapping("/customer/findCutomerGc")
	@ResponseBody
	public List<CustomerGc> findCustomerGc()throws Exception{
		 return customerService.findCustomerGc();
	}
	//---------员工拥有的客户占比----------
	@RequestMapping("/customer/findCutomerXs")
	@ResponseBody
	public List<CustomerXs> findCustomerXs()throws Exception{
		return customerService.findCustomerXs();
	}
}
