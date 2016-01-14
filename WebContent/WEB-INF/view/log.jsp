<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志查看</title>
<%@include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript" src="/js/view/log.js"></script>
</head>
<body>
	<table 
	    id="log_datagrid"
	    url="/log/list"
	    method="post"
		fit="true"
		class="easyui-datagrid"
		fitColumns="true"
		pagination="true"
		pageList="[5,10,15]"
		pageSize="10"
		toolbar="#log_datagrid_tb"
		singleSelect="true">	
			<thead>
				<tr>
					<th field="operatorName" width="100" align="center">操作用户</th>
					<th field="actionTime" width="100" align="center">操作时间</th>
					<th field="actionDetail" width="100" align="center">操作方法</th>
					<th field="ip" width="100" align="center">ip</th>
				</tr>		
			</thead>
	
	</table>
	
	<!-- 定义顶部按钮 -->
	<div id="log_datagrid_tb">
		<div>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
		</div>
		<div>
			<form id="log_search_form">
			操作用户:<input type="text" name="operatorName">
			操作时间:<input type="text" name="begindate" class="easyui-datebox">~<input type="easyui-datebox" name="enddate" class="easyui-datebox">
			     <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">搜索</a>
			      <a class="easyui-linkbutton" iconCls="icon-remove" data-cmd="clean">清除</a>
			</form>
		</div>
	</div>
	
</body>
</html>