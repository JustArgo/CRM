package com.pakin.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.ICustomerTransferDAO;
import com.pakin.crm.domain.CustomerTransfer;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerTransferQueryObject;
@Repository
public class CustomerTransferDAOImpl extends BaseDAOImpl<CustomerTransfer> implements ICustomerTransferDAO{

	@Override
	public ListResult query(CustomerTransferQueryObject qo) {
		String hql="SELECT NEW MAP(c.id as id,c.transTime as transTime,c.transReason as transReason,customer.id as customerId,customer.name as customerName,transUser.id as transUserId,transUser.nickName as transUserName,oldSeller.id as oldSellerId,oldSeller.nickName as oldSellerName,newSeller.id as newSellerId,newSeller.nickName as newSellerName) FROM CustomerTransfer c JOIN c.customer customer LEFT JOIN c.transUser  transUser LEFT JOIN c.oldSeller oldSeller LEFT JOIN c.newSeller newSeller"+qo.getQuery();
		Query query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		hql="SELECT COUNT(c) FROM CustomerTransfer c JOIN c.customer customer LEFT JOIN c.transUser  transUser LEFT JOIN c.oldSeller oldSeller LEFT JOIN c.newSeller newSeller"+qo.getQuery();
		query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		Integer total= ((Long)query.getSingleResult()).intValue();
		return new ListResult(total,list);
	}
}
