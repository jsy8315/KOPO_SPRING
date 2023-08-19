package di.calculator_Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.calculator_ConstructorInjection.AddCalculator;
import di.calculator_ConstructorInjection.DivideCalculator;
import di.calculator_ConstructorInjection.MulCalculator;
import di.calculator_ConstructorInjection.SubCalculator;

public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("calculatorCI.xml");
		
		AddCalculator AddCalculator02 = (AddCalculator)context.getBean("AddCalculator02");
		int result = AddCalculator02.calculate();
		System.out.println("Result: " + result);

		SubCalculator SubCalculator02 = (SubCalculator)context.getBean("SubCalculator02");
		int result02 = SubCalculator02.calculate();
		System.out.println("Result: " + result02);
		
		MulCalculator MulCalculator02 = (MulCalculator)context.getBean("MulCalculator02");
		int result03 = MulCalculator02.calculate();
		System.out.println("Result: " + result03);
		
		DivideCalculator DivideCalculator02 = (DivideCalculator)context.getBean("DivideCalculator02");
		DivideCalculator02.calculate02();
	}
}
