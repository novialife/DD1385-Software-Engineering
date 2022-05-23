package Pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public List<List<Integer>> getAvailableMoves(Square[][] board){
		List<List<Integer>> availableMoves = new ArrayList<>();
		
		for (int i=this.i+1; i<8; i++) {
			if (board[i][this.j].piece == null) {
				availableMoves.add(Arrays.asList(i ,this.j));
			}else if (board[i][j].piece.color.equals(opposite)){
				availableMoves.add(Arrays.asList(i,j));
				break;
			}else {
				break;
			}
		}
		
		for (int i=this.i-1; i>=0; i--) {
			if (board[i][this.j].piece == null) {
				availableMoves.add(Arrays.asList(i ,this.j));
			}else if (board[i][j].piece.color.equals(opposite)){
				availableMoves.add(Arrays.asList(i,j));
				break;
			}else {
				break;
			}
		}
		
		for (int j=this.j+1; j<8; j++) {
			if (board[this.i][j].piece == null) {
				availableMoves.add(Arrays.asList(this.i ,j));
			}else if (board[i][j].piece.color.equals(opposite)){
				availableMoves.add(Arrays.asList(i,j));
				break;
			}else {
				break;
			}
		}
		
		for (int j=this.j-1; j>=0; j--) {
			if (board[this.i][j].piece == null) {
				availableMoves.add(Arrays.asList(this.i , j));
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
