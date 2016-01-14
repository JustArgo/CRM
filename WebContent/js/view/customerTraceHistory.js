$(function(){
//1,定义所需要的变量名
	var customerTraceDatagridAdd,customerTraceDatagridEdit,customerTraceDatagridDel,
		customerTraceDatagridRefresh,customerTraceDialog,customerTraceDatagrid,customerTraceDialogForm,
		customerTraceCbDepts,customerTraceSearch,customerTraceDatagridTableForm,customerTraceCbRoles,
		clearThis,customeTraceDialogCbCustomers,customeTraceDialogCbTraceUsers;
//2，获取变量所代表的标签
	customerTraceDatagridAdd=$("#customerTrace_datagrid_add");
	customerTraceDatagridEdit=$("#customerTrace_datagrid_edit");
	customerTraceDatagridDel=$("#customerTrace_datagrid_del");
	customerTraceDatagridRefresh=$("#customerTrace_datagrid_refresh");
	customerTraceDialog=$("#customerTrace_dialog");
	customerTraceDatagrid=$("#customerTrace_datagrid");
	customerTraceDialogForm=$("#customerTrace_dialog_form");
	customerTraceCbDepts=$(".customerTrace_cb_depts");
	customerTraceSearch=$("#customerTrace_search");
	customerTraceDatagridTableForm=$("#customerTrace_datagrid_table_form");
	customerTraceCbRoles=$("#customerTrace_cb_roles");
	customeTraceDialogCbCustomers=$("#customeTrace_dialog_cb_customers");
	customeTraceDialogCbTraceUsers=$("#customeTrace_dialog_cb_traceUers");
	clearThis=$(".clear_this");
//3，统一管理方法
	var cmdObject={
			add:function(){
				//清空表单数据
				clearThis.val("");
				customerTraceDialog.dialog("open");
				customerTraceDialog.dialog("setTitle","新增");
			},
			edit:function(){
				var rowData=customerTraceDatagrid.datagrid("getSelected");
				if(rowData){
					clearThis.val("");
				customerTraceDialog.dialog("open");
				customerTraceDialog.dialog("setTitle","编辑");
				//数据回显,特殊数据处理
				rowData["customer.id"]=rowData.customerId;
				rowData["traceUser.id"]=rowData.traceUserId;
				customerTraceDialogForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择要编辑的员工","info");
				}
			},
			del:function(){
				var rowData=customerTraceDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","确定要删除该潜在客户",function(yes){
						if(yes){
							$.get("/customerTrace_del",{id:rowData.id},function(data){
								$.messager.alert("温馨提示,",data.msg,"info",function(){
									if(data.success){
										customerTraceDatagrid.datagrid("load");
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
				customerTraceDatagrid.datagrid("load");
				$.messager.alert("温馨提示","刷新成功","info");
			},
			save:function(){
				
				var name=customeTraceDialogCbCustomers.combobox("getText");
				$(".customerId").val(name);
				console.debug(name);
				customerTraceDialogForm.form("submit",{
					url:"/customerTrace_save",
					success:function(data){
						data=$.parseJSON(data);
						$.messager.alert("温馨提示,",data.msg,"info",function(){
							if(data.success){
								customerTraceDialog.dialog("close");
								customerTraceDatagrid.datagrid("load");
							}
						});
					}
				});
			},
			cancel:function(){
				customerTraceDialog.dialog("close");
			},
			searchContent:function(){
				var value={};
				var fields=customerTraceDatagridTableForm.serializeArray();
				$.each(fields,function(index,field){
					value[field.name]=field.value;
				});
				console.debug(value);
				//把数据传输进去
				customerTraceDatagrid.datagrid("load",value);
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
	customerTraceDialog.dialog({
		closable:true,
		width:250,
		height:300,
		modal:true,
		closed:true,
		buttons:"#customerTrace_dialog_buttons"
	});
	//定义下拉选择框
	customeTraceDialogCbCustomers.combobox({
		url:"/customer_queryForOrder",
		valueField:"cid",
		textField:"cname"
	});
	customeTraceDialogCbTraceUsers.combobox({
		url:"/employee_queryForCustomer",
		valueField:"eid",
		textField:"ename",
	});
	
});
function traceResultFormatter(value,row,index){
	if(value==1){
		return "优";
	}else if(value==2){
		return "中";
	}else{
		return "差";
	}
}
