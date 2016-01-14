<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/customerTraceHistory.js"></script>
<title>客户跟进历史</title>
</head>
<body>
	<table class="easyui-datagrid" id="customerTrace_datagrid"
		data-options="url:'/customerTrace_list',
			fit:true,
			fitColumns:true,
			singleSelect:true,
			toolbar:'#customerTrace_datagrid_tb',
			pagination:true,
			pageList:[1,3,5,10,20,50],
			pageSize:3
			">
		<thead>
			<tr>
				<th data-options="field:'customerName',width:1,align:'center'">跟进客户</th>
				<th data-options="field:'traceUserName',width:1,align:'center'">跟进人</th>
				<th data-options="field:'traceTime',width:1,align:'center'">跟进时间</th>
				<th data-options="field:'traceType',width:1,align:'center'">跟进方式</th>
				<th data-options="field:'traceResult',formatter:traceResultFormatter,width:1,align:'center'">跟进效果</th>
				<th data-options="field:'title',width:1,align:'center'">跟进主题</th>
				<th data-options="field:'remark',width:1,align:'center'">备注</th>
			</tr>
		</thead>
	</table>
	<!-- 定义对话框 -->
	<div id="customerTrace_dialog">
		<form id="customerTrace_dialog_form" method="post" >
			<input type="hidden" class="clear_this" name="id">
			<table align="center">
				<tr>
					<td>跟进客户</td><td><input id="customeTrace_dialog_cb_customers" class="clear_this"  name="customer.id" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>跟进人</td><td><input id="customeTrace_dialog_cb_traceUers" class="clear_this"  name="traceUser.id" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>跟进时间</td><td><input class="clear_this easyui-datebox" type="text" name="traceTime"></td>
				</tr>
				<tr>
					<td>跟进方式</td><td><input class="clear_this" type="text" name="traceType"></td>
				</tr>
				<tr>
					<td>跟进效果</td><td><select class="easyui-bombobox" type="text" name="traceResult">
						<option value="1">优</option>
						<option value="2">中</option>
						<option value="3">差</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>跟进主题</td><td><input class="clear_this" type="text" name="title"></td>
				</tr>
				<tr>
					<td>备注</td><td><input class="clear_this" type="text" name="remark"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 定义顶部按钮 -->
	<div id="customerTrace_datagrid_tb">
	<div>
		<a id="customerTrace_datagrid_add" class="easyui-linkbutton" plain=true iconCls="icon-add" data-cmd="add">新增</a>
		<a id="customerTrace_datagrid_edit" class="easyui-linkbutton" plain=true iconCls="icon-edit" data-cmd="edit">编辑</a>
		<a id="customerTrace_datagrid_del" class="easyui-linkbutton" plain=true iconCls="icon-remove" data-cmd="del">删除</a>
		<a id="customerTrace_datagrid_refresh" class="easyui-linkbutton" plain=true iconCls="icon-reload" data-cmd="refresh">刷新</a>
	</div>
	 <div>
	 <form id="customerTrace_datagrid_table_form">
		跟进客户名称<input type="text" name="keyword" style="width: 80px">
		<!-- 负责人<select  class="customerTrace_cb_depts" name="inputId" style="width: 80px"> 
		</select>-->
		<a id="customerTrace_search" class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent" >搜索</a>
	</form>
	</div> 
	</div>
	<!-- 定义底部按钮 -->
	<div id="customerTrace_dialog_buttons" align="center">
		<a id="customerTrace_dialog_save" class="easyui-linkbutton" data-cmd="save">保存</a>
		<a id="customerTrace_dialog_cancel" class="easyui-linkbutton" data-cmd="cancel">取消</a>
	</div>
</body>
</html>