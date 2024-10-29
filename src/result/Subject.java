package result;

public class Subject {

	private int numberOfSubject;
	private String[] subjectName;
	
	public Subject(int numberOfSubject, String[] subjectName) {
		
		this.numberOfSubject = numberOfSubject;
		this.subjectName = subjectName;

	}

	public int getNumberOfSubject() {
		return numberOfSubject;
	}

	public void setNumberOfSubject(int numberOfSubject) {
		this.numberOfSubject = numberOfSubject;
	}

	public String[] getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String[] subjectName) {
		this.subjectName = subjectName;
	}
	
}
