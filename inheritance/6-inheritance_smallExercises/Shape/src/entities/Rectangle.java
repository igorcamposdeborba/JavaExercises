package entities;

public class Rectangle extends Shape {

	public Rectangle(int x, int y) {
		super(x, y);
	}
	
	@Override
	public double getArea() {
		double area = this.getX() * this.getY();
		return area;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getArea());
	}
}
