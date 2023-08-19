package di.tvspeaker02;

public class SamsungTv implements Tv{
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
	@Override
	public void turnOn() {
		System.out.println("TV전원이 켜졌습니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV전원이 꺼졌습니다.");
		
	}
	
	@Override
	public void volumeUp() {
		speaker.
		
	}

	@Override
	public void volumeDown() {
		System.out.println("볼륨을 내립니다");
		
	}
	
	@Override
	public void printSpeakerBrand() {
		System.out.println("SamsungTV의 왼쪽 스피커의 브랜드명은 Samsung, 오른쪽 스피커의 브랜드명은 BO입니다.");
	}
}
