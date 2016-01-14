package com.pakin.crm.service;

import java.util.List;
import java.util.Map;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.PotentialCustomer;
import com.pakin.crm.query.PotentialCustomerQueryObject;

public interface IPotentialCustomerService extends IBaseService<PotentialCustomer>{

	ListResult query(PotentialCustomerQueryObject qo);

	List queryForPlan();

}
