//Bean Cons
package di.tvspeaker02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.tvspeaker01.LgTv;
import di.tvspeaker01.SamsungTv;

public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context
		= new GenericXmlApplicationContext("spring-tvspeaker02.xml");
		
		Tv samsungtv = (Tv) context.getBean("samsungTv");
		samsungtv.printSpeakerBrand();
		samsungtv.tvTurnOn();
		samsungtv.tvTurnOff();
		samsungtv.tvVolumeUp();
		samsungtv.tvVolumeDown();
		
		LgTv lgtv = (LgTv) context.getBean("lgtv");
		lgtv.printSpeakerBrand();
	}
}
