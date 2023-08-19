package di.calculator_Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("calculatorAW.xml");
		
		AddCalculator addcalculator = context.getBean("AddCalculator", AddCalculator.class);
		int result = addcalculator.calculate();
		System.out.println("Result: " + result);

		SubCalculator subcalculator = context.getBean("SubCalculator",SubCalculator.class);
		int result02 = subcalculator.calculate();
		System.out.println("Result: " + result02);
		
		MulCalculator mulcalculator = context.getBean("MulCalculator", MulCalculator.class);
		int result03 = mulcalculator.calculate();
		System.out.println("Result: " + result03);
		
		DivideCalculator dividecalculator = context.getBean("DivideCalculator", DivideCalculator.class);
		dividecalculator.calculate02();
	}
}
