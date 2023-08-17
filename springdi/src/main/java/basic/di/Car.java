package basic.di;

public class Car {
	
	private Tire tire;
	
	public Car() {
		System.out.println("Car()생성자입니다.");
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void printTireBrand() {
		System.out.println("타이어브랜드는 " + tire.getTireBrand());
	}
}
