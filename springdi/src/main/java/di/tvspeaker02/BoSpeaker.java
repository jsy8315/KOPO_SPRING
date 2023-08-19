package di.tvspeaker02;

public class BoSpeaker implements Speaker{

	@Override
	public void speakerVolumeUp() {
		System.out.println("스피커 볼륨을 올립니다");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void speakerVolumeDown() {
		System.out.println("스피커 볼륨을 내립니다");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSpeakerBrand() {
		// TODO Auto-generated method stub
		System.out.println("BO");
	}

}
