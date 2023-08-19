package di.tvspeaker_JavaConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{
	
	private Speaker LeftSpeaker;
	private Speaker RightSpeaker;
	

	public LgTV() {
		
	}


	@Autowired
	public LgTV(@Qualifier("bo") Speaker LeftSpeaker, 
			@Qualifier("ss") Speaker RightSpeaker) {
		this.LeftSpeaker = LeftSpeaker;
		this.RightSpeaker = RightSpeaker;
	}
	@Override
	public void turnon() {
		System.out.println("전원을 켭니다.");
		
	}
	@Override
	public void turnoff() {
		System.out.println("전원을 끕니다.");
		
	}
	@Override
	public void volumeup() {
		LeftSpeaker.volumeup();
		RightSpeaker.volumeup();
		
	}
	@Override
	public void volumedown() {
		LeftSpeaker.volumedown();
		RightSpeaker.volumedown();
		
	}
	@Override
	public void printSpeakerBrand() {
		System.out.println("LgTV의 왼쪽 스피커 브랜드는 : " +
							LeftSpeaker.getBrand() +
							", 오른쪽 스피커 브랜드는 : " +
							RightSpeaker.getBrand() +
							"입니다."
				);
		
	}
	
}
