package com.pakin.crm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.LogQueryObject;
import com.pakin.crm.service.ILogService;

@Controller
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private ILogService logService;
	
	@RequestMapping("/index")
	public String index(){
		return "log";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public ListResult list(LogQueryObject qo){
		try{
			Long count = logService.listCount(qo);
			List list = logService.list(qo);
			return new ListResult(count.intValue(),list);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ListResult(0,new ArrayList());
	}
	
}
