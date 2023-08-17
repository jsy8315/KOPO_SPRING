package di.tvspeaker01;

import org.springframework.stereotype.Component;

@Component("b1")
public class BoSpeaker implements Speaker{

	public String getSpeakerBrand() {
		// TODO Auto-generated method stub
		return "BO스피커";
	}

	public void volumeUp() {
		// TODO Auto-generated method stub
		
	}

	public void volumeDown() {
		// TODO Auto-generated method stub
		
	}

}
