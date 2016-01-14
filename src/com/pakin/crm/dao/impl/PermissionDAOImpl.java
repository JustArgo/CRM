package com.pakin.crm.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.IPermissionDAO;
import com.pakin.crm.domain.Permission;
@Repository
public class PermissionDAOImpl extends BaseDAOImpl<Permission> implements IPermissionDAO
{

	@Override
	public List<Map> queryPermissionsForRole() {
		String hql="SELECT NEW MAP(p.id as id,p.sn as sn,p.name as name,p.resourceName as resourceName) FROM Permission p";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Permission queryPermissionByResource(String resourceName) {
		String hql = "SELECT p FROM Permission p where p.resourceName=:resourceName";
		Query query = em.createQuery(hql);
		query.setParameter("resourceName", resourceName);
		List<Permission> resultList = query.getResultList();
		return resultList != null && resultList.size() > 0 ? resultList.get(0)
				: null;
	}
	@Override
	public List<Permission> queryPemissionByEid(Long id) {
		String hql = "SELECT distinct p FROM Employee e join e.roles r join r.permissions p where e.id=:id";
		Query query = em.createQuery(hql);
		query.setParameter("id", id);
		return query.getResultList();
	}


}
