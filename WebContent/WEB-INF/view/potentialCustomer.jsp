<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/potentialCustomer.js"></script>
<title>潜在用户管理</title>
</head>
<body>
	<table class="easyui-datagrid" id="pc_datagrid"
		data-options="url:'/pc_list',
			fit:true,
			fitColumns:true,
			singleSelect:true,
			toolbar:'#pc_datagrid_tb',
			pagination:true,
			pageList:[1,3,5,10,20,50],
			pageSize:3
			">
		<thead>
			<tr>
				<th data-options="field:'customerSource',width:1,align:'center'">客户来源</th>
				<th data-options="field:'name',width:1,align:'center'">客户名称</th>
				<th data-options="field:'successRate',width:1,align:'center'">成功几率</th>
				<th data-options="field:'linkMan',width:1,align:'center'">联系人</th>
				<th data-options="field:'linkManTel',width:1,align:'center'">联系电话</th>
				<th data-options="field:'inputUser',width:1,align:'center'">负责人</th>
				<th data-options="field:'inputTime',width:1,align:'center'">创建时间</th>
			</tr>
		</thead>
	</table>
	<!-- 定义对话框 -->
	<div id="pc_dialog">
		<form id="pc_dialog_form" method="post" >
			<input type="hidden" class="clear_this" name="id">
			<input type="hidden" name="inputUser.id" value="${sessionScope.USER_IN_SESSION.id}">
			<table align="center">
				<tr>
					<td>客户来源</td><td><input class="clear_this" type="text" name="customerSource" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>客户名称</td><td><input class="clear_this" type="text" name="name" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>成功几率</td><td><input class="clear_this" type="text" name="successRate"></td>
				</tr>
				<tr>
					<td>联系人</td><td><input class="clear_this" type="text" name="linkMan"></td>
				</tr>
				<tr>
					<td>联系电话</td><td><input class="clear_this" type="text" name="linkManTel"></td>
				</tr>
				<tr>
					<td>客户描述</td><td><input class="clear_this" type="text" name="remark"></td>
				</tr>
				<tr>
					<td>负责人</td><td><label>${sessionScope.USER_IN_SESSION.nickName}</label> </td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 定义顶部按钮 -->
	<div id="pc_datagrid_tb">
	<div>
		<a id="pc_datagrid_add" class="easyui-linkbutton" plain=true iconCls="icon-add" data-cmd="add">新增</a>
		<a id="pc_datagrid_edit" class="easyui-linkbutton" plain=true iconCls="icon-edit" data-cmd="edit">编辑</a>
		<a id="pc_datagrid_del" class="easyui-linkbutton" plain=true iconCls="icon-remove" data-cmd="del">删除</a>
		<a id="pc_datagrid_refresh" class="easyui-linkbutton" plain=true iconCls="icon-reload" data-cmd="refresh">刷新</a>
	</div>
	 <div>
	 <form id="pc_datagrid_table_form">
		客户名称<input type="text" name="keyword" style="width: 80px">
		<!-- 负责人<select  class="pc_cb_depts" name="inputId" style="width: 80px"> 
		</select>-->
		<a id="pc_search" class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent" >搜索</a>
	</form>
	</div> 
	</div>
	<!-- 定义底部按钮 -->
	<div id="pc_dialog_buttons" align="center">
		<a id="pc_dialog_save" class="easyui-linkbutton" data-cmd="save">保存</a>
		<a id="pc_dialog_cancel" class="easyui-linkbutton" data-cmd="cancel">取消</a>
	</div>
</body>
</html>