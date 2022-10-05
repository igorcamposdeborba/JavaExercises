package vectors;

public class Approvated extends ApprovatedAbstract {

	public Approvated (String name, double firstSemesterGrade, double secondSemesterGrade) {
		super();
		this.name = name;
		this.firstSemesterGrade = firstSemesterGrade;
		this.secondSemesterGrade = secondSemesterGrade;
	}
	
	@Override
	public String average() {
		if ((firstSemesterGrade + secondSemesterGrade) / 2 >= CUTLINE) {
			return name;
		}
		return null;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
