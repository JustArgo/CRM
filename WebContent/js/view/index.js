$(function(){
	$("#index_menu_tree").tree({
		url:'/js/data/menu.json',
		onClick:function(node){
			var data=$("#index_tabs").tabs("exists",node.text);
		if(data){
			$("#index_tabs").tabs("select",node.text);
		}else{
			if(node.attributes){
				$("#index_tabs").tabs("add",{
					title:node.text,
					closable:true,
					content:"<iframe src='"+node.attributes.url+"' style='width:100%;height:100%;' frameborder='0'></iframe>"
				});
				}
			}
		}
	});
})