package com.pakin.crm.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pakin.crm.domain.Permission;
import com.pakin.crm.service.IPermissionService;
@Component
public class PermissionUtil {
	private static IPermissionService permissionService;
	public static boolean checkPermission(String resourceName) {
		Permission  p = permissionService.queryPermissionByResource(resourceName);
		if(p!=null){
			//需要权限控制
			//2.1拿到用户所有权限
			List<Permission> permissions = (List<Permission>) ActionContext.get().getAttribute("PERMISSION_IN_SESSION");
			Permission temp;
			for (int i = 0; i < permissions.size(); i++) {
				temp = permissions.get(i);
				if(temp.getId()==p.getId()){ 
					return true;
				}
			}
			//ALL权限控制
			String allResourceName  = resourceName.split(":")[0]+":ALL";
			 p = permissionService.queryPermissionByResource(allResourceName);
			 if(p!=null){
				//判断用户是否有ALL权限
				 for (int i = 0; i < permissions.size(); i++) {
					temp = permissions.get(i);
					if(temp.getId()==p.getId()){
						//用户有ALL
						return true;
					}
				}
				return false;
			 }else{
				 return false;
			 }
			
		}else{
			//不需要权限
			return true;
		}
		/*
		 *   1,  获取到请求地址(资源路径)        
             2,判断资源是否有权限控制
                         如果需要:
                                 2.1拿到用户所有权限
                                 2.2,访问的资源和用户的所有权限进行匹配
                                           匹配
                                                   完全匹配
                          ALL匹配

		 */
	}
	@Autowired
	public  void setPermissionService(IPermissionService permissionService) {
		PermissionUtil.permissionService = permissionService;
	}
	

}
