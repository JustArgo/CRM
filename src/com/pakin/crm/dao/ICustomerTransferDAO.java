package com.pakin.crm.dao;

import com.pakin.crm.domain.CustomerTransfer;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTransferQueryObject;

public interface ICustomerTransferDAO extends IBaseDAO<CustomerTransfer>{

	ListResult query(CustomerTransferQueryObject qo);

}
