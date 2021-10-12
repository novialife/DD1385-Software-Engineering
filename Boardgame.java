package labb2;

public interface Boardgame {
	   public boolean move(int i, int j); //ger true om draget gick bra, annars false 
	   public String getStatus(int i, int j); // returnera innehåll på ruta (i,j)     
	   public String getMessage(); // returnera OK (eller liknande) eller felmeddelande avseende senaste drag
	}
