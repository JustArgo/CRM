package com.pakin.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.ISystemDictionaryDAO;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.SystemDictionary;
import com.pakin.crm.query.SystemDictionaryQueryObject;

@Repository
public class SystemDictionaryDAOImpl extends BaseDAOImpl<SystemDictionary> implements ISystemDictionaryDAO{

	@Override
	public ListResult query(SystemDictionaryQueryObject qo) {
		String hql="SELECT NEW MAP(s.sn as sn,s.name as name,s.intro as intro,s.state as state,d.name as dname,d.sn as dsn,d.intro as dintro) FROM SystemDictionary s LEFT JOIN s.details d"+qo.getQuery();
		Query query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		hql="SELECT COUNT(s) FROM SystemDictionary s LEFT JOIN s.details d"+qo.getQuery();
		query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		Integer total= ((Long)query.getSingleResult()).intValue();
		return new ListResult(total,list);
	}

}
