package labb3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",4713);
		    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    PrintWriter ut = new PrintWriter(socket.getOutputStream());
		    ut.println("Abdullah Abdullah Abdullah");
		    ut.flush();
		    System.out.println(in.readLine());
		       
	        // Our code begins here
	        Random random = new Random();
	        Boolean status = true;
	        String winner = "";
	   	    String[] options = {"STEN","SAX","PASE"};
	   
	        while (status) {
	    	    String choice = options[random.nextInt(3)];
	    	    System.out.println("Our choice is: " + choice);
	    	    ut.println(choice);
	    	    ut.flush();
	    	    String comp = in.readLine();
	    	    System.out.println("Computer's choice is: " + comp);
	    	    
	    	    
	    	    if (comp == "STEN") {
	    	    	System.out.println("True");
	    	    }
	    	    
	    	    if (choice == "STEN" && comp == "SAX") {
	    	    	winner = "User wins!";
		    	    status = false;
	    	    }
	    	    else if (choice == "SAX" && comp == "PASE") {
	    	    	winner = "User wins!";
		    	    status = false;
	    	    }
	    	    else if (choice == "PASE" && comp == "STEN") {
	    	    	winner = "User wins!";
		    	    status = false;
	    	    }
	    	    else if (choice == comp) {
	    	    	continue;
	    	    }
	    	    else {
	    	    	winner = "Server wins!";
		    	    status = false;
	    	    }
	       }
	       System.out.print(winner);
	       ut.close();
	       in.close();
		   }
		    catch(Exception e) {
			    System.err.println(e);
		 	}
	}

}