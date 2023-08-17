package di.anno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Car {
	//Autowired -> spring에서 제공, 가장 많이 씀
	//Resource -> JAVA EE에서 제공, EE는 기업환경
	//Inject -> JAVA EE에서 제공
	
	private Tire tire;
	
	public Car() {
		System.out.println("Car()생성자입니다.");
	}
	
	@Autowired
	public Car(@Qualifier("h") Tire t) {
		this.tire = t;
		System.out.println("Car(Tire t)생성자입니다.");
	}

	public Tire getTire() {
		return tire;
	}
	
	//@Qualifier("k") //아이디가 h인걸로 di 부탁
	//@Autowired
	public void setTire(Tire tire) {
		System.out.println("setTire(Tire tire)입니다");
		this.tire = tire;
	}
	
	public void printTireBrand() {
		System.out.println("타이어브랜드는 " + tire.getTireBrand());
	}
}
