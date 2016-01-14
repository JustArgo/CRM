package com.pakin.crm.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.pakin.crm.dao.IBaseDAO;
import com.pakin.crm.dao.ICustomerDAO;
import com.pakin.crm.dao.ICustomerDevPlanDAO;
import com.pakin.crm.dao.ICustomerTraceHistoryDAO;
import com.pakin.crm.dao.ICustomerTransferDAO;
import com.pakin.crm.dao.IDepartmentDAO;
import com.pakin.crm.dao.IEmployeeDAO;
import com.pakin.crm.dao.ILogDAO;
import com.pakin.crm.dao.IOrderBillDAO;
import com.pakin.crm.dao.IPermissionDAO;
import com.pakin.crm.dao.IPotentialCustomerDAO;
import com.pakin.crm.dao.IRoleDAO;
import com.pakin.crm.dao.ISystemDictionaryDAO;
import com.pakin.crm.service.IBaseService;

public class BaseServiceImpl<T> implements IBaseService<T> {
	@Autowired
	public IEmployeeDAO employeeDAO;
	@Autowired
	public IDepartmentDAO departmentDAO;
	@Autowired
	public IRoleDAO roleDAO;
	@Autowired
	public IPermissionDAO permissionDAO;
	@Autowired
	public IPotentialCustomerDAO potentialCustomerDAO;
	@Autowired
	public ICustomerDevPlanDAO customerDevPlanDAO;
	@Autowired
	public ICustomerDAO customerDAO;
	@Autowired
	public IOrderBillDAO orderBillDAO;
	@Autowired
	public ICustomerTraceHistoryDAO customerTraceHistoryDAO;
	@Autowired
	public ICustomerTransferDAO customerTransferDAO;
	@Autowired
	public ISystemDictionaryDAO systemDictionaryDAO;
	@Autowired
	public ILogDAO logDAO;
	@Autowired
	public IBaseDAO<T> baseDAO;
	@PostConstruct
	public void init(){
		try{
			ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
			String simpleName = clazz.getSimpleName();//Employee
			//employee+DAO
			String daoName = simpleName.substring(0, 1).toLowerCase()+simpleName.substring(1)+"DAO";//employeeDAO
			Field daoField = this.getClass().getField(daoName);
			Object object = daoField.get(this);
			Field baseDAOField = this.getClass().getField("baseDAO");
			baseDAOField.set(this, object);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void save(T t) {
		baseDAO.save(t);
	}

	@Override
	public void update(T t) {
		baseDAO.update(t);
	}

	@Override
	public void delete(T t) {
		baseDAO.delete(t);
	}

	@Override
	public List queryAll() {
		return baseDAO.queryAll();
	}

	@Override
	public T get(Long id) {
		return baseDAO.get(id);
	}

}
