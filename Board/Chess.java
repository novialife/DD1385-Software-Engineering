package Board;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Pieces.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chess extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public Square[][] board = new Square[8][8];
	public Piece markedPiece;
	public int[] moveTo;
	
	
	
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
		
		while (true) {
			whiteTurn();
			blackTurn();
		}
	}
	
	public void showMoves(Piece p){
		// Show the user the availble moves
	}
	public void promotion(Pawn p){
		// Promote a pawn to a Queen
	}
	
	public void whiteTurn() {
		// Play a turn for white
		
	}
	
	public void blackTurn() {
		// Play a turn for black
		
	}
	
	public String getStatus(int i, int j){
		// Check if move is OK or not
		return null;
	}
	
	public boolean kingStatus(){
		// Check if king is OK or not
		return true;
	}
	
	public void updateBoard(Square[][] newBoard, int fromI, int fromJ, int i, int j){
		// Update the board to the new state
		this.board[fromI][fromJ].setIcon(null);
		this.board[fromI][fromJ].mark();
		this.board[i][j].setIcon(this.markedPiece.image);
		this.board[i][j].piece = board[i][j].piece;
		this.board[i][j].mark();
		this.markedPiece = null;
		this.board = newBoard;
	}
	
	public void raiseError(String err){
		// Raise an error "err"
	}
	
	public void markSquare(int i, int j) {
		this.board[i][j].mark();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Square clickedSquare = (Square) e.getSource();
		System.out.print("Clicked Piece: ");
		System.out.print(clickedSquare.piece);
		System.out.println();
		System.out.print("Marked Piece: ");
		System.out.print(this.markedPiece);
		System.out.println();
		System.out.println();


		
		
		if (clickedSquare.piece != null) {
			// Click on non-empty square
			if (this.markedPiece == clickedSquare.piece) {
				// If we click on the same square
				this.markedPiece = null;
				clickedSquare.mark();
				JOptionPane.showMessageDialog(this, "Can't go to same square!");
				return;
				
			}else if (this.markedPiece == null) {
				// If no marked piece
				this.markedPiece = clickedSquare.piece;
				clickedSquare.mark();
			}else if (this.markedPiece.color.equals(clickedSquare.piece.color)) {
				// Cant click two same colored pieces!
				JOptionPane.showMessageDialog(this, "Can't take your own piece!");
				return;
			}else {
				clickedSquare.mark();
				if (this.markedPiece.validateMove(this.board, clickedSquare.i, clickedSquare.j)) {
					int fromI = this.markedPiece.i;
					int fromJ = this.markedPiece.j;
					Square[][] newBoard = this.markedPiece.move(clickedSquare.i, clickedSquare.j, this.board);
					updateBoard(newBoard, fromI, fromJ, clickedSquare.i, clickedSquare.j);
				}else {
					JOptionPane.showMessageDialog(this, "ILLEGAL MOVE");
					clickedSquare.mark();
				}
			}
		}else {
			// Clicked on empty square
			if (this.markedPiece == null) {
				// And marked piece is null
				JOptionPane.showMessageDialog(this, "Can't select an empty square!");
				return;
			}else {
				clickedSquare.mark();
				if (this.markedPiece.validateMove(this.board, clickedSquare.i, clickedSquare.j)) {
					int fromI = this.markedPiece.i;
					int fromJ = this.markedPiece.j;
					Square[][] newBoard = this.markedPiece.move(clickedSquare.i, clickedSquare.j, this.board);
					updateBoard(newBoard, fromI, fromJ, clickedSquare.i, clickedSquare.j);
				}else {
					JOptionPane.showMessageDialog(this, "ILLEGAL MOVE");
					clickedSquare.mark();
				}
			}
		}
	}
}
