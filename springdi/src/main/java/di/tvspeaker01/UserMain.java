package di.tvspeaker01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class UserMain {
	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(Config.class);
		
		SamsungTv samsungtv = context.getBean("samsungTv", SamsungTv.class);
		samsungtv.printSpeakerBrand();
		
		LgTv lgtv = context.getBean("lgTv", LgTv.class);
		lgtv.printSpeakerBrand();
	}
}
