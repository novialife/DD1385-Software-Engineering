
public class Person {
	public String name;
	public int age;
	static String[] nameArray = {"Mervan" , "Alperen", "Sam", "Jakob", "Oscar", 
			  "Pooya", "Ozair","Marwin", "Kristian", "Moe"};
	
	
	public Person() {
		int max = 100;
		int min = 15;
		int range = (max - min) + 1;
		
		age = (int)(min + (Math.random()*range));
		
		
		int maxname = nameArray.length;
		name = nameArray[(int)((Math.random()*maxname)-1)];
		
	}

	public Person(String nameIn, int ageIn) {
		name = nameIn;
		age = ageIn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String toString(){
		String data;
		data = "namn: " + getName() + "," + " ålder: " + String.valueOf(getAge());
		return data;
	}
}
