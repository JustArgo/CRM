package com.pakin.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pakin.crm.dao.ICustomerDAO;
import com.pakin.crm.domain.Customer;
import com.pakin.crm.domain.CustomerGc;
import com.pakin.crm.domain.CustomerTransfer;
import com.pakin.crm.domain.CustomerXs;
import com.pakin.crm.domain.ListResult;
import com.pakin.crm.query.CustomerQueryObject;
@Repository
public class CustomeDAOImpl extends BaseDAOImpl<Customer> implements ICustomerDAO{

	@Override
	public ListResult query(CustomerQueryObject qo) {
		String hql="SELECT NEW MAP(c.id as id,c.name as name,c.age as age,c.gender as gender,c.tel as tel,c.email as email,c.qq as qq,c.wechat as wechat,c.job as job,c.salaryLevel as salaryLevel,c.customerSource as customerSource,c.inputTime as inputTime,user.id as inputUserId,user.nickName as inputUserName,seller.id as sellerId,seller.nickName as sellerName) FROM Customer c LEFT JOIN  c.inputUser user LEFT JOIN c.seller seller"+qo.getQuery();
		Query query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		hql="SELECT COUNT(c) FROM Customer c LEFT JOIN  c.inputUser user LEFT JOIN c.seller seller"+qo.getQuery();
		query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		Integer total= ((Long)query.getSingleResult()).intValue();
		return new ListResult(total,list);
	}

	@Override
	public List queryForOrder() {
		String hql="SELECT NEW MAP(c.id as cid,c.name as cname,seller.id as sellerId,seller.nickName as sellerName) FROM Customer c LEFT JOIN c.seller seller";
		Query query=em.createQuery(hql);
		return query.getResultList();
	}
	//客户移交
	@Override
	public void updateSeller(CustomerTransfer ct) {
		Long id=ct.getCustomer().getId();
		Long sellerId=ct.getNewSeller().getId();
		String hql="UPDATE Customer set seller.id=:sellerId  WHERE id=:id";
		Query query=em.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("sellerId", sellerId);
		query.executeUpdate();
	}
	//查询贡献
	@Override
	public ListResult queryGx(CustomerQueryObject qo) {
			String hql="SELECT NEW MAP(c2.id as id,o.customer.name as name,sum(o.sum) as gx) from OrderBill o LEFT JOIN o.customer c2"+qo.getQuery()+" group by c2.id";
		Query query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		query.setFirstResult((qo.getPage()-1)*qo.getRows()).setMaxResults(qo.getRows());
		List list = query.getResultList();
		hql="SELECT COUNT(c2) from OrderBill o LEFT JOIN o.customer c2"+qo.getQuery();
		query=em.createQuery(hql);
		for(int i=0;i<qo.getParams().size();i++){
			query.setParameter(i+1, qo.getParams().get(i));
		}
		Integer total= ((Long)query.getSingleResult()).intValue();
		return new ListResult(total,list);
	}
	//查询客户构成
	@Override
	public List<CustomerGc> queryGc() {
		String hql="SELECT NEW MAP(c.level as customerLevel,count(c.level) as customerNum) from Customer c group by c.level";
		Query query=em.createQuery(hql);
		return query.getResultList();
	}
	//查询每个员工拥有的客户数量
	@Override
	public List<CustomerXs> queryXs() {
		String hql="SELECT NEW MAP(e.nickName as employeeName,count(e.id) as num) from Customer c JOIN c.seller e  group by e.username";
		Query query=em.createQuery(hql);
		return query.getResultList();
	}


}
