package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		MessageBean bean = (MessageBean)ctx.getBean("messageBean");
		
		bean.sayHello("Spring");
	}

}
