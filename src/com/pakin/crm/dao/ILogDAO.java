package com.pakin.crm.dao;

import java.util.List;

import com.pakin.crm.domain.Log;
import com.pakin.crm.query.LogQueryObject;

public interface ILogDAO extends IBaseDAO<Log>{

	Long listCount(LogQueryObject qo);
	List list(LogQueryObject qo);

}
