package abstractShape;

public class Circle extends Shape {

	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// Access methods
	public double getRadius(){
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	// Logic methods
	@Override
	public Double area() {
		double calc = Math.PI * Math.pow(radius, 2);
		return calc;
	}
}
