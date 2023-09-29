package chess.src.Pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	

	public boolean RookQueenCheck(Square[][] board, String opposite) {
		boolean lowerVertical = false;
		boolean upperVertical = false;
		boolean leftHorizontal = false;
		boolean rightHorizontal = false;

		for (int i=this.i; i<8; i++) {
			if (board[i][this.j].piece instanceof Pawn || board[i][this.j].piece instanceof Bishop || board[i][this.j].piece instanceof Knight) {
				break;
			}else if ((board[i][this.j].piece instanceof Queen || board[i][this.j].piece instanceof Rook) && board[i][this.j].piece.color.equals(opposite)) {
				lowerVertical = true;
			}
		}
		
		for (int i=this.i; i>=0; i--) {
			if (board[i][this.j].piece instanceof Pawn || board[i][this.j].piece instanceof Bishop || board[i][this.j].piece instanceof Knight) {
				break;
			}else if ((board[i][this.j].piece instanceof Queen || board[i][this.j].piece instanceof Rook) && board[i][this.j].piece.color.equals(opposite)) {
				upperVertical = true;
			}
		}
		
		for (int j=this.j; j<8; j++) {
			if (board[this.i][j].piece instanceof Pawn || board[this.i][j].piece instanceof Bishop || board[i][j].piece instanceof Knight) {
				break;
			}else if ((board[this.i][j].piece instanceof Queen || board[this.i][j].piece instanceof Rook) && board[i][j].piece.color.equals(opposite)) {
				lowerVertical = true;
			}
		}
		
		for (int j=this.j; j>=0; j--) {
			if (board[this.i][j].piece instanceof Pawn || board[this.i][j].piece instanceof Bishop || board[this.i][j].piece instanceof Knight) {
				break;
			}else if ((board[this.i][j].piece instanceof Queen || board[this.i][j].piece instanceof Rook) && board[this.i][j].piece.color.equals(opposite)) {
				upperVertical = true;
			}
		}
		if (lowerVertical || upperVertical || leftHorizontal || rightHorizontal) {
			return true;
		}
		
		return false;
	}
	
	public boolean pawnCheck(Square[][] board, String opposite) {
		// Pawn check
		if (this.color.equals("WHITE")){
			if (((board[this.i+1][this.j+1].piece instanceof Pawn) && (board[this.i+1][this.j+1].piece.color.equals("BLACK"))) || ((board[this.i+1][this.j-1].piece instanceof Pawn) && (board[this.i+1][this.j-1].piece.color.equals("BLACK")))) {
				return true;
			}
		} else if (this.color.equals("BLACK")) {
			if (((board[this.i-1][this.j+1].piece instanceof Pawn) && (board[this.i-1][this.j+1].piece.color.equals("WHITE"))) || ((board[this.i-1][this.j-1].piece instanceof Pawn) && (board[this.i-1][this.j-1].piece.color.equals("WHITE")))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean knightCheck(Square[][] board, String opposite) {
		
		Integer[] ivec = {2, 2, 1, 1, -2, -2, -1, -1};
		Integer[] jvec = {1, -1, +2, -2, +1, -1, +2, -2};

		for (int diffI=0, diffJ=0; diffI < ivec.length && diffJ < jvec.length; diffI++, diffJ++) {
			try {
				if (board[this.i + ivec[diffI]][this.j + jvec[diffJ]].piece instanceof Knight && board[this.i + ivec[diffI]][this.j + jvec[diffJ]].piece.color.equals(opposite)) {
					return true;
				}
			}catch (Exception e) {
				continue;
			}
		}
		return false;
	}
	
	public boolean BishopQueenCheck(Square[][] board, String opposite) {
		boolean upperLeft = false;
		boolean upperRight = false;
		boolean lowerLeft = false;
		boolean lowerRight = false;
		
		// upper left diagonal
		for (int i=this.i+1, j=this.j-1; i<8 && j>=0; i++, j--) {
			if (board[i][j].piece instanceof Pawn || board[i][j].piece instanceof Rook || board[i][j].piece instanceof Knight) {
				break;
			}else if ((board[i][j].piece instanceof Queen || board[i][j].piece instanceof Bishop) && board[i][j].piece.color.equals(opposite)) {
				upperLeft = true;
			} else if (board[i][j].piece != null && board[i][j].piece.color.equals(this.color)) {
				break;
			}
		}
		
		for (int i=this.i+1, j=this.j+1; i<8 && j<8; i++, j++) {
			if (board[i][j].piece instanceof Pawn || board[i][j].piece instanceof Rook || board[i][j].piece instanceof Knight) {
				break;
			}else if ((board[i][j].piece instanceof Queen || board[i][j].piece instanceof Bishop) && board[i][j].piece.color.equals(opposite)) {
				upperRight = true;
			} else if (board[i][j].piece != null && board[i][j].piece.color.equals(this.color)) {
				break;
			}
		}
		
		for (int i=this.i-1, j=this.j-1; i>=0 && j>=0; i--, j--) {
			if (board[i][j].piece instanceof Pawn || board[i][j].piece instanceof Rook || board[i][j].piece instanceof Knight) {
				break;
			}else if ((board[i][j].piece instanceof Queen || board[i][j].piece instanceof Bishop) && board[i][j].piece.color.equals(opposite)) {
				lowerLeft = true;
			} else if (board[i][j].piece != null && board[i][j].piece.color.equals(this.color)) {
				break;
			}
		}
		
		for (int i=this.i-1, j=this.j+1; i>=0 && j<8; i--, j++) {
			if (board[i][j].piece instanceof Pawn || board[i][j].piece instanceof Rook || board[i][j].piece instanceof Knight) {
				break;
			}else if ((board[i][j].piece instanceof Queen || board[i][j].piece instanceof Bishop) && board[i][j].piece.color.equals(opposite)) {
				lowerRight = true;
			} else if (board[i][j].piece != null && board[i][j].piece.color.equals(this.color)) {
				break;
			}
		}
		if (lowerLeft || upperLeft || lowerRight || upperRight) {
			return true;
		}
		
		return false;
	}
	
	public boolean isChecked(Square[][] board) {
		String opposite;
		// int tempI = this.i;
		// int tempJ = this.j;
		
		// if (pair != null){
		// 	this.i = pair[0];
		// 	this.j = pair[1];
		// }
		if (this.color.equals("WHITE")){
			opposite = "BLACK";
		}else {
			opposite = "WHITE";
		}

		if (this.pawnCheck(board, opposite) || this.RookQueenCheck(board, opposite) || this.knightCheck(board, opposite) || this.BishopQueenCheck(board, opposite)) {
			// this.i = tempI;
			// this.j = tempJ;
			return true;
		}
		// this.i = tempI;
		// this.j = tempJ;
		return false;
	}
	
	public List<List<Integer>> getAvailableMoves(Square[][] board){
		
		List<List<Integer>> availableMoves = new ArrayList<>();
		
		Integer[] ivec = {0,0,1,1,-1,-1,1,-1};
		Integer[] jvec = {1,-1,1,-1,1,-1,0,0};

		for (int diffI=0, diffJ=0; diffI < ivec.length && diffJ < jvec.length; diffI++, diffJ++) {
			try {
				if (board[this.i + ivec[diffI]][this.j + jvec[diffJ]].piece == null || board[this.i + ivec[diffI]][this.j + jvec[diffJ]].piece.color.equals(opposite)) {
					availableMoves.add(Arrays.asList(this.i + ivec[diffI],this.j + jvec[diffJ]));
				}
			}catch (Exception e) {
				continue;
			}
		}
		int originalI = this.i;
		int originalJ = this.j;

		List<List<Integer>> illegal = new ArrayList<>();
		for (List<Integer> move : availableMoves) {
			Square[][] tempBoard = new Square[8][8];
			for (int i=0; i<8; i++) {
				for (int j=0; j<8; j++) {
					tempBoard[i][j] = board[i][j];
				}
			}
			tempBoard[move.get(0)][move.get(1)].piece = this;
			this.i = move.get(0);
			this.j = move.get(1);
			if (this.isChecked(tempBoard)) {
				illegal.add(move);
			}
			tempBoard[move.get(0)][move.get(1)].piece = null;
			tempBoard[originalI][originalJ].piece = this;
			this.i = originalI;
			this.j = originalJ;
		}
		for (List<Integer> move : illegal) {
			availableMoves.remove(move);
		}
		return availableMoves;
	}

	public void printBoard(Square[][] board) {
		for (int i=7; i>=0; i--) {
			for (int j=0; j<8; j++) {
				try {
					System.out.print(board[i][j].piece.getClass().getSimpleName());
				}catch (Exception e){
					System.out.print("null");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
