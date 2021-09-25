
public class Student extends Person {
	
	public int year;

	public Student() {
		
		name = getName();
		age = getAge();
		
		int studentBirth = 2020-age;
		
		int max = 2020;
		int min = studentBirth + 15;
		int range = (max-min) + 1;

		
		if (studentBirth > 2005) {
			System.out.println("Du är för ung för att plugga!");
		} else {
			year = (int) (min + (Math.random()*range));
		}
		
	}
	
	public Student(String nameIn, int ageIn, int startYear) {
				   super(nameIn, ageIn);
		
		year = startYear;
		
	}
	
	public int getYear() {
		return this.year;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", började på CINEK " + String.valueOf(getYear()) ;
	}
}
