package com.pakin.crm.dao;

import com.pakin.crm.domain.CustomerTraceHistory;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTraceHistoryQueryObject;

public interface ICustomerTraceHistoryDAO extends IBaseDAO<CustomerTraceHistory>{

	ListResult query(CustomerTraceHistoryQueryObject qo);
}
