package di.xml01;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
	public static void main(String[] args) {
		ApplicationContext context 
			= new GenericXmlApplicationContext("spring-xml01.xml");
		Car localcar = (Car)context.getBean("car");
		localcar.printTireBrand();
		
		Car car5 = (Car)context.getBean("car5");
		List<String> list = car5.getDriver();
		for (String string : list) {
			System.out.println(string);
		}
		
		Car car6 = (Car)context.getBean("car6");
		Map<Object, String> map = car6.getCarhistory();
		for (Object key : map.keySet()) {
			String value = (String) map.get(key);
			System.out.println(key + " : " + value);
		}
	}
}
