package di.xml01;

import java.util.List;
import java.util.Map;

public class Car {
	
	private Tire tire;
	private String carName;
	private int year;
	private List<String> driver;
	
	public List<String> getDriver() {
		return driver;
	}
	public Map<Object, String> carhistory;

	public Map<Object, String> getCarhistory() {
		return carhistory;
	}

	public void setCarhistory(Map<Object, String> carhistory) {
		this.carhistory = carhistory;
	}

	public void setDriver(List<String> driver) {
		this.driver = driver;
	}

	public Car() {
		System.out.println("Car()생성자입니다.");
	}
	
	public Car(Tire t) {
		this.tire = t;
		System.out.println("Car(Tire t)생성자입니다.");
	}
	
	public Car(String carname, Tire t) {
		this.tire = t;
		System.out.println("Car(String carname, Tire t)생성자입니다.");
	}
	
	public Car(Tire t, String carname) {
		this.tire = t;
		System.out.println("Car(Tire t, String carname)생성자입니다.");
	}
	
	public Car(String carname, int year, Tire t) {
		this.tire = t;
		System.out.println("Car(String carname, int year, Tire t)생성자입니다.");
	}
	
	public void printTireBrand() {
		System.out.println("타이어브랜드는 " + tire.getTireBrand());
	}
}
