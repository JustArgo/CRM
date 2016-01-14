<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
<%@include file="./common/common.jsp" %>
<script type="text/javascript" src="/js/view/department.js"></script>
</head>
<body>
<table id="dept_datagrid"></table>
<!-- 定义datagrid按钮 -->
<div id="dept_datagrid_tb">
	<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
	<a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit" >编辑</a>
	<a  class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del"> 删除</a>
	<a iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
		
</div>
<!-- 定义对话框 -->
<div id="dept_dialog">
	<form id="dept_dialog_form" method="post">
		<input type="hidden" name="id">
		<table align="center" style="margin-top: 15px;">
			<tr>
				<td>部门编号</td>
				<td><input type="text" name="sn"></td>
			</tr>
			<tr>
				<td>部门名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>管理员</td>
				<td><input id="dept_dialog_manager" name="manager.id"/> </td>
			</tr>
			<tr>
				<td>父部门</td>
				<td><input id="dept_dialog_parent" name="parent.id"></td>
			</tr>
		</table>
	
	</form>
</div>
<!-- 定义底部按钮 -->
<div id="dept_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel"  data-cmd="cancel">取消</a>
</div>
</body>
</html>