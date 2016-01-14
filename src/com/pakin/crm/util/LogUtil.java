package com.pakin.crm.util;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pakin.crm.domain.Employee;
import com.pakin.crm.domain.Log;
import com.pakin.crm.service.ILogService;

/**
 * 日志记录
 * @author Pakin
 *
 */
@Component
public class LogUtil {
	@Autowired
	ILogService logService;

	public void writeLog(JoinPoint joinPoint) {
		HttpSession session = ActionContext.get();
		Log log = new Log();
		Employee emp = (Employee) session.getAttribute("USER_IN_SESSION");
		log.setOperator(emp);
		log.setActionTime(new Date());
		log.setIp(session.getAttribute("IP_IN_SESSION").toString());
		log.setActionDetail(joinPoint.getTarget().getClass().getName() + ":"
				+ joinPoint.getSignature().getName());
		if (joinPoint.getTarget() instanceof ILogService) {
			return;
		}
		logService.save(log);
	}
}
