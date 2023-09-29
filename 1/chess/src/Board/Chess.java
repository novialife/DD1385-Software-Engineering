package chess.src.Board;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Pieces.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Chess extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public Square[][] board = new Square[8][8];
	public Piece markedPiece;
	public int[] moveTo;
	public String currentTurn = "WHITE";
	public boolean kingIsChecked = false;
	
	
	public Chess() {
		super("Chess made by Mervan Kaya and Samhar Alzghaier");
		setSize(600,600); //width x height
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(8,8));
		// Initialize empty Board with pawns on rank 2 and 7
		String color = "";
		for (int i = 0; i <= 7; i++) {
			Square[] row = new Square[8];
			board[i] = row;
			for (int j = 0; j <=7; j++) {
				if ((i+j)%2 == 0) {
					color = "BLACK";
				}else {
					color = "WHITE";
					}
				if (i == 1) {
					board[i][j] = new Square(new Pawn("WHITE", i, j), color, i, j);
				}else if(i == 6) {
					board[i][j] = new Square(new Pawn("BLACK", i, j), color, i, j);
				}else {
					board[i][j] = new Square(null, color, i, j);
				}
			}
		}
		
		// Initialize the major pieces
		board[0][0] = new Square(new Rook("WHITE", 0, 0), "BLACK", 0, 0);
		board[7][0] = new Square(new Rook("BLACK", 7, 0), "WHITE", 7, 0);
		board[0][7] = new Square(new Rook("WHITE", 0, 7), "WHITE",0, 7);
		board[7][7] = new Square(new Rook("BLACK", 7, 7), "BLACK",7, 7);
		
		board[0][1] = new Square(new Knight("WHITE", 0, 1), "WHITE", 0, 1);
		board[7][1] = new Square(new Knight("BLACK", 7, 1), "BLACK", 7, 1);
		board[0][6] = new Square(new Knight("WHITE", 0, 6), "BLACK", 0, 6);
		board[7][6] = new Square(new Knight("BLACK", 7, 6), "WHITE",7, 6);
		
		board[0][2] = new Square(new Bishop("WHITE", 0, 2), "BLACK", 0, 2);
		board[7][2] = new Square(new Bishop("BLACK", 7, 2), "WHITE", 7, 2);
		board[0][5] = new Square(new Bishop("WHITE", 0, 5), "WHITE", 0, 5);
		board[7][5] = new Square(new Bishop("BLACK", 7, 5), "BLACK", 7, 5);
		
		board[0][3] = new Square(new Queen("WHITE", 0, 3), "WHITE", 0, 3);
		board[0][4] = new Square(new King("WHITE", 0, 4), "BLACK", 0, 4);
		board[7][3] = new Square(new Queen("BLACK", 7, 3), "BLACK", 7, 3);
		board[7][4] = new Square(new King("BLACK", 7, 4), "WHITE", 7, 4);
		
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j <= 7; j++) {
				Square square = board[i][j];
				square.addActionListener(this);
				add(square);
			}
		}
		setVisible(true);
		
	}

	public Piece promotion(int i, int j){
		// Promote a pawn to a Queen
		Piece promoteTo = null;
		
		while (promoteTo == null) {
			String newPiece = JOptionPane.showInputDialog("Which piece do you want to promote to?");
			if (newPiece.equals("King")) {
				JOptionPane.showMessageDialog(this, "Can't promote to a King!");
			}else if (newPiece.equals("Queen")){
				promoteTo = new Queen(this.currentTurn, i, j);
			}else if (newPiece.equals("Bishop")) {
				promoteTo = new Bishop(this.currentTurn, i, j);
			}else if (newPiece.equals("Rook")) {
				promoteTo = new Rook(this.currentTurn, i, j);
			}else if (newPiece.equals("Pawn")) {
				promoteTo = new Pawn(this.currentTurn, i, j);
			}else {
				JOptionPane.showMessageDialog(this, "Wrong Input!");
			}
		}
		return promoteTo;
	}
	
	public void clickNonEmpty(Square clickedSquare){
		// If we don't have a marked piece, we select this piece to be moved
		if (this.markedPiece == null) {
			this.markedPiece = clickedSquare.piece;
			clickedSquare.mark();
			this.showMoves(board, this.markedPiece.getAvailableMoves(board));
			return;
		}
		
		// If we click on the same square
		if (this.markedPiece == clickedSquare.piece) {
			this.showMoves(this.board, this.markedPiece.getAvailableMoves(board));
			this.markedPiece = null;
			clickedSquare.mark();
			return;
		}
		
		// If we have a marked piece and we click on a square containing a piece with the same color
		if (this.markedPiece.color.equals(clickedSquare.piece.color)) {
			JOptionPane.showMessageDialog(this, "Can't click on a piece with the same color!");
			return;
		}
		
		// If none of the above, then we clicked on a correct square when a piece is marked, perform the move.
		move(clickedSquare);
	}
	
	public void clickEmpty(Square clickedSquare) {
		// If we have no marked piece
		if (this.markedPiece == null) {
			JOptionPane.showMessageDialog(this, "Can't select an empty square!");
			return;
		}
		// If we have a marked piece, then perform the move
		move(clickedSquare);
	}
	
	public void move(Square clickedSquare) {
		// If good move
		int prevI = this.markedPiece.i;
		int prevJ = this.markedPiece.j;
		// int[] pair = null;
		List<List<Integer>> moves = this.markedPiece.getAvailableMoves(this.board);
		if (this.markedPiece.validateMove(this.board, clickedSquare.i, clickedSquare.j)) {


			if (this.kingIsChecked) {
				// Make a copy of the board
				Square[][] tempBoard = new Square[8][8];
				for (int i=0; i<8; i++) {
					for (int j=0; j<8; j++) {
						tempBoard[i][j] = this.board[i][j];
					}
				}

				tempBoard[clickedSquare.i][clickedSquare.j].piece = this.markedPiece;
				tempBoard[this.markedPiece.i][this.markedPiece.j].piece = null;
				// Change position of king and check if still in check TODO
				// // Temporarily change the position of the king
				if (this.markedPiece instanceof King){
					this.markedPiece.i = clickedSquare.i;
					this.markedPiece.j = clickedSquare.j;
				}

				if (this.isKingChecked(tempBoard, this.currentTurn)) {
					JOptionPane.showMessageDialog(this, "YOUR KING IS STILL CHECKED!");
					//clickedSquare.mark();
					this.showMoves(this.board, moves);
					this.board[this.markedPiece.i][this.markedPiece.j].mark();
					
					this.markedPiece.i = prevI;
					this.markedPiece.j = prevJ;

					tempBoard[this.markedPiece.i][this.markedPiece.j].piece = this.markedPiece;
					tempBoard[clickedSquare.i][clickedSquare.j].piece = null;
					this.markedPiece = null;
					
					return;
				}
			}
			
			int fromI = prevI;
			int fromJ = prevJ;
			Square[][] newBoard = this.markedPiece.move(clickedSquare.i, clickedSquare.j, this.board);
			updateBoard(newBoard, fromI, fromJ, clickedSquare.i, clickedSquare.j, moves);
			this.markedPiece = null;
			
			if (this.currentTurn.equals("WHITE")) {
				this.currentTurn = "BLACK";
			}else {
				this.currentTurn = "WHITE";
			}
			
			this.kingIsChecked = this.isKingChecked(this.board, this.currentTurn);
			if (this.kingIsChecked) {
				JOptionPane.showMessageDialog(this, this.currentTurn + " king is checked!");
			}
		}else {
			JOptionPane.showMessageDialog(this, "ILLEGAL MOVE");
		}
		
		this.kingIsChecked = this.isKingChecked(this.board, this.currentTurn);
		
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
	
	public boolean isKingChecked(Square[][] board, String colorKing) {
		
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (board[i][j].piece instanceof King && (board[i][j].piece.color.equals(colorKing))) {
					return ((King) board[i][j].piece).isChecked(board);
				}
			}
		}
		// Have to have this
		return false;
	}

	public void showMoves(Square[][] board, List<List<Integer>> moves) {
		for (List<Integer> coordinates: moves) {
			board[coordinates.get(0)][coordinates.get(1)].fill();
		}
	}
	
	public void updateBoard(Square[][] newBoard, int fromI, int fromJ, int i, int j, List<List<Integer>> moves){
		// Update the board to the new state
		this.board[fromI][fromJ].setIcon(null);
		this.board[fromI][fromJ].mark();
		this.board[fromI][fromJ].piece = null;
		
		if ((i == 7 || i == 0) && (this.markedPiece instanceof Pawn)) {
			Piece newPiece = promotion(i, j);
			newBoard[i][j].piece = newPiece;
			this.board[i][j].setIcon(newPiece.image);
		}else {
			this.board[i][j].setIcon(this.markedPiece.image);
		}

		this.showMoves(board, moves);
		this.markedPiece = null;
		this.board = newBoard;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		Square clickedSquare = (Square) e.getSource();
		
		if (this.markedPiece == null) {
			if (this.currentTurn.equals("WHITE") && clickedSquare.piece != null && clickedSquare.piece.color.equals("BLACK")) {
				JOptionPane.showMessageDialog(this, "PLEASE SELECT A WHITE PIECE");
				return;
			}else if (this.currentTurn.equals("BLACK") && clickedSquare.piece != null && clickedSquare.piece.color.equals("WHITE")) {
				JOptionPane.showMessageDialog(this, "PLEASE SELECT A BLACK PIECE");
				return;
			}
		}
		
		if (clickedSquare.piece != null) {
			clickNonEmpty(clickedSquare);
		}else {
			clickEmpty(clickedSquare);
		}
	}
}
