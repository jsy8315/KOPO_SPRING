package di.tvspeaker_ConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("tvspeakerCI.xml");
		
		SamsungTV samsungTV02 = (SamsungTV)context.getBean("SamsungTV02");
		samsungTV02.turnon();
		samsungTV02.turnoff();
		samsungTV02.volumeup();
		samsungTV02.volumedown();
		samsungTV02.printSpeakerBrand();
		
		LgTV lgTV02 = (LgTV)context.getBean("LgTV02");
		lgTV02.turnon();
		lgTV02.turnoff();
		lgTV02.volumeup();
		lgTV02.volumedown();
		lgTV02.printSpeakerBrand();
	}

}
