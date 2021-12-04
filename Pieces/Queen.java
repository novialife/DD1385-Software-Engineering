package Pieces;

import javax.swing.ImageIcon;

import Board.Square;

public class Queen extends Piece {
	
	public Queen(String color, int i, int j) {
		super(color, i, j);
		if (color.equals("WHITE")){
			this.image = new ImageIcon("src/Images/whitequeen.png");
		}else {
			this.image = new ImageIcon("src/Images/blackqueen.png");
		}
	}
	
	@Override 
	public Square[][] move(int i, int j, Square[][] board) {
		// Queen combines bishop and rook moves
		if ((i+j == this.i + this.j) && !this.color.equals(board[i][j].piece.color)) {
			this.i = i;
			this.j = j;
			board[i][j].piece = this;
		}else if ((((i == this.i) || (j == this.j)) && (board[i][j].piece == null ||!this.color.equals(board[i][j].piece.color)))) {
			this.i = i;
			this.j = j;
			board[i][j].piece = this;
		}
		return board;
	}
	
	public boolean validateMove(int toI, int toJ, Square[][] board) {
		if ((i+j == this.i + this.j) && !this.color.equals(board[i][j].piece.color) || ) {
		
	}
}
