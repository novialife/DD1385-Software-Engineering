package Human;

public abstract class Human {

	Human(){
}

	public static Human create(String name, String pnr) {
		
		int sistasiffran = Integer.parseInt(pnr.substring(pnr.length()-2),pnr.length()-1); 
		
		//Vi tar emot sista siffran på det här sätter
		
		
		
		if (sistasiffran % 2 != 0) {  //om udda 
			return new Man(name, pnr);
		}
		
		else if (sistasiffran == 0) { //om 0 
			return new NonBinary(name, pnr);
		}
		else if (sistasiffran % 2 == 0 && sistasiffran != 0){
			return new Woman(name, pnr);
			
		}
		
		return null;
	}
		
}
