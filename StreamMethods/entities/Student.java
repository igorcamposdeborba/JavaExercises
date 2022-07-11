package entities;

public class Student {
	private String name;
	private double grade;
	private boolean goodBehavior;
	
	public Student(String name, double grade, boolean goodBehavior) {
		this.name = name;
		this.grade = grade;
		this.goodBehavior = goodBehavior;
	}
	
	// sobrecarga com parâmetros diferentes. this chama o outro construtor
	public Student (String name, double grade) {
		this(name, grade, true);
	}
	
	public String getName() {
		return name;
	}
	public double getGrade() {
		return grade;
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
}
