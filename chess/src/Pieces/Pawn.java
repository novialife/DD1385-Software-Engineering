package Pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

import Board.Square;

public class Pawn extends Piece {
	
	private boolean hasMoved = false;

	
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
	
	public boolean validateMove(Square[][] board, int toI, int toJ) {
		
		if (this.getAvailableMoves(board).contains(Arrays.asList(toI, toJ))) {
			this.hasMoved = true;
			return true;
		}
		
		return false;
	}
	
	public List<List<Integer>> getAvailableMoves(Square[][] board){
		List<List<Integer>> availableMoves = new ArrayList<>();
		
		int direction;
		List<Integer> ivec;
		List<Integer> jvec;
		
		if (this.color.equals("BLACK")) {
			direction = -1;
		}else {
			direction = 1;
		}
		
		if (this.hasMoved) {
			ivec = Arrays.asList(direction, direction, direction);
			jvec = Arrays.asList(0,1,-1);
		}else {
			ivec = Arrays.asList(direction, direction, direction, 2*direction);
			jvec = Arrays.asList(0,1,-1,0);
		}
		
		for (int diffI=0, diffJ=0; diffI < ivec.size() && diffJ < jvec.size(); diffI++, diffJ++) {
			try {
				if ((board[this.i + ivec.get(diffI)][this.j + jvec.get(diffJ)].piece == null && (this.j + jvec.get(diffJ) == this.j) || (board[this.i + ivec.get(diffI)][this.j + jvec.get(diffJ)].piece.color.equals(opposite) && (this.j + jvec.get(diffJ) != this.j)))) {
					availableMoves.add(Arrays.asList(this.i + ivec.get(diffI),this.j + jvec.get(diffJ)));
				}
			}catch (Exception e) {
				continue;
			}
		}
		
		return availableMoves;


	}
}
