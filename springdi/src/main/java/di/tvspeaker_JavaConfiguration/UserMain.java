package di.tvspeaker_JavaConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context 
		= new AnnotationConfigApplicationContext(Config.class);

		SamsungTV samsungTV = context.getBean("samsungTV", SamsungTV.class);
		samsungTV.turnon();
		samsungTV.turnoff();
		samsungTV.volumeup();
		samsungTV.volumedown();
		samsungTV.printSpeakerBrand();
		
		LgTV lgTV = context.getBean("lgTV", LgTV.class);
		lgTV.turnon();
		lgTV.turnoff();
		lgTV.volumeup();
		lgTV.volumedown();
		lgTV.printSpeakerBrand();
	}
}
