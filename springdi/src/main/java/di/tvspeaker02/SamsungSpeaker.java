package di.tvspeaker02;

public class SamsungSpeaker implements Speaker{


	@Override
	public void volumeUp() {
		System.out.println("볼륨을 올립니다");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeDown() {
		System.out.println("볼륨을 내립니다");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSpeakerBrand() {
		// TODO Auto-generated method stub
		System.out.println("Samsung");
	}

}
