package di.tvspeaker01;

import org.springframework.stereotype.Component;

@Component("s1")
public class SamsungSpeaker implements Speaker{

	public String getSpeakerBrand() {
		// TODO Auto-generated method stub
		return "SAMSUNG스피커";
	}

	public void volumeUp() {
		// TODO Auto-generated method stub
	}

	public void volumeDown() {
		// TODO Auto-generated method stub	
	}

}
