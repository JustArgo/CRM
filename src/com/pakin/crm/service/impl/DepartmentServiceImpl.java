package com.pakin.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pakin.crm.dao.IDepartmentDAO;
import com.pakin.crm.domain.Department;
import com.pakin.crm.domain.Node;
import com.pakin.crm.query.QueryObject;
import com.pakin.crm.service.IDepartmentService;
import com.pakin.crm.util.TreeUtil;
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService{
	@Autowired
	IDepartmentDAO departmentDAO;
	@Override
	public List<Map> queryDeptsForEmp() {
		return departmentDAO.queryDeptsForEmp();
	}
	@Override
	public Map<String, Object> query(QueryObject qo) {
		return departmentDAO.query(qo);
	}
	@Override
	public List<Node> queryParent() {
		//查出
			List<Map> list=departmentDAO.getParent();
			List<Node> root=TreeUtil.getTree(list);
		return root;
	}
	@Override
	public void delete(Long id) {
		departmentDAO.removeRelation(id);
		Department dept = super.get(id);
		super.delete(dept);
		
	}

}
