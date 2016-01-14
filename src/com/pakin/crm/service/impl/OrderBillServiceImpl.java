package com.pakin.crm.service.impl;

import org.springframework.stereotype.Service;

import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.OrderBill;
import com.pakin.crm.domain.PotentialCustomer;
import com.pakin.crm.query.OrderQueryObject;
import com.pakin.crm.service.IOrderBillService;
@Service
public class OrderBillServiceImpl extends BaseServiceImpl<OrderBill> implements IOrderBillService{

	@Override
	public ListResult query(OrderQueryObject qo) {
		return orderBillDAO.query(qo);
	}
	@Override
	public void delete(OrderBill order) {
		order=orderBillDAO.get(order.getId());
		super.delete(order);
	}
}
