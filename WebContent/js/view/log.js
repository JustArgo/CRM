$(function(){
	//1,定义需要使用组件变量
	var logDatagrid,logSearchForm;
	//2,通过id选择器获取到,并缓存起来
	logDatagrid = $("#log_datagrid");
	logSearchForm = $("#log_search_form");
	

	
	//定义命令对象,管理方法
	var cmdObj={
			refresh:function (){
				logDatagrid.datagrid("reload");
			},
			searchContent:function(){
				var value={};
				var formArry = logSearchForm.serializeArray();
				$.each(formArry,function(index,obj){
					if(obj.value!=''){
						value[obj.name]=obj.value;
					}
				});
				//调用datagrid的load,把数据传输进去
				logDatagrid.datagrid("load",value);
			},
			clean:function(){
				var ids = new Array(1,2,3,4);
				console.log(typeof ids);
				var dds = $.map(ids,function(index,item){
					return item.id;
				});
				console.log("typeof dds "+typeof dds)
				console.log(dds);
				var param = $.param({"ids":ids},true);
				console.log(param);
				console.log(typeof param);
				logSearchForm.form('clear');
			}

			
	}
	//5,为按钮添加统一事件
	$("a").on("click",function(){
		//调对应的方法
		var cmd = $(this).data("cmd");
		if(cmd){
			cmdObj[cmd]();
		}
	});
	
});












