package com.pakin.crm.service;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.OrderBill;
import com.pakin.crm.query.OrderQueryObject;

public interface IOrderBillService extends IBaseService<OrderBill>{

	ListResult query(OrderQueryObject qo);

}
