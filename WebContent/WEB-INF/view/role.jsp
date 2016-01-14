<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<%@include file="./common/common.jsp" %>
<script type="text/javascript" src="/js/view/role.js"></script>
</head>
<body>
<table id="role_datagrid"></table>
<!-- 定义datagrid按钮 -->
<div id="role_datagrid_tb">
	<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
	<a  class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit" >编辑</a>
	<a  class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del"> 删除</a>
	<a  class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh"> 刷新</a>
		
</div>
<!-- 定义对话框 -->
<div id="role_dialog">
	<form id="role_dialog_form" method="post">
		<input type="hidden" name="id">
		<table align="center" style="margin-top: 15px;">
			<tr>
				
				<td>角色编号<input id="role_dialog_sn" type="text" name="sn"></td>
				<td>角色名称<input id="role_dialog_name" type="text" name="name"></td>
			</tr>
			<tr>
				<td><input id="role_dialog_selfPermissions" name="permisssions.id"/> </td>
				<td><input id="role_dialog_allPermissions" ></td>
			</tr>
		</table>
	
	</form>
</div>
<!-- 定义底部按钮 -->
<div id="role_dialog_bt">
		<a class="easyui-linkbutton" iconCls="icon-save" data-cmd="save">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel"  data-cmd="cancel">取消</a>
</div>
</body>
</html>