
public class del4 {

	public static void main(String[] args) {
		System.out.println("------------------Uppgift 4.5 ------------------------------------------");
		System.out.println();
		
		Student [] studentList = new Student[15];
		
		for (int i=0; i<15; i++) {
			studentList[i] = new Student();
			System.out.println(studentList[i]);
		}
		
		System.out.println();
		System.out.println("------------------Uppgift 4.6 ------------------------------------------");
		System.out.println();
		
		Person [] personList = new Person[10];
		
		for (int j=0; j<10; j++) {
			if (j<5) {
				personList[j] = new Person();
			} else {
				personList[j] = new Student();	
			}
			
		}
		
		for (Person p: personList) {
			System.out.println(p);
		}
	}
}
