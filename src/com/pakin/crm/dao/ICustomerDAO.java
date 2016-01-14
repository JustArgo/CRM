package com.pakin.crm.dao;

import java.util.List;

import com.pakin.crm.domain.Customer;
import com.pakin.crm.domain.CustomerGc;
import com.pakin.crm.domain.CustomerTransfer;
import com.pakin.crm.domain.CustomerXs;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerQueryObject;

public interface ICustomerDAO extends IBaseDAO<Customer>{

	ListResult query(CustomerQueryObject qo);

	List queryForOrder();

	void updateSeller(CustomerTransfer ct);

	ListResult queryGx(CustomerQueryObject qo);

	List<CustomerGc> queryGc();

	List<CustomerXs> queryXs();


}
