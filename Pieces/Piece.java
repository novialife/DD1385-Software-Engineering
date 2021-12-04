package Pieces;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Board.Square;

public class Piece {
	public String color;
	public int i,j;
	public Icon image;
//	public String path;
	
	public Piece(String color, int i, int j) {
//		if (color.equals("WHITE")){
//			this.image = new ImageIcon(path);
//		}else {
//			this.image = new ImageIcon(path);
//		}

		this.color = color;
		this.i = i;
		this.j = j;
	}
	
	public Square[][] move(int i, int j, Square[][] board) {
		// Override in subpiece
		return null;
	}
	
	public boolean validateMove(Square[][] board, int toI, int toJ) {
		return false;
	}
}
