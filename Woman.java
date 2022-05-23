package Human;

class Woman extends Human {
	
	private String name;
	
	private String pnr;
	
	
	
	Woman(String name, String pnr){
		
		this.name = name;
		this.pnr = pnr;
		
	}
	
	
	@Override
	public String toString() {
		
		return "Jag är kvinna och heter " + this.name;
	}
}