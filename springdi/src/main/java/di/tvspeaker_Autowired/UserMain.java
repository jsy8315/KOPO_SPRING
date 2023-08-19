package di.tvspeaker_Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("tvspeakerAW.xml");
		
		SamsungTV samsungtv = context.getBean("samsungtv", SamsungTV.class);
		samsungtv.turnon();
		samsungtv.turnoff();
		samsungtv.volumeup();
		samsungtv.volumedown();
		samsungtv.printSpeakerBrand();
		
		LgTV lgtv = context.getBean("lgtv", LgTV.class);
		lgtv.turnon();
		lgtv.turnoff();
		lgtv.volumeup();
		lgtv.volumedown();
		lgtv.printSpeakerBrand();
	}

}
