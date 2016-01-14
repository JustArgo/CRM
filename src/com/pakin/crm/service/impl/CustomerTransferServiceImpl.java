package com.pakin.crm.service.impl;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.CustomerTransfer;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTransferQueryObject;
import com.pakin.crm.service.ICustomerTransferService;
@Service
public class CustomerTransferServiceImpl extends BaseServiceImpl<CustomerTransfer> implements ICustomerTransferService{

	@Override
	public ListResult query(CustomerTransferQueryObject qo) {
		return customerTransferDAO.query(qo);
	}
	@Override
	public void delete(CustomerTransfer pc) {
		pc=customerTransferDAO.get(pc.getId());
		super.delete(pc);
	}
	
	@Override
	public void save(CustomerTransfer ct) {
		super.save(ct);
		customerDAO.updateSeller(ct);
	}
}
