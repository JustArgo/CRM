<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/customerTransfer.js"></script>
<title>客户移交管理</title>
</head>
<body>
	<table class="easyui-datagrid" id="customerTransfer_datagrid"
		data-options="url:'/customerTransfer_list',
			fit:true,
			fitColumns:true,
			singleSelect:true,
			toolbar:'#customerTransfer_datagrid_tb',
			pagination:true,
			pageList:[1,3,5,10,20,50],
			pageSize:3
			">
		<thead>
			<tr>
				<th data-options="field:'customerName',width:1,align:'center'">客户名称</th>
				<th data-options="field:'transUserName',width:1,align:'center'">移交人员</th>
				<th data-options="field:'transTime',width:1,align:'center'">移交时间</th>
				<th data-options="field:'oldSellerName',width:1,align:'center'">老市场专员</th>
				<th data-options="field:'newSellerName',width:1,align:'center'">新市场专员</th>
				<th data-options="field:'transReason',width:1,align:'center'">移交原因</th>
			</tr>
		</thead>
	</table>
	<!-- 定义对话框 -->
	<div id="customerTransfer_dialog">
		<form id="customerTransfer_dialog_form" method="post" >
			<input type="hidden" class="clear_this" name="id">
			<table align="center">
				<tr>
					<td>客户名称</td><td><input id="customerTransfer_dialog_cb_customers" class="clear_this"  name="customer.id" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>移交人员</td><td><input id="customerTransfer_dialog_cb_transUsers" class="clear_this"  name="transUser.id" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>移交时间</td><td><input class="clear_this easyui-datebox" type="text" name="transTime"></td>
				</tr>
				<tr>
					<td>老市场专员</td><td><input id="customerTransfer_dialog_cb_oldSellers" type="text" class="clear_this" disabled="disabled"></td>
				</tr>
				<tr>
					<td>新市场专员</td><td><input id="customerTransfer_dialog_cb_newSellers" class="clear_this"  name="newSeller.id"></td>
				</tr>
				<tr>
					<td>移交原因</td><td><input class="clear_this" type="text" name="transReason"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 定义顶部按钮 -->
	<div id="customerTransfer_datagrid_tb">
	<div>
		<a id="customerTransfer_datagrid_add" class="easyui-linkbutton" plain=true iconCls="icon-add" data-cmd="add">新增</a>
		<a id="customerTransfer_datagrid_refresh" class="easyui-linkbutton" plain=true iconCls="icon-reload" data-cmd="refresh">刷新</a>
	</div>
	 <div>
	 <form id="customerTransfer_datagrid_table_form">
		客户名称<input type="text" name="keyword" style="width: 80px">
		<!-- 负责人<select  class="customerTransfer_cb_depts" name="inputId" style="width: 80px"> 
		</select>-->
		<a id="customerTransfer_search" class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent" >搜索</a>
	</form>
	</div> 
	</div>
	<!-- 定义底部按钮 -->
	<div id="customerTransfer_dialog_buttons" align="center">
		<a id="customerTransfer_dialog_save" class="easyui-linkbutton" data-cmd="save">保存</a>
		<a id="customerTransfer_dialog_cancel" class="easyui-linkbutton" data-cmd="cancel">取消</a>
	</div>
</body>
</html>