package di.tvspeaker_Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV implements TV{
	private Speaker samsungtvLeftSpeaker;
	private Speaker samsungtvRightSpeaker;
	
	//생성자1
	public SamsungTV() {
		
	}

	//생성자2
	@Autowired
	public SamsungTV(Speaker samsungtvLeftSpeaker, Speaker samsungtvRightSpeaker) {
		this.samsungtvLeftSpeaker = samsungtvLeftSpeaker;
		this.samsungtvRightSpeaker = samsungtvRightSpeaker;
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
		samsungtvLeftSpeaker.volumeup();
		samsungtvRightSpeaker.volumeup();
		
	}
	@Override
	public void volumedown() {
		samsungtvLeftSpeaker.volumedown();
		samsungtvRightSpeaker.volumedown();
		
	}
	@Override
	public void printSpeakerBrand() {
		System.out.println("SamsungTV의 왼쪽 스피커 브랜드는 : " +
				samsungtvLeftSpeaker.getBrand() +
							", 오른쪽 스피커 브랜드는 : " +
							samsungtvRightSpeaker.getBrand() +
							"입니다."
				);
		
	}
	
}
