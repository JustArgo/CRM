package com.pakin.crm.service;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.SystemDictionary;
import com.pakin.crm.query.SystemDictionaryQueryObject;

public interface ISystemDictionaryService extends IBaseService<SystemDictionary>{

	ListResult query(SystemDictionaryQueryObject qo);

}
