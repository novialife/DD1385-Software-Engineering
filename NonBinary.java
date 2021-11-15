package Human;

class NonBinary extends Human {
	
	private String name;
	
	private String pnr;
	
	
	
	NonBinary(String name, String pnr){
		
		this.name = name;
		this.pnr = pnr;
		
	}
	
	
	@Override
	public String toString() {
		
		return "Jag är icke-binär och heter " + this.name;
	}
}