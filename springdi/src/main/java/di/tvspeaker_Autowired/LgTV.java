package di.tvspeaker_Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTV implements TV{
	
	private Speaker lgtvLeftSpeaker;
	private Speaker lgtvRightSpeaker;
	
	//생성자1
	public LgTV() {
		
	}

	//생성자2
	@Autowired
	public LgTV(Speaker lgtvLeftSpeaker, Speaker lgtvRightSpeaker) {
		this.lgtvLeftSpeaker = lgtvLeftSpeaker;
		this.lgtvRightSpeaker = lgtvRightSpeaker;
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
		lgtvLeftSpeaker.volumeup();
		lgtvRightSpeaker.volumeup();
		
	}
	@Override
	public void volumedown() {
		lgtvLeftSpeaker.volumedown();
		lgtvRightSpeaker.volumedown();
		
	}
	@Override
	public void printSpeakerBrand() {
		System.out.println("LgTV의 왼쪽 스피커 브랜드는 : " +
				lgtvLeftSpeaker.getBrand() +
							", 오른쪽 스피커 브랜드는 : " +
							lgtvRightSpeaker.getBrand() +
							"입니다."
				);
		
	}
	
}
