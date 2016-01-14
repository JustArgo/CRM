<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/orderBill.js"></script>
<title>潜在用户管理</title>
</head>
<body>
	<table class="easyui-datagrid" id="order_datagrid"
		data-options="url:'/order_list',
			fit:true,
			fitColumns:true,
			singleSelect:true,
			toolbar:'#order_datagrid_tb',
			pagination:true,
			pageList:[1,3,5,10,20,50],
			pageSize:3
			">
		<thead>
			<tr>
				<th data-options="field:'sn',width:1,align:'center'">定金单号</th>
				<th data-options="field:'customerName',width:1,align:'center'">定金客户</th>
				<th data-options="field:'signTime',width:1,align:'center'">签订时间</th>
				<th data-options="field:'sellerName',width:1,align:'center'">销售人员</th>
				<th data-options="field:'sum',width:1,align:'center'">定金金额</th>
				<th data-options="field:'intro',width:1,align:'center'">摘要</th>
			</tr>
		</thead>
	</table>
	<!-- 定义对话框 -->
	<div id="order_dialog">
		<form id="order_dialog_form" method="post" >
			<input type="hidden" class="clear_this" name="id">
			<table align="center">
				<tr>
					<td>定金编号</td><td><input class="clear_this" type="text" name="sn" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>定金客户</td><td><input id="order_dialog_cb_customers" name="customer.id"></td>
				</tr>
				<tr>
					<td>签订时间</td><td><input class="clear_this easyui-datebox" type="text" name="signTime"></td>
				</tr>
				<tr>
					<td>销售人员</td><td><input id="order_dialog_cb_seller" name="seller.id"></td>
				</tr>
				<tr>
					<td>定金金额</td><td><input class="clear_this" type="text" name="sum"></td>
				</tr>
				<tr>
					<td>摘要</td><td><input class="clear_this" type="text" name="intro"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 定义顶部按钮 -->
	<div id="order_datagrid_tb">
	<div>
		<a id="order_datagrid_add" class="easyui-linkbutton" plain=true iconCls="icon-add" data-cmd="add">新增</a>
		<a id="order_datagrid_edit" class="easyui-linkbutton" plain=true iconCls="icon-edit" data-cmd="edit">编辑</a>
		<a id="order_datagrid_del" class="easyui-linkbutton" plain=true iconCls="icon-remove" data-cmd="del">删除</a>
		<a id="order_datagrid_refresh" class="easyui-linkbutton" plain=true iconCls="icon-reload" data-cmd="refresh">刷新</a>
	</div>
	 <div>
	 <form id="order_datagrid_table_form">
		客户名称<input type="text" name="keyword" style="width: 80px">
		<!-- 负责人<select  class="order_cb_depts" name="inputId" style="width: 80px"> 
		</select>-->
		<a id="order_search" class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent" >搜索</a>
	</form>
	</div> 
	</div>
	<!-- 定义底部按钮 -->
	<div id="order_dialog_buttons" align="center">
		<a id="order_dialog_save" class="easyui-linkbutton" data-cmd="save">保存</a>
		<a id="order_dialog_cancel" class="easyui-linkbutton" data-cmd="cancel">取消</a>
	</div>
</body>
</html>