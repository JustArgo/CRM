<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<script type="text/javascript" src="/js/view/index.js"></script>
<script type="text/javascript">
	function getOnlineNum(){
		$.get("/countOnlineUser", function(data){
			$("#countOnlineNum").text(data);
			});
	}
	$(function(){
		setInterval("getOnlineNum()",200000);
		
		
		
	});
</script>
</head>

<body>
	<div class="easyui-layout" fit=true>
		<div data-options="region:'north'"
			style="height: 80px; background: url('/image/banner-pic.gif') no-repeat bottom; background-size: cover;">
			<center style="height:30px;">
				<h1>客户关系管理系统</h1>
			</center>
			<table align="right">
				<tr>
					<td width="150px" ><font size="2">欢迎:</font><font size="2" color="bule;">${sessionScope.USER_IN_SESSION.nickName}!</font></td>
					<td><font size="2">当前在线人数:</font><font size="2" color="blue"><span id="countOnlineNum"></span></font><font size="2">人</font></td>
				</tr>
				
			</table>
		</div>
		<div data-options="region:'west'" style="width: 170px;">
			<!-- 手风琴效果 -->
			<div class="easyui-accordion" fit=true>
				<div class="easyui-linkbutton" title="菜单">
					<ul id="index_menu_tree" class="easyui-tree"></ul>
				</div>
				<div class="easyui-linkbutton" title="帮助">帮助内容</div>
			</div>
		</div>
		<div id="index_tabs" class="easyui-tabs"
			data-options="region:'center'"
			style="padding: 5px; background: #eee;">
			<div title="欢迎页" closable=true>
				<center>
					<h1>
						<font color="blue">欢迎进入管理系统</font>
					</h1>
				</center>
			</div>
		</div>
		<div data-options="region:'south'"
			style="height: 30px; background: url('/image/banner-pic.gif') no-repeat bottom; background-size: cover;">
			<center>@Pakin</center>
		</div>
	</div>
</body>
</html>