package yorizori.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import yorizori.domain.User;


@WebListener
public class UserAccessLoginListener implements HttpSessionAttributeListener {
	
	private static final String session_attribute_name = "loginUser";
	

    public void attributeAdded(HttpSessionBindingEvent se)  { //정의할때
//    HttpSession.setAttribute()를 통해 세로운 세션 속성이 더해질때마다 호출된다.
//    속성이 대체 된다면, attibuteReplaced()메소드가 호출
    
    	if(session_attribute_name.equals(se.getName())){
    		User user = (User)se.getValue();
    		System.out.println(user.getName() + "is login.");
    	}
    	
    	
    
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { //없어질때
//    HttpSession.removeAttribute()를 통해 세션속성이 제거 될때마다 호출
    	if(session_attribute_name.equals(se.getName())){
    		User user = (User)se.getValue();
    		System.out.println(user.getName() + "is logout.");
    	}
    	
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 

    	
    	
    	
    }
	
}
