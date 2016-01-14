package com.pakin.crm.dao;

import java.util.List;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.PotentialCustomer;
import com.pakin.crm.query.PotentialCustomerQueryObject;

public interface IPotentialCustomerDAO extends IBaseDAO<PotentialCustomer>{

	ListResult query(PotentialCustomerQueryObject qo);

	List queryForPlan();

	void updateStatusToCustomer(Long potentialId);

}
