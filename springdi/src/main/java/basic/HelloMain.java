package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		//Hello h1 = new Hello();
		//h1.printHello();
		
		ApplicationContext context
			= new GenericXmlApplicationContext("basic-beanContainer.xml");
		Hello h = (Hello)context.getBean("h1");
		h.printHello();
		
		Hello hh = (Hello)context.getBean("h2");
		hh.printHello();
		
		System.out.println(h);
		System.out.println(hh);
	}
}
