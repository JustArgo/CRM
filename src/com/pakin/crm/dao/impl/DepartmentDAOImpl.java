package com.pakin.crm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.IDepartmentDAO;
import com.pakin.crm.domain.Department;
import com.pakin.crm.domain.Node;
import com.pakin.crm.query.QueryObject;
@Repository
public class DepartmentDAOImpl extends BaseDAOImpl<Department> implements IDepartmentDAO{
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Map> queryDeptsForEmp() {
		String hql="SELECT NEW MAP(d.id as did,d.name as dname) FROM Department d";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}
	@Override
	public Map<String, Object> query(QueryObject qo) {
		Map<String,Object> map=new HashMap<String, Object>();
		String sql="SELECT NEW MAP(d.id as id,d.sn as sn,d.name as name,m.id as mid,m.nickName as mname,p.id as pid,p.name as pname) FROM Department d LEFT JOIN d.parent p LEFT JOIN d.manager m";
		Query query = em.createQuery(sql);
		List<Map> list = query.getResultList();
		map.put("rows", list);
		sql="SELECT COUNT(d) FROM Department d";
		 query = em.createQuery(sql);
		Integer total  =((Long) query.getSingleResult()).intValue();
		map.put("total",total);
		return map;
	}
	@Override
	public List<Map> getParent() {
		String hql="SELECT NEW MAP(d.id as id,d.name as text,p.id as pid) FROM Department d LEFT JOIN d.parent p";
		return em.createQuery(hql).getResultList();
	}
	@Override
	public void removeRelation(Long id) {
		String hql="UPDATE Department d  SET d.parent=null WHERE d.parent.id=:id";
		Query query = em.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
	
		
	}
	

}
