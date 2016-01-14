package com.pakin.crm.util;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Local;

public class ActionContext {
	private static ThreadLocal<HttpSession> local = new ThreadLocal<HttpSession>();
	public static void set(HttpSession session){
		local.set(session);
	}
	public static HttpSession get(){
		return local.get();
	}
}

