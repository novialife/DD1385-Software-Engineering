package labb3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

class RPSSkel extends JFrame {
    Gameboard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;

    RPSSkel () {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	closebutton = new JButton("Close");
	
	myboard = new Gameboard("Abdullah Abdullah Abdullah"); // Must be changed
	computersboard = new Gameboard("Computer");
	
	JPanel boards = new JPanel();
	boards.setLayout(new GridLayout(1,2));
	boards.add(myboard);
	boards.add(computersboard);
	add(boards, BorderLayout.CENTER);
	add(closebutton, BorderLayout.SOUTH);
	
	setSize(350, 650);
	setVisible(true);
    }

    public static void main (String[] u) {
	new RPSSkel();
    }
    
    // Lägg till så att RPS ändras till rock paper eller scissor, uppermess
    // Lägg till så att win/lose/draw ändras till win lose draw, lowermess
    // fixa counter
    // fixa spellogik
    // fixa close knapp mekanism
    // ändra bilderna till rock, paper, scissor
    // Specifika krav
    
}
