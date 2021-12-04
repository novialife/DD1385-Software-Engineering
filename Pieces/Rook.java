package Pieces;

import javax.swing.ImageIcon;

import Board.Square;

public class Rook extends Piece {
	
	public Rook(String color, int i, int j) {
		super(color, i, j);
		if (color.equals("WHITE")){
			this.image = new ImageIcon("src/Images/whiterook.png");
		}else {
			this.image = new ImageIcon("src/Images/blackrook.png");
		}
	}
	
	@Override 
	public Square[][] move(int i, int j, Square[][] board) {
		// Check if same row or same col
		// Check so new square isn't your own piece
		if (((i == this.i) || (j == this.j)) && (board[i][j].piece == null ||!this.color.equals(board[i][j].piece.color))) {
			this.i = i;
			this.j = j;
			board[i][j].piece = this;
		}
		return board;
	}
	
	public boolean validateMove(int toI, int toJ, Square[][] board) {
		
	}
}
