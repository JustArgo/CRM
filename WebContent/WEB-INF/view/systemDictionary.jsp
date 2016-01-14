<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/systemDictionary.js"></script>
<title>数据字典管理</title>
</head>
<body>
	<table class="easyui-datagrid" id="dictionary_datagrid"
		data-options="url:'/dictionary_list',
			fit:true,
			fitColumns:true,
			singleSelect:true,
			toolbar:'#dictionary_datagrid_tb',
			pagination:true,
			pageList:[1,3,5,10,20,50],
			pageSize:3
			">
		<thead>
			<tr>
				<th data-options="field:'sn',width:1,align:'center'">目录编号</th>
				<th data-options="field:'name',width:1,align:'center'">目录名称</th>
				<th data-options="field:'intro',width:1,align:'center'">目录简介</th>
				<th data-options="field:'state',width:1,align:'center'">状态</th>
			</tr>
		</thead>
	</table>
	<!-- 定义对话框 -->
	<div id="dictionary_dialog">
		<form id="dictionary_dialog_form" method="post" >
			<input type="hidden" class="clear_this" name="id">
			<table align="center">
				<tr>
					<td>目录编号</td><td><input class="clear_this" type="text" name="sn" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>目录名称</td><td><input class="clear_this" type="text" name="name" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>目录简介</td><td><input class="clear_this" type="text" name="intro"></td>
				</tr>
				<tr>
					<td>状态</td><td><input class="clear_this" type="text" name="status"></td>
				</tr>
				<tr>
					<td>目录明细</td>
				</tr>
			</table>
	<table id="dictionary_dialog_datagrid_details" style="width:600px;height:200px"   >   
	</table>  

		</form>
	</div>
	<!-- 定义顶部按钮 -->
	<div id="dictionary_datagrid_tb">
	<div>
		<a id="dictionary_datagrid_add" class="easyui-linkbutton" plain=true iconCls="icon-add" data-cmd="add">新增</a>
		<a id="dictionary_datagrid_edit" class="easyui-linkbutton" plain=true iconCls="icon-edit" data-cmd="edit">编辑</a>
		<a id="dictionary_datagrid_del" class="easyui-linkbutton" plain=true iconCls="icon-remove" data-cmd="del">删除</a>
		<a id="dictionary_datagrid_refresh" class="easyui-linkbutton" plain=true iconCls="icon-reload" data-cmd="refresh">刷新</a>
	</div>
	 <div>
	 <form id="dictionary_datagrid_table_form">
		客户名称<input type="text" name="keyword" style="width: 80px">
		<!-- 负责人<select  class="dictionary_cb_depts" name="inputId" style="width: 80px"> 
		</select>-->
		<a id="dictionary_search" class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent" >搜索</a>
	</form>
	</div> 
	</div>
	<!-- 定义底部按钮 -->
	<div id="dictionary_dialog_buttons" align="center">
		<a id="dictionary_dialog_save" class="easyui-linkbutton" data-cmd="save">保存</a>
		<a id="dictionary_dialog_cancel" class="easyui-linkbutton" data-cmd="cancel">取消</a>
	</div>
	<!-- 定义明细顶部按钮 -->
	<div id="details_tb">
		<a id="dictionary_dialog_addTetail" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'" data-cmd="addTetail">新增明细</a>
	</div>
</body>
</html>