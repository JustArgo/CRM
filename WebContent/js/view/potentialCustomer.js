$(function(){
//1,定义所需要的变量名
	var pcDatagridAdd,pcDatagridEdit,pcDatagridDel,
		pcDatagridRefresh,pcDialog,pcDatagrid,pcDialogForm,
		pcCbDepts,pcSearch,pcDatagridTableForm,pcCbRoles,clearThis;
//2，获取变量所代表的标签
	pcDatagridAdd=$("#pc_datagrid_add");
	pcDatagridEdit=$("#pc_datagrid_edit");
	pcDatagridDel=$("#pc_datagrid_del");
	pcDatagridRefresh=$("#pc_datagrid_refresh");
	pcDialog=$("#pc_dialog");
	pcDatagrid=$("#pc_datagrid");
	pcDialogForm=$("#pc_dialog_form");
	pcCbDepts=$(".pc_cb_depts");
	pcSearch=$("#pc_search");
	pcDatagridTableForm=$("#pc_datagrid_table_form");
	pcCbRoles=$("#pc_cb_roles");
	clearThis=$(".clear_this");
//3，统一管理方法
	var cmdObject={
			add:function(){
				//清空表单数据
				clearThis.val("");
				pcDialog.dialog("open");
				pcDialog.dialog("setTitle","新增");
			},
			edit:function(){
				var rowData=pcDatagrid.datagrid("getSelected");
				if(rowData){
					clearThis.val("");
				pcDialog.dialog("open");
				pcDialog.dialog("setTitle","编辑");
				//数据回显,特殊数据处理
				rowData["dept.id"]=rowData.did;
				pcDialogForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择要编辑的员工","info");
				}
			},
			del:function(){
				var rowData=pcDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","确定要删除该潜在客户",function(yes){
						if(yes){
							$.get("/pc_del",{id:rowData.id},function(data){
								$.messager.alert("温馨提示,",data.msg,"info",function(){
									if(data.success){
										pcDatagrid.datagrid("load");
									}
								});
							});
						}
					});
					
				}else{
					$.messager.alert("温馨提示","请选择要删除的潜在客户","info");
				}
				
			},
			refresh:function(){
				pcDatagrid.datagrid("load");
				$.messager.alert("温馨提示","刷新成功","info");
			},
			save:function(){
				pcDialogForm.form("submit",{
					url:"/pc_save",
					success:function(data){
						data=$.parseJSON(data);
						$.messager.alert("温馨提示,",data.msg,"info",function(){
							if(data.success){
								pcDialog.dialog("close");
								pcDatagrid.datagrid("load");
							}
						});
					}
				});
			},
			cancel:function(){
				pcDialog.dialog("close");
			},
			searchContent:function(){
				var value={};
				var fields=pcDatagridTableForm.serializeArray();
				$.each(fields,function(index,field){
					value[field.name]=field.value;
				});
				console.debug(value);
				//把数据传输进去
				pcDatagrid.datagrid("load",value);
			}
			
	};
	//调用管理的方法
	$("a").on("click",function(){
		if($(this).data("cmd")){
		var func=$(this).data("cmd");
		cmdObject[func]();
		}
	});
	//定义对话框
	pcDialog.dialog({
		closable:true,
		width:250,
		height:300,
		modal:true,
		closed:true,
		buttons:"#pc_dialog_buttons"
	});
	//定义下拉选择框
	pcCbDepts.combobox({
		url:"/depts_forEmp",
		valueField:"did",
		textField:"dname"
	});
	//定义角色选择下拉框（可多选）
	pcCbRoles.combobox({
		url:"/role_queryForEmp",
		valueField:"rid",
		textField:"rname",
		multiple:true
	});
	
});
