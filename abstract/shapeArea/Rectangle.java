package abstractShape;

public class Rectangle extends Shape {

	private double width, height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// Access methods
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	// Logic method
	@Override
	public Double area() {
		double calc = width * height;
		return calc;
	}
}
