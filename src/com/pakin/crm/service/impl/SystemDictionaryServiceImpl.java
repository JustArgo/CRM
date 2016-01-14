package com.pakin.crm.service.impl;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.SystemDictionary;
import com.pakin.crm.query.SystemDictionaryQueryObject;
import com.pakin.crm.service.ISystemDictionaryService;

@Service
public class SystemDictionaryServiceImpl extends BaseServiceImpl<SystemDictionary> implements ISystemDictionaryService
{

	@Override
	public ListResult query(SystemDictionaryQueryObject qo) {
		return systemDictionaryDAO.query(qo);
	}
	
}
