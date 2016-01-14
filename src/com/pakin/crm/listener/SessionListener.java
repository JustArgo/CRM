package com.pakin.crm.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.pakin.crm.domain.Employee;

public class SessionListener implements HttpSessionAttributeListener
{
public void attributeAdded(HttpSessionBindingEvent event)
{
   if (event.getName().equals("USER_IN_SESSION"))
   {
   try
    {
	   Employee user=(Employee) event.getValue();
      OnlineCounter.doUser(user.getId(),false);
    } catch (Exception e)
    {
     e.printStackTrace();
    }
   }
}
public void attributeRemoved(HttpSessionBindingEvent event)
{
  
   if (event.getName().equals("USER_IN_SESSION"))
   {
    try
    {
    	Employee user=(Employee)event.getValue();
      OnlineCounter.doUser(user.getId(),true);
    } catch (Exception e)
    {
     e.printStackTrace();
    }
   }
}


public void attributeReplaced(HttpSessionBindingEvent event)
{
}

}