package chess.src.Pieces;

import java.util.ArrayList;
import java.util.List;

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
	
	public boolean validateMove(Square[][] board, int toI, int toJ) {
		Bishop temp_Bishop = new Bishop(this.color, this.i, this.j);
		Rook temp_Rook = new Rook(this.color, this.i, this.j);
		if (temp_Bishop.validateMove(board, toI, toJ) == true || temp_Rook.validateMove(board, toI, toJ) == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<List<Integer>> getAvailableMoves(Square[][] board){
		Bishop tempBishop = new Bishop(this.color, this.i, this.j);
		Rook tempRook = new Rook(this.color, this.i, this.j);
		
		List<List<Integer>> bishopMoves = tempBishop.getAvailableMoves(board);
		List<List<Integer>> rookMoves = tempRook.getAvailableMoves(board);

		List<List<Integer>> out = new ArrayList<List<Integer>>(bishopMoves);
		out.addAll(rookMoves);
		return out;
		
	}
	
}
