$(function(){
//1,定义所需要的变量名
	var empDatagridAdd,empDatagridEdit,empDatagridDel,
		empDatagridRefresh,empDialog,empDatagrid,empDialogForm,
		empCbDepts,empSearch,empDatagridTableForm,empCbRoles;
//2，获取变量所代表的标签
	empDatagridAdd=$("#emp_datagrid_add");
	empDatagridEdit=$("#emp_datagrid_edit");
	empDatagridDel=$("#emp_datagrid_del");
	empDatagridRefresh=$("#emp_datagrid_refresh");
	empDialog=$("#emp_dialog");
	empDatagrid=$("#emp_datagrid");
	empDialogForm=$("#emp_dialog_form");
	empCbDepts=$(".emp_cb_depts");
	empSearch=$("#emp_search");
	empDatagridTableForm=$("#emp_datagrid_table_form");
	empCbRoles=$("#emp_cb_roles");
//3，统一管理方法
	var cmdObject={
			add:function(){
				empDialogForm.form("clear");
				empDialog.dialog("open");
				empDialog.dialog("setTitle","新增");
			},
			edit:function(){
				var rowData=empDatagrid.datagrid("getSelected");
				if(rowData){
				empDialogForm.form("clear");
				empDialog.dialog("open");
				empDialog.dialog("setTitle","编辑");
				//数据回显,特殊数据处理
				rowData["dept.id"]=rowData.did;
				empDialogForm.form("load",rowData);
				//roles数据回显
				var html=$.ajax({
					url:"/role_queryRoleByEid?eid="+rowData.id,
					async:false
				}).responseText;
				html=$.parseJSON(html);
				console.debug(html);
				empCbRoles.combobox("setValues",html);
				}else{
					$.messager.alert("温馨提示","请选择要编辑的员工","info");
				}
			},
			del:function(){
				var rowData=empDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","确定要离职该员工",function(yes){
						if(yes){
							$.get("/employee_del",{id:rowData.id},function(data){
								$.messager.alert("温馨提示,",data.msg,"info",function(){
									if(data.success){
										empDatagrid.datagrid("load");
									}
								});
							});
						}
					});
					
				}else{
					$.messager.alert("温馨提示","请选择要删除的员工","info");
				}
				
			},
			refresh:function(){
				empDatagrid.datagrid("load");
				$.messager.alert("温馨提示","刷新成功","info");
			},
			save:function(){
				empDialogForm.form("submit",{
					url:"/employee_save",
					onSubmit:function(param){
						var roles=empCbRoles.combobox("getValues");
						$.each(roles,function(index,item){
							console.debug(item);
							param["roles["+index+"].id"]=item;
						});
					},
					success:function(data){
						data=$.parseJSON(data);
						$.messager.alert("温馨提示,",data.msg,"info",function(){
							if(data.success){
								empDialog.dialog("close");
								empDatagrid.datagrid("load");
							}
						});
					}
				});
			},
			cancel:function(){
				empDialog.dialog("close");
			},
			searchContent:function(){
				var value={};
				var fields=empDatagridTableForm.serializeArray();
				$.each(fields,function(index,field){
					value[field.name]=field.value;
				});
				console.debug(value);
				//把数据传输进去
				empDatagrid.datagrid("load",value);
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
	empDialog.dialog({
		closable:true,
		width:250,
		height:240,
		modal:true,
		closed:true,
		buttons:"#emp_dialog_buttons"
	});
	//定义下拉选择框
	empCbDepts.combobox({
		url:"/depts_forEmp",
		valueField:"did",
		textField:"dname"
	});
	//定义角色选择下拉框（可多选）
	empCbRoles.combobox({
		url:"/role_queryForEmp",
		valueField:"rid",
		textField:"rname",
		multiple:true
	});
	
});
//状态的格式化
function statusFormatter(value,row,index){
	if(value==0){
		return "<font color='red'>离职</font>";
	}else{
		return "<font color='blue'>正常</font>";
	}
}