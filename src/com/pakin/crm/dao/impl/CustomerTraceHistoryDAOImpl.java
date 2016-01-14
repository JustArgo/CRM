package com.pakin.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.ICustomerTraceHistoryDAO;
import com.pakin.crm.domain.CustomerTraceHistory;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTraceHistoryQueryObject;
@Repository
public class CustomerTraceHistoryDAOImpl extends BaseDAOImpl<CustomerTraceHistory> implements ICustomerTraceHistoryDAO{

	@Override
	public ListResult query(CustomerTraceHistoryQueryObject qo) {
		String hql="SELECT NEW MAP(c.id as id,customer.id as customerId,customer.name as customerName,traceUser.id as traceUserId,traceUser.nickName as traceUserName,c.traceTime as traceTime,c.traceType as traceType,c.traceResult as traceResult,c.title as title,c.remark as remark) FROM CustomerTraceHistory c JOIN c.customer customer LEFT JOIN c.traceUser traceUser"+qo.getQuery();
		Query query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		hql="SELECT COUNT(c) FROM CustomerTraceHistory c JOIN c.customer customer LEFT JOIN c.traceUser traceUser"+qo.getQuery();
		query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		Integer total= ((Long)query.getSingleResult()).intValue();
		return new ListResult(total,list);
	}


}
