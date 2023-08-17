package di.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverMain {
	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(Config.class);
		
		Car c = context.getBean("car", Car.class);
		c.printTireBrand();
	}
}
