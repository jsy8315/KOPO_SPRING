package basic.di;

public class DriverMain {
	public static void main(String[] args) {
		
		KumhoTire k = new KumhoTire();
				
		Car car2 = new Car(k);
		car2.printTireBrand();
		
/*		Car car = new Car();
		HankookTire hankook = new HankookTire();
		KumhoTire kumho = new KumhoTire();
		
		car.setTire(kumho);		//setter를 통한 DI
		car.printTireBrand();
*/
	}
}
