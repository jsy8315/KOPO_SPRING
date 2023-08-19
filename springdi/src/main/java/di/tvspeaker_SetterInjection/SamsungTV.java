package di.tvspeaker_SetterInjection;

public class SamsungTV implements TV{
	private Speaker LeftSpeaker;
	private Speaker RightSpeaker;
	
	//생성자1
	public SamsungTV() {
		
	}

	public Speaker getLeftSpeaker() {
		return LeftSpeaker;
	}

	public void setLeftSpeaker(Speaker leftSpeaker) {
		LeftSpeaker = leftSpeaker;
	}

	public Speaker getRightSpeaker() {
		return RightSpeaker;
	}

	public void setRightSpeaker(Speaker rightSpeaker) {
		RightSpeaker = rightSpeaker;
	}

	//생성자2
	public SamsungTV(Speaker LeftSpeaker, Speaker RightSpeaker) {
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
		System.out.println("SamsungTV의 왼쪽 스피커 브랜드는 : " +
							LeftSpeaker.getBrand() +
							", 오른쪽 스피커 브랜드는 : " +
							RightSpeaker.getBrand() +
							"입니다."
				);
		
	}
	
}
