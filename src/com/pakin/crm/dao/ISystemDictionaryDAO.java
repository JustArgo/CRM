package com.pakin.crm.dao;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.SystemDictionary;
import com.pakin.crm.query.SystemDictionaryQueryObject;

public interface ISystemDictionaryDAO extends IBaseDAO<SystemDictionary>{

	ListResult query(SystemDictionaryQueryObject qo);

}
