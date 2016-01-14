package com.pakin.crm.service;

import com.pakin.crm.domain.CustomerTransfer;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTransferQueryObject;
import com.pakin.crm.query.PotentialCustomerQueryObject;

public interface ICustomerTransferService extends IBaseService<CustomerTransfer>{

	ListResult query(CustomerTransferQueryObject qo);


}
