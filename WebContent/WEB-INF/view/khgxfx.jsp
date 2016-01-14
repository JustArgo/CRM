<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<script type="text/javascript">
function search(){
	var url;
	var SearchForm = $("#search_form");
	var value={};
	var formArry = SearchForm.serializeArray();
	$.each(formArry,function(index,obj){
		if(obj.value!=''){
			value[obj.name]=obj.value;
		}
	});
	$("#dg").datagrid('load',value);
}
	

</script>
</head>
<body style="margin:1px;">

	<table id="dg" title="客户贡献分析" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="${pageContext.request.contextPath}/customer/findCutomerGx.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="id" width="50" align="center">编号</th>
	 		<th field="name" width="300" align="center">客户名称</th>
	 		<th field="gx" width="100" align="center">订单总金额(元)</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
		<div>
		<form id="search_form">
			&nbsp;客户名称：&nbsp;<input type="text" name="name">
			计算周期:<input type="text" id="begindate" name="begindate" class="easyui-datebox">~<input type="easyui-datebox" id="enddate" name="enddate" class="easyui-datebox">
			<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</form>
		</div>
	</div>

</body>
</html>