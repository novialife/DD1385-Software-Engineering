package Pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public void showMoves(Square[][] board, List<List<Integer>> availableMoves) {
		
	}
	
	public List<List<Integer>> getAvailableMoves(Square[][] board){
		List<List<Integer>> availableMoves = new ArrayList<>();
		
		// upper left diagonal
		for (int i=this.i+1, j=this.j-1; i<8 && j>=0; i++, j--) {
			if (board[i][j].piece == null) {
				availableMoves.add(Arrays.asList(i,j));
			}else if (board[i][j].piece.color.equals(opposite)){
				availableMoves.add(Arrays.asList(i,j));
				break;
			}else {
				break;
			}
		}
		
		// upper right
		for (int i=this.i+1, j=this.j+1; i<8 && j<8; i++, j++) {
			if (board[i][j].piece == null) {
				availableMoves.add(Arrays.asList(i,j));
			}else if (board[i][j].piece.color.equals(opposite)){
				availableMoves.add(Arrays.asList(i,j));
				break;
			}else {
				break;
			}
		}
		
		// lower left
		for (int i=this.i-1, j=this.j-1; i>=0 && j>=0; i--, j--) {
			if (board[i][j].piece == null) {
				availableMoves.add(Arrays.asList(i,j));
			}else if (board[i][j].piece.color.equals(opposite)){
				availableMoves.add(Arrays.asList(i,j));
				break;
			}else {
				break;
			}
		}
		
		// lower right
		for (int i=this.i-1, j=this.j+1; i>=0 && j<8; i--, j++) {
			if (board[i][j].piece == null) {
				availableMoves.add(Arrays.asList(i,j));
			}else if (board[i][j].piece.color.equals(opposite)){
				availableMoves.add(Arrays.asList(i,j));
				break;
			}else {
				break;
			}
		}
		return availableMoves;
	}
}
