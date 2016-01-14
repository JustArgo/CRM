$(function(){
	//1,将所有需要使用的变量先定义出来
	var roleDatagrid,roleDialog,roleDialogSelfPermissions,roleDialogAllPermissions,roleDialogForm,roleDialogFormId,roleDialogSn,roleDialogName;
	//2,通过选择器方式将对象存到变量中,缓存起来
	roleDatagrid = $("#role_datagrid");
	roleDialog = $("#role_dialog");
	roleDialogSelfPermissions=$("#role_dialog_selfPermissions");
	roleDialogAllPermissions = $("#role_dialog_allPermissions");
	roleDialogForm = $("#role_dialog_form");
	roleDialogFormId = $("#role_dialog_form input[name='id']");
	roleDialogSn=$("#role_dialog_sn");
	roleDialogName=$("#role_dialog_name");
	//3,组件初始化.
	roleDatagrid.datagrid({
		url:"/role_list",
		fit:true,
		singleSelect:true,
		pagination:true,
		pageList:[1,3,10,30],
		fitColumns:true,
		toolbar:"#role_datagrid_tb",
		columns:[[
		          {field:'sn',title:'角色编号',width:100,align:'center'},
		          {field:'name',title:'角色名称',width:100,align:'center'}
		]]
		
	});
	roleDialog.dialog({
		title:'编辑框',
		width:900,
		height:500,
		modal:true,
		closed:true,
		buttons:"#role_dialog_bt"
	});
	
	
	//已选择权限
	roleDialogSelfPermissions.datagrid({
		title:"用户权限集合",
		singleSelect:true,
		width:450,
		height:300,
		fitColumns:true,
		columns:[[
		          {field:'sn',title:'权限编号',width:1,align:'center'},
		          {field:'name',title:'权限名称',width:1,align:'center'},
		          {field:'resourceName',title:'资源名称',width:3,align:'center'}
		]],
		onDblClickRow:function(rowIndex,rowData){
			roleDialogSelfPermissions.datagrid("deleteRow",rowIndex);
		}
	});
	//全部权限
	roleDialogAllPermissions.datagrid({
		url:"/permisson_queryPermissionisForRole",
		title:"全部权限集合",
		singleSelect:true,
		width:450,
		height:300,
		pagination:true,
		fitColumns:true,
		columns:[[
		          {field:'sn',title:'权限编号',width:1,align:'center'},
		          {field:'name',title:'权限名称',width:1,align:'center'},
		          {field:'resourceName',title:'资源名称',width:3,align:'center'}
		]],
		onDblClickRow:function(rowIndex,rowData){
			var rows=roleDialogSelfPermissions.datagrid("getRows");
			var flag=true;
			$.each(rows,function(index,item){
				if(rowData.id==item.id){
					flag=false;
					return;
				}
			});
			if(flag){
				roleDialogSelfPermissions.datagrid("insertRow",{
					row:rowData
				});
			}else{
				$.messager.alert("温馨提示","不能重复选择");
			}
		}
	});
	//4,方法通过管理
	var cmdObj= {
			checkNode:function(node,id){
				if(node.id==id){
					return false;
				}else{
					//找到父节点,判断id是否相同
					//找到tree
					var myTree = roleDialogParent.combotree("tree");
					var parent = myTree.tree("getParent",node.target);
					if(parent){
						return cmdObj.checkNode(parent,id);
					}
					return true;
				}
			},
			add:function(){
				//清空表单数据
				roleDialogSn.val("");
				roleDialogName.val("");
				roleDialogFormId.val("");
				//打开对话框
				roleDialog.dialog("open");
				//清空数据
				roleDialogSelfPermissions.datagrid("loadData",{rows:[]});
				//修改title
				roleDialog.dialog("setTitle","新增");
			},
			cancel:function(){
				roleDialog.dialog("close");
			},
			edit:function(){
				//判断有没有数据
				var rowData = roleDatagrid.datagrid("getSelected");
				if(rowData){
					//清空表单数据
					roleDialogSn.val("");
					roleDialogName.val("");
					//打开对话框
					roleDialog.dialog("open");
					//修改title
					roleDialog.dialog("setTitle","编辑");
					//处理特殊数据
						roleDialogSelfPermissions.datagrid("options").url="/role_queryOwnPermission";
						roleDialogSelfPermissions.datagrid("load",{id:rowData.id});
					//数据回显
					roleDialogForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择数据");
				}
			},
			save:function(){
				var id = roleDialogFormId.val();
				var url ;
				if(id){
					url = "/role_update";
				}else{
					console.debug(id);
					url = "/role_save";
				}
				roleDialogForm.form("submit",{
					url:url,
					onSubmit:function(param){
						//循环已选择权限列表，封装permissions[index].id:id
						var dataRows=roleDialogSelfPermissions.datagrid("getRows");
						$.each(dataRows,function(index,item){
							//封装提交参数
							param["permissions["+index+"].id"]=item.id;
						});
					},
					success:function(data){
						//eval  {'version':1.0}
						//{"version":1.0}  eval("("+data+")")
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								//提示
								   //关闭对话
									//刷新数据表格
								roleDialog.dialog("close");
								roleDatagrid.datagrid("load");
							});
							
						}else{
							$.messager.alert("温馨提示",data.msg,"info");
						}
					}
				});
			},
			refresh:function(){
				roleDatagrid.datagrid("load");
				$.messager.alert("温馨提示","刷新成功","info");
			},
			del:function(){
				var rowData=roleDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","确定要删除该角色",function(yes){
						if(yes){
							$.get("/role_del",{id:rowData.id},function(data){
								$.messager.alert("温馨提示,",data.msg,"info",function(){
									if(data.success){
										roleDatagrid.datagrid("load");
									}
								});
							});
						}
					});
					
				}else{
					$.messager.alert("温馨提示","请选择要删除的员工","info");
				}
				
			}
	};
	//5,每个按钮添加统一事件
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});
});