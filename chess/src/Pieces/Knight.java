package Pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public List<List<Integer>> getAvailableMoves(Square[][] board){
		List<List<Integer>> availableMoves = new ArrayList<>();
		
		Integer[] ivec = {2, 2, 1, 1, -2, -2, -1, -1};
		Integer[] jvec = {1, -1, +2, -2, +1, -1, +2, -2};

		for (int diffI=0, diffJ=0; diffI < ivec.length && diffJ < jvec.length; diffI++, diffJ++) {
			try {
				if (board[this.i + ivec[diffI]][this.j + jvec[diffJ]].piece == null || board[this.i + ivec[diffI]][this.j + jvec[diffJ]].piece.color.equals(opposite)) {
					availableMoves.add(Arrays.asList(this.i + ivec[diffI],this.j + jvec[diffJ]));
				}
			}catch (Exception e) {
				continue;
			}
		}
		
		return availableMoves;
	}
}

