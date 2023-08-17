package di.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	private Tire tire;
	
	public Car() {
		System.out.println("Car()생성자입니다.");
	}
	
	@Autowired
	public Car(@Qualifier("h1") Tire t) {
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
