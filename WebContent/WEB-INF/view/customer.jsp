<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/customer.js"></script>
<title>客户信息管理</title>
</head>
<body>
	<table class="easyui-datagrid" id="customer_datagrid"
		data-options="url:'/customer_list',
			fit:true,
			fitColumns:true,
			singleSelect:true,
			toolbar:'#customer_datagrid_tb',
			pagination:true,
			pageList:[1,3,5,10,20,50],
			pageSize:3
			">
		<thead>
			<tr>
				<th data-options="field:'name',width:1,align:'center'">客户姓名</th>
				<th data-options="field:'age',width:1,align:'center'">年龄</th>
				<th data-options="field:'gender',formatter:genderFormatter,width:1,align:'center'">性别</th>
				<th data-options="field:'tel',width:1,align:'center'">联系电话</th>
				<th data-options="field:'sellerName',width:1,align:'center'">营销人员</th>
				<th data-options="field:'inputUserName',width:1,align:'center'">创建人</th>
			</tr>
		</thead>
	</table>
	<!-- 定义对话框 -->
	<div id="customer_dialog">
		<form id="customer_dialog_form" method="post" >
			<input type="hidden" class="clear_this" name="id">
			<input type="hidden" class="clear_this" id="customer_dialog_customerName" name="name">
			<input type="hidden" name="inputUser.id" value="${sessionScope.USER_IN_SESSION.id}">
			<table align="center" >
				<!-- 基本信息 -->
				<tr>
					<!-- 下拉列表供选 -->
					<td>客户姓名</td><td><input id="customer_dialog_cb_potentialCustomers"  name="potentialId"/></td><td>年龄</td><td><input class="clear_this easyui-validatebox" required=true type="text" name="age" style="margin-top: 10px"></td>
				</tr>
				<tr>
					<td>联系电话</td><td><input class="clear_this easyui-validatebox" type="text" name="tel" required=true></td>
					<td>性别</td><td>
						<select class="easyui-combobox" name="gender" >
							<option value="0">女</option>
							<option value="1">男</option>
						</select>
					</td>
				</tr>
				<!-- 联系方式 -->
				<tr>
					<td>创建人</td><td><label>${sessionScope.USER_IN_SESSION.nickName}</label> </td>
					<td>电子邮箱</td><td><input class="clear_this " type="text" name="email" ></td>
				</tr>
				<tr>
					<td>QQ</td><td><input class="clear_this " type="text" name="qq" ></td>
					<td>微信</td><td><input class="clear_this " type="text" name="wechat" ></td>
				</tr>
				<!-- 扩展信息 -->
				<tr><td></td><td></td></tr>
				<tr>
					<td>职业</td><td><input class="clear_this " type="text" name="job" ></td>
					<td>收入水平</td><td><input class="clear_this " type="text" name="salaryLevel" ></td>
				</tr>
				<tr>
					<td>营销人员</td><td><input id="customer_dialog_cb_seller" class="clear_this " type="text" name="seller.id" ></td>
					<td>客户来源</td><td><input class="clear_this " type="text" name="customerSource" ></td>
				</tr>
				<tr>
					<td>客户等级</td>
					<td>
						<select name="level" class="clear_this">
							<option id="普通客户">普通客户</option>
							<option id="合作伙伴">合作伙伴</option>
							<option id="大客户">大客户</option>
							<option id="战略合作伙伴">战略合作伙伴</option>
							<option id="重点开发客户">重点开发客户</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 定义顶部按钮 -->
	<div id="customer_datagrid_tb">
	<div>
		<a id="customer_datagrid_add" class="easyui-linkbutton" plain=true iconCls="icon-add" data-cmd="add">新增</a>
		<a id="customer_datagrid_edit" class="easyui-linkbutton" plain=true iconCls="icon-edit" data-cmd="edit">编辑</a>
		<a id="customer_datagrid_del" class="easyui-linkbutton" plain=true iconCls="icon-remove" data-cmd="del">删除</a>
		<a id="customer_datagrid_refresh" class="easyui-linkbutton" plain=true iconCls="icon-reload" data-cmd="refresh">刷新</a>
	</div>
	 <div>
	 <form id="customer_datagrid_table_form">
		客户名称<input type="text" name="keyword" style="width: 80px">
		<!-- 负责人<select  class="customer_cb_depts" name="inputId" style="width: 80px"> 
		</select>-->
		<a id="customer_search" class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent" >搜索</a>
	</form>
	</div> 
	</div>
	<!-- 定义底部按钮 -->
	<div id="customer_dialog_buttons" align="center">
		<a id="customer_dialog_save" class="easyui-linkbutton" data-cmd="save">保存</a>
		<a id="customer_dialog_cancel" class="easyui-linkbutton" data-cmd="cancel">取消</a>
	</div>
</body>
</html>