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
		
		size = n;
		
		board = new Square[size][size];
		makeBoard();
		
		setVisible(true);
		
    }
    
    private void makeBoard() {
		List<String> listofnum = new ArrayList<String>();
		String[] nums = {" 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10","11","12","13","14","15","  "};
		for (String num: nums) {
			listofnum.add(num);
		}
		
		Collections.shuffle(listofnum);
		
		for(int i = 0; i < 4; i++){
	        for(int j = 0; j < 4; j++){
	        	board[i][j] = new Square(listofnum.get(0));
	        	listofnum.remove(0);
	        }
	    }
		
		for (Square[] buttonrow: board){
			for (Square button: buttonrow) {
				button.addActionListener(this);
				add(button);
			}
		}
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		Square clickedbutton = (Square) e.getSource();
		Square emptybutton = null;
		for (Square[] buttonrow: board) {
			for (Square button: buttonrow) {
				if (button.getText() == "  ") {
					emptybutton = button;
				}
			}
		}
		
		emptybutton.setText(clickedbutton.getText());
		clickedbutton.setText("  ");
		
		
		
	}
}