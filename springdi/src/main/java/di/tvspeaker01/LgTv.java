package di.tvspeaker01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LgTv implements Tv{
	
	public LgTv() {
		System.out.println("LgTv()생성자입니다.");
	}
	private Speaker leftspeaker;
	
	private Speaker rightspeaker;
	
	public Speaker getLeftspeaker() {
		return leftspeaker;
	}
	public void setLeftspeaker(Speaker leftspeaker) {
		this.leftspeaker = leftspeaker;
	}
	public Speaker getRightspeaker() {
		return rightspeaker;
	}
	public void setRightspeaker(Speaker rightspeaker) {
		this.rightspeaker = rightspeaker;
	}
	
	@Autowired
	public LgTv(@Qualifier("b1") Speaker ls, 
						@Qualifier("s1") Speaker rs) {
		this.leftspeaker = ls;
		this.rightspeaker = rs;
	}
	
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV전원이 켜집니다.");
	}

	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV전원이 꺼집니다.");		
	}

	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("TV의 볼륨을 높입니다.");		
	}

	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("TV의 볼륨을 낮춥니다.");			
	}

	public void printSpeakerBrand() {
		System.out.println("LGTV의 왼쪽 스피커의 브랜드명은 " + 
				leftspeaker.getSpeakerBrand()+ 
				", 오른쪽 스피커의 브랜드명은 " +
				rightspeaker.getSpeakerBrand()+
				"입니다.");	
	}
}
