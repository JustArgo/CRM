package com.pakin.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.ILogDAO;
import com.pakin.crm.domain.Log;
import com.pakin.crm.query.LogQueryObject;

@Repository
public class LogDaoImpl extends BaseDAOImpl<Log> implements ILogDAO{
	@Override
	public Long listCount(LogQueryObject qo) {
		Query query = em.createQuery("select count(l) from Log l "+qo.getQuery());
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1,qo.getParams().get(i));
		}
		List list = query.getResultList();
		return (Long) (list!=null&&list.size()>0?list.get(0):0L);
	}

	@Override
	public List list(LogQueryObject qo) {
		Query query = em.createQuery("select new Map(l.operator.username as operatorName,l.ip as ip,date_format(l.actionTime,'%Y-%m-%d %H:%i:%s') as actionTime,l.actionDetail as actionDetail) from Log l "+qo.getQuery());
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1,qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows());
		query.setMaxResults(qo.getRows());
		return query.getResultList();
	}
	
}
