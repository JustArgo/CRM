$(function(){
	//1,将所有需要使用的变量先定义出来
	var deptDatagrid,deptDialog,deptDialogManager,deptDialogParent,deptDialogForm,deptDialogFormId;
	//2,通过选择器方式将对象存到变量中,缓存起来
	deptDatagrid = $("#dept_datagrid");
	deptDialog = $("#dept_dialog");
	deptDialogManager=$("#dept_dialog_manager");
	deptDialogParent = $("#dept_dialog_parent");
	deptDialogForm = $("#dept_dialog_form");
	deptDialogFormId = $("#dept_dialog_form input[name='id']");
	//3,组件初始化.
	deptDatagrid.datagrid({
		url:'/department_list',
		fit:true,
		singleSelect:true,
		pagination:true,
		fitColumns:true,
		toolbar:"#dept_datagrid_tb",
		columns:[[
		          {field:'sn',title:'部门编号',width:100,align:'center'},
		          {field:'name',title:'部门名称',width:100,align:'center'},
		          {field:'mname',title:'管理者',width:100,align:'center'},
		          {field:'pname',title:'父部门',width:100,align:'center'}
		]]
		
	});
	deptDialog.dialog({
		title:'编辑框',
		width:250,
		height:200,
		modal:true,
		closed:true,
		buttons:"#dept_dialog_bt"
	});
	
	
	//管理员选择：下拉表格
	deptDialogManager.combogrid({
			 delay: 500,    
			 mode: 'remote',    
			 url: '/queryManagerForDept',    
			 idField: 'id',
			 textField: 'nickName',    
			 fitColumns:true,
			 panelWidth:450,
		     columns: [[    
			        {field:'username',title:'用户名',width:1,sortable:true},    
			        {field:'nickName',title:'昵称',width:1,sortable:true},
			        {field:'email',title:'邮箱',width:1,sortable:true},    
			        {field:'dname',title:'所属部门',width:1,sortable:true}    
			    ]],
			 onClickRow:function(rowIndex,rowData){
				var datagridRowData = deptDatagrid.datagrid("getSelected");
				//判断选中的记录里面的管理员id   
				//和目前需要选择的id是否一致
				//不一致才进行判断
				if(rowData.managerId){
					if(rowData.id!=datagridRowData.mid){
						$.messager.show({
			                title:'温馨提示',
			                msg:'不能选择该员工,因为该员工已有对应部门',
			                timeout:2000,
			                showType:'slide'
			            });
			            
			            deptDialogManager.combogrid("setValue","");
					}
		            
				}
			 }
	});
	//选择父部门：树形下拉框
	deptDialogParent.combotree({
		url:"/department_queryParentForDept",
		onClick:function(node){
			
			if(deptDialogFormId.val()){
				
				var rowData=deptDatagrid.datagrid("getSelected");
				if(!cmdObj.checkNode(node,rowData.id)){
					$.messager.show({
						title:'温馨提示',
						msg:'不能选择自己或自己的子部门作为自己的父部门',
						timeout:2000,
						showType:'slide'
					});
					deptDialogParent.combotree("setValue","");
				}
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
					var myTree = deptDialogParent.combotree("tree");
					var parent = myTree.tree("getParent",node.target);
					if(parent){
						return cmdObj.checkNode(parent,id);
					}
					return true;
				}
			},
			add:function(){
				//清空表单数据
				deptDialogForm.form("clear");
				//打开对话框
				deptDialog.dialog("open");
				//修改title
				deptDialog.dialog("setTitle","新增");
			},
			cancel:function(){
				deptDialog.dialog("close");
			},
			edit:function(){
				//判断有没有数据
				var rowData = deptDatagrid.datagrid("getSelected");
				if(rowData){
					//清空表单数据
					deptDialogForm.form("clear");
					//打开对话框
					deptDialog.dialog("open");
					//修改title
					deptDialog.dialog("setTitle","编辑");
					//处理特殊数据
					rowData["manager.id"] = rowData.mid;
					rowData["parent.id"] = rowData.pid;
					//数据回显
					deptDialogForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择数据");
				}
			},
			save:function(){
				var id = deptDialogFormId.val();
				var url ;
				if(id){
					url = "/department_update";
				}else{
					console.debug(id);
					url = "/department_save";
				}
				deptDialogForm.form("submit",{
					url:url,
					success:function(data){
						//eval  {'version':1.0}
						//{"version":1.0}  eval("("+data+")")
						data = $.parseJSON(data);
						if(data.success){
							$.messager.alert("温馨提示",data.msg,"info",function(){
								//提示
								   //关闭对话
									//刷新数据表格
								deptDialog.dialog("close");
								deptDatagrid.datagrid("load");
								//更新combogrid的内容
								var grid = deptDialogManager.combogrid("grid");
								grid.datagrid("load");
								var myTree = deptDialogParent.combotree("tree");
								myTree.tree("reload");
							});
							
						}else{
							$.messager.alert("温馨提示",data.msg,"info");
						}
					}
				});
			},
			del:function(){
				var rowData=deptDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","确定要删除该部门",function(yes){
						if(yes){
							$.get("/department_del",{id:rowData.id},function(data){
								$.messager.alert("温馨提示,",data.msg,"info",function(){
									if(data.success){
										deptDatagrid.datagrid("load");
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