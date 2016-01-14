<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/employee.js"></script>
<title>员工管理</title>
</head>
<body>
	<table class="easyui-datagrid" id="emp_datagrid"
		data-options="url:'/employee_list',
			fit:true,
			fitColumns:true,
			singleSelect:true,
			toolbar:'#emp_datagrid_tb',
			pagination:true,
			pageList:[1,3,5,10,20,50],
			pageSize:3
			">
		<thead>
			<tr>
				<th data-options="field:'username',width:1,align:'center'">用户名</th>
				<th data-options="field:'nickName',width:1,align:'center'">用户昵称</th>
				<th data-options="field:'email',width:1,align:'center'">邮箱</th>
				<th data-options="field:'dname',width:1,align:'center'">部门</th>
				<th data-options="field:'status',width:1,align:'center'" formatter='statusFormatter'>状态</th>
			</tr>
		</thead>
	</table>
	<!-- 定义对话框 -->
	<div id="emp_dialog">
		<form id="emp_dialog_form" method="post" >
			<input type="hidden" name="id">
			<table align="center">
				<tr>
					<td>用户名</td><td><input type="text" name="username" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>用户昵称</td><td><input type="text" name="nickName"></td>
				</tr>
				<tr>
					<td>邮箱</td><td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>部门</td>
					<td>
						<input class="emp_cb_depts" name="dept.id">
					</td>
				</tr>
				<tr>
					<td>角色</td>
					<td>
						<input id="emp_cb_roles" name="roles.id">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 定义顶部按钮 -->
	<div id="emp_datagrid_tb">
	<div>
		<a id="emp_datagrid_add" class="easyui-linkbutton" plain=true iconCls="icon-add" data-cmd="add">新增</a>
		<a id="emp_datagrid_edit" class="easyui-linkbutton" plain=true iconCls="icon-edit" data-cmd="edit">编辑</a>
		<a id="emp_datagrid_del" class="easyui-linkbutton" plain=true iconCls="icon-remove" data-cmd="del">删除</a>
		<a id="emp_datagrid_refresh" class="easyui-linkbutton" plain=true iconCls="icon-reload" data-cmd="refresh">刷新</a>
	</div>
	 <div>
	 <form id="emp_datagrid_table_form">
		用户名/昵称<input type="text" name="keyword" style="width: 80px">
		部门<select  class="emp_cb_depts" name="deptId" style="width: 80px">
		</select>
		<a id="emp_search" class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent" >搜索</a>
	</form>
	</div> 
	</div>
	<!-- 定义底部按钮 -->
	<div id="emp_dialog_buttons" align="center">
		<a id="emp_dialog_save" class="easyui-linkbutton" data-cmd="save">保存</a>
		<a id="emp_dialog_cancel" class="easyui-linkbutton" data-cmd="cancel">取消</a>
	</div>
</body>
</html>