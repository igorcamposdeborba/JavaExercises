package entities;

public class Shape {
	private int x;
	private int y;
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getArea() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Utilize o metodo da subclasse");
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
