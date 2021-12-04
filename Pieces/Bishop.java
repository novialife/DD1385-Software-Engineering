package Pieces;

import javax.swing.ImageIcon;

import Board.Square;

public class Bishop extends Piece {
	
	public Bishop(String color, int i, int j) {
		super(color, i, j);
		if (color.equals("WHITE")){
			this.image = new ImageIcon("src/Images/whitebishop.png");
		}else {
			this.image = new ImageIcon("src/Images/blackbishop.png");
		}
	}
	
	@Override 
	public Square[][] move(int i, int j, Square[][] board) {
		// Check if same diag -> Row + Col is constant for all elements on same diagonal
		// Check so new square isn't your own piece
		if ((i+j == this.i + this.j) && (board[i][j].piece == null ||!this.color.equals(board[i][j].piece.color))) {
			this.i = i;
			this.j = j;
			board[i][j].piece = this;
		}
		return board;
	}
}
