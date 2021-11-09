package labb3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


class RPSSkel extends JFrame implements ActionListener {
    Gameboard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;
    String name;

    RPSSkel () {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	closebutton = new JButton("Close");
	
	name = "Mervan and Sam";
	myboard = new Gameboard(name, this); // Must be changed
	computersboard = new Gameboard("Computer");
	
	JPanel boards = new JPanel();
	boards.setLayout(new GridLayout(1,2));
	boards.add(myboard);
	boards.add(computersboard);
	add(boards, BorderLayout.CENTER);
	
	ActionListener close = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			out.println("");
		    out.flush();
		    System.exit(0);
		}
	};
	
	this.closebutton.addActionListener(close);
	add(closebutton, BorderLayout.SOUTH);
	
	setSize(350, 650);
	initializeServer();
	setVisible(true);
    }

    public void initializeServer() {
	    try {
	    	this.socket = new Socket("localhost",4713);
		    this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    this.out = new PrintWriter(socket.getOutputStream());
		    this.out.println(this.name);
		    this.out.flush();
		    this.in.readLine();
		    
	    } catch(Exception e) {
		    System.err.println(e);
		    System.exit(0);
	    }
    }
    
    public void updateState(Gameboard board, String choice, String status) {
		board.setUpper(choice);
		board.setLower(status);
		board.markPlayed(choice);
		
		if (status != "draw" && status != "loss") {
			board.wins();
			}
		}
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	
    	counter++;
    	if (counter == 1) {
    		myboard.setLower("ETT");
    		computersboard.setLower("ETT");
    		myboard.resetColor();
    		computersboard.resetColor();
    		return;
    	}else if (counter == 2){
    		myboard.setLower("TVÅ");
    		computersboard.setLower("TVÅ");
    	}else {

	    	JButton button = (JButton) e.getSource();
	    	
	    	String choice = ((ImageIcon)button.getIcon()).getDescription();
	    	System.out.println(choice);
	    	
	    	if (choice == "labb3/rock.gif") {
	    		choice = "STEN";
	    	}else if (choice == "labb3/paper.gif") {
	    		choice = "PASE";
	    	}else {
	    		choice = "SAX";
	    	}
	    	
	    	try {
		    	this.out.println(choice);
			    this.out.flush();
			    String comp = this.in.readLine();
		    	
		    	if (choice.equals(comp)) {
		    		updateState(myboard, choice, "draw");
		    		updateState(computersboard, comp, "draw");
		    		
		    	}else if ((choice.equals("STEN") && comp.equals("SAX")) || (choice.equals("SAX") && comp.equals("PASE")) || (choice.equals("PASE") && comp.equals("STEN"))) {
		    		updateState(myboard, choice, "win");
		    		updateState(computersboard, comp, "loss");
	    	    } else {
	    	    	updateState(myboard, choice, "loss");
		    		updateState(computersboard, comp, "win");
	    	    }
		    	counter = 0;
	    	} catch(Exception e1) {
			    System.err.println(e1);
			    this.out.println("");
			    this.out.flush();
			    System.exit(0);
		    }
    	}
	}
    

    public static void main (String[] u) {
	new RPSSkel();
    }
}
