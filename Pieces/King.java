package Pieces;

import javax.swing.ImageIcon;

import Board.Square;

public class King extends Piece {
	
	public King(String color, int i, int j) {
		super(color, i, j);
		if (color.equals("WHITE")){
			this.image = new ImageIcon("src/Images/whiteking.png");
		}else {
			this.image = new ImageIcon("src/Images/blackking.png");
		}
	}
	
	@Override 
	public Square[][] move(int i, int j, Square[][] board) {
		// Check for king moves
		// Check so new square isn't your own piece
		if (((this.j == j + 1 || this.j == j - 1 || this.j == j) && (this.i == i + 1 || this.i == i - 1 || this.i == i)) && (board[i][j].piece == null ||!this.color.equals(board[i][j].piece.color))) {
			this.i = i;
			this.j = j;
			board[i][j].piece = this;
		}
		return board;
	}
}
