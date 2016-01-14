package com.pakin.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.IOrderBillDAO;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.OrderBill;
import com.pakin.crm.query.OrderQueryObject;
@Repository
public class OrderBillDAOImpl extends BaseDAOImpl<OrderBill> implements IOrderBillDAO{

	@Override
	public ListResult query(OrderQueryObject qo) {
		String hql="SELECT NEW MAP(o.id as id,o.sn as sn,c.id as customerId,c.name as customerName,o.signTime as signTime,seller.id as sellerId,seller.nickName as sellerName,o.sum as sum,o.intro as intro) FROM OrderBill o LEFT JOIN o.customer c LEFT JOIN o.seller seller"+qo.getQuery();
		Query query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		hql="SELECT COUNT(o) FROM OrderBill o LEFT JOIN o.customer c LEFT JOIN o.seller seller"+qo.getQuery();
		query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		Integer total= ((Long)query.getSingleResult()).intValue();
		return new ListResult(total,list);
	}


}
