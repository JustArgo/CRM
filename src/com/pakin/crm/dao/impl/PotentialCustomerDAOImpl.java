package com.pakin.crm.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.IPotentialCustomerDAO;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.PotentialCustomer;
import com.pakin.crm.query.PotentialCustomerQueryObject;
import com.pakin.crm.util.StringUtil;
@Repository
public class PotentialCustomerDAOImpl extends BaseDAOImpl<PotentialCustomer> implements IPotentialCustomerDAO{

	@Override
	public ListResult query(PotentialCustomerQueryObject qo) {
		String hql="SELECT NEW MAP(p.id as id,p.customerSource as customerSource,p.name as name,p.successRate as successRate,p.remark as remark,p.linkMan as linkMan,p.linkManTel as linkManTel,i.id as eid,i.nickName as inputUser,p.inputTime as inputTime) FROM PotentialCustomer p LEFT JOIN p.inputUser i"+qo.getQuery();
		if(StringUtil.hasLength(qo.getQuery())){
			hql+=" AND p.isCustomerStatus=0";
		}else{
			hql+=" WHERE p.isCustomerStatus=0";
		}
		Query query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		hql="SELECT COUNT(p) FROM PotentialCustomer p LEFT JOIN p.inputUser i"+qo.getQuery();
		if(StringUtil.hasLength(qo.getQuery())){
			hql+=" AND p.isCustomerStatus=0";
		}else{
			hql+=" WHERE p.isCustomerStatus=0";
		}
		query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		Integer total= ((Long)query.getSingleResult()).intValue();
		return new ListResult(total,list);
	}

	@Override
	public List queryForPlan() {
		String hql="SELECT NEW MAP(p.id as pid,p.name as pname) FROM PotentialCustomer p WHERE p.isCustomerStatus=0";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void updateStatusToCustomer(Long potentialId) {
		String hql="UPDATE PotentialCustomer pc set pc.isCustomerStatus=1 WHERE pc.id=?";
		Query query = em.createQuery(hql);
		query.setParameter(1, potentialId);
		query.executeUpdate();
	}

}
