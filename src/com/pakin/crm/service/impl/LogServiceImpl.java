package com.pakin.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pakin.crm.dao.ILogDAO;
import com.pakin.crm.domain.Log;
import com.pakin.crm.query.LogQueryObject;
import com.pakin.crm.service.ILogService;


@Service
public class LogServiceImpl implements ILogService{
	
	@Autowired
	private ILogDAO logDao;
	
	@Override
	public void save(Log log) {
		logDao.save(log);
	}
	
	@Override
	public Long listCount(LogQueryObject qo) {
		return logDao.listCount(qo);
	}
	
	@Override
	public List list(LogQueryObject qo) {
		return logDao.list(qo);
	}

	
	
}
