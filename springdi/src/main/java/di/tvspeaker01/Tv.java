package di.tvspeaker01;

public interface Tv {
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void volumeUp();
	public abstract void volumeDown();
	
	void printSpeakerBrand();
	
}
