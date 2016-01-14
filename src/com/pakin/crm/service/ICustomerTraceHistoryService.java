package com.pakin.crm.service;

import com.pakin.crm.domain.CustomerTraceHistory;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTraceHistoryQueryObject;

public interface ICustomerTraceHistoryService extends IBaseService<CustomerTraceHistory>{

	ListResult query(CustomerTraceHistoryQueryObject qo);

}
