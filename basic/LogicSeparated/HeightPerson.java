package vectors;

public class HeightPerson {
	private String name;
	private int age;
	private double height;
	
	public HeightPerson(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Double getHeight() {
		return height;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
