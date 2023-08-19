package di.tvspeaker02;

public class LgTv implements Tv{
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
	public void tvTurnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tvTurnOff() {
		// TODO Auto-generated method stub
		
}
	@Override
	public void tvVolumeUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void tvVolumeDown() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void printSpeakerBrand() {
		// TODO Auto-generated method stub
		
	}
