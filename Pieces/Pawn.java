package Pieces;

import javax.swing.ImageIcon;

import Board.Square;

public class Pawn extends Piece {
	
	
	public Pawn(String color, int i, int j) {
		super(color, i, j);
		
		// Should maybe be in Piece? -------------------------
		if (color.equals("WHITE")){
			this.image = new ImageIcon("src/Images/whitepawn.png");
		}else {
			this.image = new ImageIcon("src/Images/blackpawn.png");
		}
		// ---------------------------------------------------
	}
	
	@Override 
	public Square[][] move(int i, int j, Square[][] board) {
		board[this.i][this.j].piece = null;
		this.i = i;
		this.j = j;
		board[i][j].piece = this;
		return board;
	}
	
	@Override
	public boolean validateMove(Square[][] board, int toI, int toJ) {
		// i is row, j is col
		// To be added is if pawn has already moved
		if (this.color.equals("BLACK")) {
			if (this.i > toI + 2 || this.i < toI || (this.i == toI && (this.j > toJ || this.j < toJ)) || (this.j > toJ + 1 || this.j < toJ - 1) || (this.j > toJ || this.j < toJ) && board[toI][toJ].piece == null) {
				return false;
			}else {
				return true;
			}
		}
		
		if (this.color.equals("WHITE")){
			if (this.i < toI-2 || this.i > toI || (this.i == toI && (this.j > toJ || this.j < toJ) || (this.j > toJ + 1 || this.j < toJ -1) || (this.j > toJ || this.j < toJ) && board[toI][toJ].piece == null)){
				return false;
			}else {
				return true;
			}
		}
		System.out.println("How did I end up here?");
		return true;
	}
}
