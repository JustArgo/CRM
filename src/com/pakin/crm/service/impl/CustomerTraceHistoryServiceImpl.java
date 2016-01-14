package com.pakin.crm.service.impl;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.CustomerTraceHistory;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTraceHistoryQueryObject;
import com.pakin.crm.service.ICustomerTraceHistoryService;
@Service
public class CustomerTraceHistoryServiceImpl extends BaseServiceImpl<CustomerTraceHistory> implements ICustomerTraceHistoryService{

	@Override
	public ListResult query(CustomerTraceHistoryQueryObject qo) {
		return customerTraceHistoryDAO.query(qo);
	}
	@Override
	public void delete(CustomerTraceHistory pc) {
		pc=customerTraceHistoryDAO.get(pc.getId());
		super.delete(pc);
	}
	
	
}
