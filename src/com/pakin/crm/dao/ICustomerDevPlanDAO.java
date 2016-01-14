package com.pakin.crm.dao;

import com.pakin.crm.domain.CustomerDevPlan;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerDevPlanQueryObject;

public interface ICustomerDevPlanDAO extends IBaseDAO<CustomerDevPlan>{

	ListResult query(CustomerDevPlanQueryObject qo);

}
