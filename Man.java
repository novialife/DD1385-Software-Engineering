package Human;

class Man extends Human {
	
	private String name;
	
	private String pnr;
	
	
	
	Man(String name, String pnr){
		
		this.name = name;
		this.pnr = pnr;
		
	}
	
	
	@Override
	public String toString() {
		
		return "Jag är man och heter " + this.name;
	}
}
