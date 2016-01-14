package com.pakin.crm.service;

import java.util.List;

import com.pakin.crm.domain.Log;
import com.pakin.crm.query.LogQueryObject;

public interface ILogService {
	void save(Log log);
	Long listCount(LogQueryObject qo);
	List list(LogQueryObject qo);
}
