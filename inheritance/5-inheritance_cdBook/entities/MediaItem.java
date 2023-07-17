package entities;

public class MediaItem {
	
	private String title;
	private int releaseYear;
	
	public MediaItem(String title, int releaseYear) {
		this.title = title;
		this.releaseYear = releaseYear;
	}
	
	// Access methods
	public String getTitle() {
		return title;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

}
