package model.student;

public class Student {
	public final String name;
	public final double grade;
	public boolean goodBehavior = true;
	
	public Student(String name, double grade, boolean goodBehavior) {
		this.name = name;
		this.grade = grade;
		this.goodBehavior = goodBehavior;
	}
	
	// sobrecarga (mesma assinatura com parâmetros diferentes)
	public Student(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return name + " has grade " + grade;
	}
	
	// ! These methods below don`t were not created by me
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (goodBehavior ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp = Double.doubleToLongBits(grade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Student other = (Student) obj;
		if (goodBehavior != other.goodBehavior)
			return false;
		if (name == null) {
			if (other.name != null) {
					return false;
			}
		} else if (!name.equals(other.name))
			return false;
		
		if (Double.doubleToLongBits(grade) != Double.doubleToLongBits(other.grade))
			return false;
		
		return true;
	}
}
