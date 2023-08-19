package di.calculator_SetterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("calculatorSI.xml");
		
		AddCalculator AddCalculator02 = context.getBean("AddCalculator02", AddCalculator.class);
		int result = AddCalculator02.calculate();
		System.out.println("Result: " + result);

		SubCalculator SubCalculator02 = context.getBean("SubCalculator02", SubCalculator.class);
		int result02 = SubCalculator02.calculate();
		System.out.println("Result: " + result02);
		
		MulCalculator MulCalculator02 = context.getBean("MulCalculator02", MulCalculator.class);
		int result03 = MulCalculator02.calculate();
		System.out.println("Result: " + result03);
		
		DivideCalculator DivideCalculator02 = context.getBean("DivideCalculator02", DivideCalculator.class);
		DivideCalculator02.calculate02();
	}
}
