package di.tvspeaker_SetterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.tvspeaker_SetterInjection.LgTV;
import di.tvspeaker_SetterInjection.SamsungTV;

public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("tvspeakerSI.xml");
		
		SamsungTV samsungTV02 = context.getBean("SamsungTV02", SamsungTV.class);
		samsungTV02.turnon();
		samsungTV02.turnoff();
		samsungTV02.volumeup();
		samsungTV02.volumedown();
		samsungTV02.printSpeakerBrand();
		
		LgTV lgTV02 = context.getBean("LgTV02", LgTV.class);
		lgTV02.turnon();
		lgTV02.turnoff();
		lgTV02.volumeup();
		lgTV02.volumedown();
		lgTV02.printSpeakerBrand();
	}

}
