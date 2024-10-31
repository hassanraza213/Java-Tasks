package model;

public class Subject {
	
	private String name;
	private int creditHour;
	
	
	public String getName() {
		return name.toUpperCase();
	}
	public void setName(String name) {
		
		this.name = name;
	}
	public int getCreditHour() {
		return creditHour;
	}
	public void setCreditHour(int creditHour) {
		this.creditHour = creditHour;
	}

	
	@Override
	public String toString() {
		return   name + ", " +creditHour ;
	}
	
	
	

}
