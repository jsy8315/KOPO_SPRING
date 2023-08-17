package di.anno01;

import org.springframework.beans.factory.annotation.Autowired;


public class Car {
	//Autㅐwired -> spring에서 제공
	//Resource -> JAVA EE에서 제공, EE는 기업환경
	//Inject -> JAVA EE에서 제공
	
	@Autowired
	private Tire tire;
	
	public Car() {
		System.out.println("Car()생성자입니다.");
	}
	
	public Car(Tire t) {
		this.tire = t;
		System.out.println("Car(Tire t)생성자입니다.");
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		System.out.println("setTire(Tire tire)입니다");
		this.tire = tire;
	}
	
	public void printTireBrand() {
		System.out.println("타이어브랜드는 " + tire.getTireBrand());
	}
}
