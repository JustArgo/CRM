package com.pakin.crm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.IEmployeeDAO;
import com.pakin.crm.domain.Employee;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.QueryObject;
@Repository
public class EmployeeDAOImpl extends BaseDAOImpl<Employee> implements IEmployeeDAO {


	@Override
	public Map<String, Object> query(QueryObject qo) {
		Map<String,Object> map=new HashMap<String, Object>();
		//查结果集
		String hql="SELECT NEW MAP(e.id as id,e.username as username,e.nickName as nickName,e.email as email,d.id as did,d.name as dname,e.status as status) FROM Employee e LEFT JOIN e.dept d "+qo.getQuery();
		Query query = em.createQuery(hql);
		for (int index=0;index<qo.getParams().size();index++) {
			query.setParameter(index+1,qo.getParams().get(index));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		//查结果总数
		hql="SELECT COUNT(e) FROM Employee e";
		query=em.createQuery(hql);
		Integer total= ((Long)query.getSingleResult()).intValue();
		map.put("rows",list);
		map.put("total", total);
 		return map;
	}

	@Override
	public void updateStatus(Long id) {
		Query query = em.createQuery("UPDATE  Employee e SET e.status=0 WHERE e.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public ListResult queryForDept() {
		String hql="SELECT NEW MAP(e.id as id,e.username as username,e.nickName as nickName,e.email as email,d.id as did,d.name as dname,m.id as managerId,m.name as mdept) FROM Employee e left join e.dept d left join e.mdept m WHERE e.status=1";
		Query query = em.createQuery(hql);
		return  new ListResult(100, query.getResultList());
	}

	@Override
	public Employee login(String username, String password) {
		String hql="SELECT e FROM Employee e WHERE e.username=:username AND e.password=:password";
		Query query = em.createQuery(hql);
		query.setParameter("username",username);
		query.setParameter("password",password);
		 List list = query.getResultList();
		 System.out.println(list.size()+"----------");
		 if(list.size()>1){
			 throw new RuntimeException("操作异常，请联系管理员");
		 }
		 if(list.size()==1){
			 return (Employee) list.get(0);
		 }
		 return null;
	}

	@Override
	public List queryForCustomer() {
		String hql="SELECT NEW Map(e.id as eid,e.nickName as ename) FROM Employee e";
		Query query=em.createQuery(hql);
		return query.getResultList();
	}
	
	
	
}
