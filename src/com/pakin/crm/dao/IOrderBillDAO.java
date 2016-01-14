package com.pakin.crm.dao;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.OrderBill;
import com.pakin.crm.query.OrderQueryObject;

public interface IOrderBillDAO extends IBaseDAO<OrderBill>{

	ListResult query(OrderQueryObject qo);

}
