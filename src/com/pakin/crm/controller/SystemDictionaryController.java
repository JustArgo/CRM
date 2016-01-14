package com.pakin.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.AjaxResult;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.SystemDictionary;
import com.pakin.crm.query.SystemDictionaryQueryObject;

@Controller
public class SystemDictionaryController extends BaseController{
	@RequestMapping("/dictionary_list")
	@ResponseBody
	public ListResult list(SystemDictionaryQueryObject qo){
		return systemDictionaryService.query(qo);
	}
	@RequestMapping("/dictionary_save")
	@ResponseBody
	public AjaxResult save(SystemDictionary dictionary){
		AjaxResult rs;
		if(dictionary.getId()==null){
			try{
			systemDictionaryService.save(dictionary);
			rs=new AjaxResult("保存成功");
			}catch (Exception e) {
				e.printStackTrace();
				rs=new AjaxResult(false,"保存失败，请联系管理员");
				return rs;
			}
		}else{
			try{
			systemDictionaryService.update(dictionary);
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
		SystemDictionary dictionary=systemDictionaryService.get(id);
		model.addAttribute(dictionary);
		}
	}
	
	@RequestMapping("/dictionary")
	public String index(){
		return "systemDictionary";
	}
	
	
	@RequestMapping("/dictionary_del")
	@ResponseBody
	public AjaxResult del(SystemDictionary dictionary){
		AjaxResult rs=null;
		if(dictionary.getId()!=null){
			try{
			systemDictionaryService.delete(dictionary);
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
