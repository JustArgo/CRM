$(function(){
//1,定义所需要的变量名
	var customerTransferDialog,customerTransferDatagrid,customerTransferDialogForm,
	customerTransferDatagridTableForm,
	clearThis,customerTransferDialogCbCustomers,customerTransferDialogCbTransUsers,
	customerTransferDialogCbOldSellers,customerTransferDialogCbNewSellers;
//2，获取变量所代表的标签
	customerTransferDatagridRefresh=$("#customerTransfer_datagrid_refresh");
	customerTransferDialog=$("#customerTransfer_dialog");
	customerTransferDatagrid=$("#customerTransfer_datagrid");
	customerTransferDialogForm=$("#customerTransfer_dialog_form");
	customerTransferDatagridTableForm=$("#customerTransfer_datagrid_table_form");
	customerTransferDialogCbCustomers=$("#customerTransfer_dialog_cb_customers");
	customerTransferDialogCbTransUsers=$("#customerTransfer_dialog_cb_transUsers");
	customerTransferDialogCbOldSellers=$("#customerTransfer_dialog_cb_oldSellers");
	customerTransferDialogCbNewSellers=$("#customerTransfer_dialog_cb_newSellers");
	clearThis=$(".clear_this");
//3，统一管理方法
	var cmdObject={
			add:function(){
				//清空表单数据
				clearThis.val("");
				customerTransferDialog.dialog("open");
				customerTransferDialog.dialog("setTitle","新增");
			},
			
			refresh:function(){
				customerTransferDatagrid.datagrid("load");
				$.messager.alert("温馨提示","刷新成功","info");
			},
			save:function(){
				customerTransferDialogForm.form("submit",{
					url:"/customerTransfer_save",
					success:function(data){
						data=$.parseJSON(data);
						$.messager.alert("温馨提示,",data.msg,"info",function(){
							if(data.success){
								customerTransferDialog.dialog("close");
								customerTransferDatagrid.datagrid("load");
							}
						});
					}
				});
			},
			cancel:function(){
				customerTransferDialog.dialog("close");
			},
			searchContent:function(){
				var value={};
				var fields=customerTransferDatagridTableForm.serializeArray();
				$.each(fields,function(index,field){
					value[field.name]=field.value;
				});
				//把数据传输进去
				customerTransferDatagrid.datagrid("load",value);
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
	customerTransferDialog.dialog({
		closable:true,
		width:250,
		height:240,
		modal:true,
		closed:true,
		buttons:"#customerTransfer_dialog_buttons"
	});
	//定义下拉选择框：客户对象
	customerTransferDialogCbCustomers.combobox({
		url:"/customer_queryForOrder",
		valueField:"cid",
		textField:"cname",
		onSelect:function(record){
			customerTransferDialogCbOldSellers.val(record.sellerName);
		}
	});
	//移交人员
	customerTransferDialogCbTransUsers.combobox({
		url:"/employee_queryForCustomer",
		valueField:"eid",
		textField:"ename"
	});
	//新营销员
	customerTransferDialogCbNewSellers.combobox({
		url:"/employee_queryForCustomer",
		valueField:"eid",
		textField:"ename"
	});
});
