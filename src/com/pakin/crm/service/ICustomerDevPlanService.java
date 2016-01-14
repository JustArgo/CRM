package com.pakin.crm.service;

import com.pakin.crm.domain.CustomerDevPlan;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerDevPlanQueryObject;

public interface ICustomerDevPlanService extends IBaseService<CustomerDevPlan>{

	ListResult query(CustomerDevPlanQueryObject qo);

}
