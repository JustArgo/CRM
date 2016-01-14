package com.pakin.crm.service.impl;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.CustomerDevPlan;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerDevPlanQueryObject;
import com.pakin.crm.service.ICustomerDevPlanService;
@Service
public class CustomerDevPlanServiceImpl extends BaseServiceImpl<CustomerDevPlan> implements ICustomerDevPlanService{

	@Override
	public ListResult query(CustomerDevPlanQueryObject qo) {
		return customerDevPlanDAO.query(qo);
	}
	@Override
	public void delete(CustomerDevPlan pc) {
		pc=customerDevPlanDAO.get(pc.getId());
		super.delete(pc);
	}
}
