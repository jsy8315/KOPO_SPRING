package di.calculator_Autowired;

public class AddCalculator implements Calculator{
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
	public AddCalculator() {
		
	}
	
	//생성자2
	public AddCalculator(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public int calculate()
	{
		return n1 + n2;
	}
}
