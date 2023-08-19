package di.calculator_JavaConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context 
		= new AnnotationConfigApplicationContext(Config.class);
		
		AddCalculator addcalculator = context.getBean("addCalculator", AddCalculator.class);
		int result = addcalculator.calculate();
		System.out.println("Result: " + result);

		SubCalculator subcalculator = context.getBean("subCalculator",SubCalculator.class);
		int result02 = subcalculator.calculate();
		System.out.println("Result: " + result02);
		
		MulCalculator mulcalculator = context.getBean("mulCalculator", MulCalculator.class);
		int result03 = mulcalculator.calculate();
		System.out.println("Result: " + result03);
		
		DivideCalculator dividecalculator = context.getBean("divideCalculator", DivideCalculator.class);
		dividecalculator.calculate02();
	}
}
