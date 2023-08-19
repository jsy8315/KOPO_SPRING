package di.calculator_JavaConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DivideCalculator implements Calculator{
	private int n1;
	private int n2;

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	//생성자1
	public DivideCalculator() {
		
	}
	
	//생성자2
	@Autowired
	public DivideCalculator(@Value("10") int n1, @Value("3") int n2) {
	    this.n1 = n1;
	    this.n2 = n2;
	}
	
	public int calculate()
	{
		return n1 / n2;
	}
	public void calculate02() {
	      double result = (double)n1/n2;
	      String formattedResult = String.format("%.2f", result);
	      System.out.println("Result: " + formattedResult);
	}
		
}
