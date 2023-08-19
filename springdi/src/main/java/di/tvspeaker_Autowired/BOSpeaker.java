package di.tvspeaker_Autowired;

public class BOSpeaker implements Speaker{

	@Override
	public void volumeup() {
		System.out.println("볼륨을 1단계 높입니다.");
		
	}

	@Override
	public void volumedown() {
		System.out.println("볼륨을 1단계 낮춥니다.");
		
	}

	@Override
	public String getBrand() {
		return "BO";
	}

}
