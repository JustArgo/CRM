<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/customerDevPlan.js"></script>
<title>(潜在)客户开发计划</title>
</head>
<body>
	<table class="easyui-datagrid" id="plan_datagrid"
		data-options="url:'/plan_list',
			fit:true,
			fitColumns:true,
			singleSelect:true,
			toolbar:'#plan_datagrid_tb',
			pagination:true,
			pageList:[1,3,5,10,20,50],
			pageSize:3
			">
		<thead>
			<tr>
				<th data-options="field:'potentialName',width:1,align:'center'">潜在客户名称</th>
				<th data-options="field:'planTime',width:1,align:'center'">计划时间</th>
				<th data-options="field:'planSubject',width:1,align:'center'">计划主题</th>
				<th data-options="field:'planType',width:1,align:'center'">计划类型</th>
				<th data-options="field:'planDetails',width:1,align:'center'">计划内容</th>
				<th data-options="field:'inputUserName',width:1,align:'center'">创建人</th>
			</tr>
		</thead>
	</table>
	<!-- 定义对话框 -->
	<div id="plan_dialog">
		<form id="plan_dialog_form" method="post" >
			<input type="hidden" class="clear_this" name="id">
			<input type="hidden" name="inputUser.id" value="${sessionScope.USER_IN_SESSION.id}">
			<table align="center">
				<tr>
					<!-- 下拉列表供选 -->
					<td>潜在客户名称</td><td><input id="plan_dialog_cb_potential" name="potentialCustomer.id"/></td>
				</tr>
				<tr>
					<td>计划时间</td><td><input class="easyui-datebox clear_this" type="text" name="planTime" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>计划主题</td><td><input class="clear_this easyui-validatebox" type="text" name="planSubject" required=true></td>
				</tr>
				<tr>
					<td>计划类型</td><td><input class="clear_this easyui-validatebox" type="text" name="planType" required=true></td>
				</tr>
				<tr>
					<td>计划内容</td><td><input class="clear_this easyui-validatebox" type="text" name="planDetails" required=true></td>
				</tr>
				<tr>
					<td>创建人</td><td><label>${sessionScope.USER_IN_SESSION.nickName}</label> </td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 定义顶部按钮 -->
	<div id="plan_datagrid_tb">
	<div>
		<a id="plan_datagrid_add" class="easyui-linkbutton" plain=true iconCls="icon-add" data-cmd="add">新增</a>
		<a id="plan_datagrid_edit" class="easyui-linkbutton" plain=true iconCls="icon-edit" data-cmd="edit">编辑</a>
		<a id="plan_datagrid_del" class="easyui-linkbutton" plain=true iconCls="icon-remove" data-cmd="del">删除</a>
		<a id="plan_datagrid_refresh" class="easyui-linkbutton" plain=true iconCls="icon-reload" data-cmd="refresh">刷新</a>
	</div>
	 <div>
	 <form id="plan_datagrid_table_form">
		客户名称<input type="text" name="keyword" style="width: 80px">
		<!-- 负责人<select  class="plan_cb_depts" name="inputId" style="width: 80px"> 
		</select>-->
		<a id="plan_search" class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent" >搜索</a>
	</form>
	</div> 
	</div>
	<!-- 定义底部按钮 -->
	<div id="plan_dialog_buttons" align="center">
		<a id="plan_dialog_save" class="easyui-linkbutton" data-cmd="save">保存</a>
		<a id="plan_dialog_cancel" class="easyui-linkbutton" data-cmd="cancel">取消</a>
	</div>
</body>
</html>