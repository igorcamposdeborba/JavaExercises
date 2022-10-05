package vectors;

public abstract class ApprovatedAbstract {
	public String name;
	public double firstSemesterGrade;
	public double secondSemesterGrade;
	protected final double CUTLINE = 6.0; 
	
	public ApprovatedAbstract() {
	}
	
	public abstract String average();
	
	public abstract String getName();
}
