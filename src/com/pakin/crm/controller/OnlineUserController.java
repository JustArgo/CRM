package com.pakin.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pakin.crm.domain.Employee;
import com.pakin.crm.listener.OnlineCounter;

@Controller
public class OnlineUserController{
	@RequestMapping("/countOnlineUser")
	@ResponseBody
	public Integer CountOnlineUser(HttpSession session){
			Employee user=(Employee)session.getAttribute("USER_IN_SESSION");
		       OnlineCounter.allUser(user);
		 int onlineAllCount = OnlineCounter.getOnlineAllCount();
		 return onlineAllCount;
	}
}
