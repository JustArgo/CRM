package com.pakin.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.Customer;
import com.pakin.crm.domain.CustomerGc;
import com.pakin.crm.domain.CustomerXs;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerQueryObject;
import com.pakin.crm.service.ICustomerService;
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService{
	
	@Override
	public ListResult query(CustomerQueryObject qo) {
		return customerDAO.query(qo);
	}
	@Override
	public void delete(Customer pc) {
		pc=customerDAO.get(pc.getId());
		super.delete(pc);
	}
	@Override
	public List queryForOrder() {
		return customerDAO.queryForOrder();
	}
	@Override
	public void save(Customer customer, Long potentialId) {
		super.save(customer);
		potentialCustomerDAO.updateStatusToCustomer(potentialId);
		
	}
	@Override
	public ListResult findCutomerGx(CustomerQueryObject qo) {
		return customerDAO.queryGx(qo);
	}
	@Override
	public List<CustomerGc> findCustomerGc() {
		return customerDAO.queryGc();
	}
	@Override
	public List<CustomerXs> findCustomerXs() {
		return customerDAO.queryXs();
	}
}
