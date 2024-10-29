package result;

public class Student {
	private int totalStudents;
	private String[] studentNames;
	
	public Student(int totalStudents, String[] studentNames) {
		this.totalStudents = totalStudents;
		this.studentNames = studentNames;
	}
	
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		
		this.totalStudents = totalStudents;
	}
	public String[] getStudentNames() {
		return studentNames;
	}
	public void setStudentNames(String[] studentNames) {
		this.studentNames = studentNames;
	}
}
