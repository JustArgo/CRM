package com.pakin.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.ICustomerDevPlanDAO;
import com.pakin.crm.domain.CustomerDevPlan;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerDevPlanQueryObject;
@Repository
public class CustomerDevPlanDAOImpl extends BaseDAOImpl<CustomerDevPlan> implements ICustomerDevPlanDAO{

	@Override
	public ListResult query(CustomerDevPlanQueryObject qo) {
		String hql="SELECT NEW MAP(c.id as id,c.planTime as planTime,c.planSubject as planSubject,c.planType as planType,c.planDetails as planDetails,p.id as potentialId,p.name as potentialName,user.id as inputUserId,user.nickName as inputUserName) FROM CustomerDevPlan c LEFT JOIN  c.inputUser user LEFT JOIN c.potentialCustomer p"+qo.getQuery();
		Query query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		hql="SELECT COUNT(c) FROM CustomerDevPlan c LEFT JOIN  c.inputUser user LEFT JOIN c.potentialCustomer p"+qo.getQuery();
		query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		Integer total= ((Long)query.getSingleResult()).intValue();
		return new ListResult(total,list);
	}

}
