package di.xml02;

public class Car {
	
	private Tire tire;
	
	private Tire stire;
	
	public Car() {
		System.out.println("Car()생성자입니다.");
	}
	String carName;
	int year;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		System.out.println("이건 setTire(Tire tire)입니다.");
		this.tire = tire;
	}
	
	public void printTireBrand() {
		System.out.println("타이어브랜드는 " + tire.getTireBrand() + "입니다.");
		System.out.println("스페어타이어브랜드는 " + stire.getTireBrand() + "입니다.");
	}

	@Override
	public String toString() {
		return "Car [tire=" + tire + ", carName=" + carName + ", "
				+ "year=" + year + ", stire=" + stire + "]";
	}

	public Tire getStire() {
		return stire;
	}

	public void setStire(Tire stire) {
		this.stire = stire;
	}
	
}
