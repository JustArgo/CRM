package com.pakin.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.IRoleDAO;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.domain.Role;
import com.pakin.crm.query.QueryObject;
@Repository
public class RoleDAOImpl extends BaseDAOImpl<Role> implements IRoleDAO {

	@Override
	public ListResult query(QueryObject qo) {
		String hql="SELECT NEW MAP(r.id as id,r.sn as sn,r.name as name) FROM Role r "+qo.getQuery();
		Query query=em.createQuery(hql);
		for (int i = 0; i < qo.getParams().size(); i++) {
			query.setParameter(i+1,qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows());
		query.setMaxResults(qo.getRows());
		List<Map> list=query.getResultList();
		hql="SELECT COUNT(r) FROM Role r"+qo.getQuery();
		 query=em.createQuery(hql);
		for (int i = 0; i < qo.getParams().size(); i++) {
			query.setParameter(i+1,qo.getParams().get(i));
		}
		Long total=(Long) query.getSingleResult();
		return new ListResult(total.intValue(), list);
	}

	@Override
	public List queryOwnPermission(Long id) {
		String hql="SELECT NEW MAP(p.id as id,p.sn as sn,p.name as name,p.resourceName as resourceName) FROM Role r join r.permissions p WHERE r.id=:id";
		Query query=em.createQuery(hql);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public void removeRelation(Long id) {
		String hql="UPDATE Role r  SET r.permission WHERE d.parent.id=:id";
		Query query = em.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
	
		
	}

	@Override
	public List<Map> queryForEmp() {
		String hql="SELECT NEW MAP(r.id as rid,r.name as rname) FROM Role r";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public List queryRoleByEid(Long eid) {
		String hql="SELECT r.id as rid FROM Employee e JOIN e.roles r WHERE e.id=:id";
		Query query=em.createQuery(hql);
		query.setParameter("id", eid);
		return query.getResultList();
	}

}
