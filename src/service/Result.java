package service;

public class Result {
	
	private int studentMarks;
	private String failedSubject;
	private int totalMarks;
	
	public int getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}
	public String getFailedSubject() {
		return failedSubject;
	}
	public void setFailedSubject(String failedSubject) {
		this.failedSubject = failedSubject;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return  studentMarks + " , " + failedSubject + " , " + totalMarks ;
	}
	
	
	
}
