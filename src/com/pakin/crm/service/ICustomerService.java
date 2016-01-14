package com.pakin.crm.service;

import java.util.List;

import com.pakin.crm.domain.Customer;
import com.pakin.crm.domain.CustomerGc;
import com.pakin.crm.domain.CustomerXs;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerQueryObject;

public interface ICustomerService extends IBaseService<Customer>{

	ListResult query(CustomerQueryObject qo);

	List queryForOrder();

	void save(Customer customer, Long potentialId);

	ListResult findCutomerGx(CustomerQueryObject qo);

	List<CustomerGc> findCustomerGc();

	List<CustomerXs> findCustomerXs();
	

}
