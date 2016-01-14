package com.pakin.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.PotentialCustomer;
import com.pakin.crm.query.PotentialCustomerQueryObject;
import com.pakin.crm.service.IPotentialCustomerService;
@Service
public class PotentialCustomerServiceImpl extends BaseServiceImpl<PotentialCustomer> implements IPotentialCustomerService{

	@Override
	public ListResult query(PotentialCustomerQueryObject qo) {
		return potentialCustomerDAO.query(qo);
	}
	@Override
	public void delete(PotentialCustomer pc) {
		pc=potentialCustomerDAO.get(pc.getId());
		super.delete(pc);
	}
	@Override
	public List queryForPlan() {
		return potentialCustomerDAO.queryForPlan();
	}
}
