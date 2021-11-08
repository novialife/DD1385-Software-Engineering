package labb2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ViewControl extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Boardgame game;
    private int size;
    private Square[][] board;        
    private JLabel mess = new JLabel();  

    
    ViewControl (Boardgame gm, int n){  
    	super("Fifteen made by Mervan Kaya and Samhar Alzghaier");
    	
		setSize(600,600); //width x height
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(n,n));
		
		
		this.game = gm;
		this.size = n;
		this.board = new Square[n][n];
		
		
		for(int i = 0; i < size; i++){
	        for(int j = 0; j < size; j++){
				Square button = new Square(game.getStatus(i, j), i, j);
				board[i][j] = button;
				button.addActionListener(this);
				add(button);
			}
		}
		
		setVisible(true);

	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		Square clickedbutton = (Square) e.getSource();
		game.move(clickedbutton.i, clickedbutton.j);
		System.out.println(game.getMessage());
		update();
					
	}
	
	private void update() {
		for(int i = 0; i < size; i++){
	        for(int j = 0; j < size; j++){
	        	String newtext = game.getStatus(i, j);
	        	board[i][j].setText(newtext);
	        }
		}
	}
}
