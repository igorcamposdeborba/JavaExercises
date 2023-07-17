package entities;

public class Cd extends MediaItem {
	private int duration;
	
	public Cd (String title, int releaseYear, int duration){
		super(title, releaseYear);
		
		this.duration = duration;
	}
	
	// Access methods
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Title: " + super.getTitle() + ", duration: " + this.duration ;
	}
}
