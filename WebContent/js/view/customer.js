$(function(){
//1,定义所需要的变量名
	var customerDatagridAdd,customerDatagridEdit,customerDatagridDel,
		customerDatagridRefresh,customerDialog,customerDatagrid,customerDialogForm,
		customerCbDepts,customerSearch,customerDatagridTableForm,customerCbRoles,
		clearThis,customerDialogCbSeller,customerDialogCbPotentialCustomers,customerDialogCustomerName;
//2，获取变量所代表的标签
	customerDatagridAdd=$("#customer_datagrid_add");
	customerDatagridEdit=$("#customer_datagrid_edit");
	customerDatagridDel=$("#customer_datagrid_del");
	customerDatagridRefresh=$("#customer_datagrid_refresh");
	customerDialog=$("#customer_dialog");
	customerDatagrid=$("#customer_datagrid");
	customerDialogForm=$("#customer_dialog_form");
	customerCbDepts=$(".customer_cb_depts");
	customerSearch=$("#customer_search");
	customerDatagridTableForm=$("#customer_datagrid_table_form");
	customerCbRoles=$("#customer_cb_roles");
	clearThis=$(".clear_this");
	customerDialogCbSeller=$("#customer_dialog_cb_seller");
	customerDialogCbPotentialCustomers=$("#customer_dialog_cb_potentialCustomers");
	customerDialogCustomerName=$("#customer_dialog_customerName");
//3，统一管理方法
	var cmdObject={
			add:function(){
				//清空表单数据
				clearThis.val("");
				customerDialog.dialog("open");
				customerDialog.dialog("setTitle","新增");
			},
			edit:function(){
				var rowData=customerDatagrid.datagrid("getSelected");
				if(rowData){
					clearThis.val("");
				customerDialog.dialog("open");
				customerDialog.dialog("setTitle","编辑");
				//数据回显,特殊数据处理
				rowData["potentialCustomer.id"]=rowData.potentialId;
				rowData["potentialCustomer.name"]=rowData.potentialName;
				customerDialogForm.form("load",rowData);
				}else{
					$.messager.alert("温馨提示","请选择要编辑的员工","info");
				}
			},
			del:function(){
				var rowData=customerDatagrid.datagrid("getSelected");
				if(rowData){
					$.messager.confirm("温馨提示","确定要删除该客户",function(yes){
						if(yes){
							$.get("/customer_del",{id:rowData.id},function(data){
								$.messager.alert("温馨提示,",data.msg,"info",function(){
									if(data.success){
										customerDatagrid.datagrid("load");
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
				customerDatagrid.datagrid("load");
				$.messager.alert("温馨提示","刷新成功","info");
			},
			save:function(){
				var name2=customerDialogCbPotentialCustomers.combobox("getText");
				customerDialogCustomerName.val(name2);
				customerDialogForm.form("submit",{
					url:"/customer_save",
					success:function(data){
						data=$.parseJSON(data);
						$.messager.alert("温馨提示,",data.msg,"info",function(){
							if(data.success){
								customerDialog.dialog("close");
								customerDatagrid.datagrid("load");
							}
						});
					}
				});
			},
			cancel:function(){
				customerDialog.dialog("close");
			},
			searchContent:function(){
				var value={};
				var fields=customerDatagridTableForm.serializeArray();
				$.each(fields,function(index,field){
					value[field.name]=field.value;
				});
				console.debug(value);
				//把数据传输进去
				customerDatagrid.datagrid("load",value);
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
	customerDialog.dialog({
		closable:true,
		width:650,
		height:440,
		modal:true,
		closed:true,
		buttons:"#customer_dialog_buttons"
	});
	//定义下拉选择框
	customerDialogCbSeller.combobox({
		url:"/employee_queryForCustomer",
		valueField:"eid",
		textField:"ename"
	});
	//列出所有的潜在客户对象
	customerDialogCbPotentialCustomers.combobox({
		url:"/potential_queryForPlan",
		valueField:"pid",
		textField:"pname",
		required:true
	});
	
	
});
function genderFormatter(value,row,index){
	if(value==1){
		return "男";
	}else if(value==0){
		return "女";
	}else return "未知";
}
