package model;

public class Student {
	
		private String name;

		public String getName() {
			return name.toUpperCase();
		}

		public void setName(String name) {
			this.name = name.toUpperCase();
		}

		@Override
		public String toString() {
			return  name ;
		}
		
		
		
}