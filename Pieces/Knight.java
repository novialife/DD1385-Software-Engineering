package Pieces;

import javax.swing.ImageIcon;

import Board.Square;

public class Knight extends Piece {
	
	public Knight(String color, int i, int j) {
		super(color, i, j);
		if (color.equals("WHITE")){
			this.image = new ImageIcon("src/Images/whiteknight.png");
		}else {
			this.image = new ImageIcon("src/Images/blackknight.png");
		}
	}
	
	@Override 
	public Square[][] move(int i, int j, Square[][] board) {
		// Check for knight moves.
		// Check so new square isn't your own piece
		
		
		this.i = i;
		this.j = j;
		board[i][j].piece = this;
		return board;
	}
	
	public boolean validateMove(int toI, int toJ, Square[][] board) {
		if (((j == this.j + 1 || j == this.j - 1) && (i == this.i - 2 || this.i == this.i + 2) || (i == this.i + 1 || i == this.i - 1) && (j == this.j - 2 || j == this.j + 2)) && (board[i][j].piece == null ||!this.color.equals(board[i][j].piece.color))) {
			return false;
		}else {
			return true;
		}
	}
}

