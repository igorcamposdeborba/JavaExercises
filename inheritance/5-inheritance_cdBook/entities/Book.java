package entities;

public class Book extends MediaItem{
	
	private int pageCount;
	
	public Book(String title, int releaseYear, int pageCount) {
		super(title, releaseYear);
		
		this.pageCount = pageCount;
	}
	
	// Access methods
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + super.getTitle() + ", Paginas: " + this.pageCount;
	}
}
