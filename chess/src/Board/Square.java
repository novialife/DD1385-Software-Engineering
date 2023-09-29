package Board;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Pieces.Piece;

import java.awt.Color;

public class Square extends JButton {
	private static final long serialVersionUID = 1L;
	

	public int i;
	public int j;
	public JButton button;
	public Piece piece;
	public String color;
	public Icon image;
	public Color white = new Color(240,217,181);
	public Color black = new Color(181,136,99);
	public boolean isMarked = false;
	public boolean isFilled = false;
	
	
	public Square(Piece piece, String color, int i,int j) {
		this.i = i;
		this.j = j;
		this.piece = piece;
		this.color = color;
		
		if (this.piece != null) {
			this.image = this.piece.image;
		}
		
		Color background;
		if (color.equals("WHITE")) {
			background = white;

		}else {
			background = black;
		}
		
		setBackground(background);
		setBorder(new LineBorder(background));
		this.setIcon(image);
		
	}

	public void mark() {
		if (this.getBackground() == Color.green) {
			if (color.equals("WHITE")) {
				this.setBackground(white);
			}else {
				this.setBackground(black);
			}
			this.isMarked = false;
		}else {
			this.setBackground(Color.green);
			this.isMarked = true;
		}
	}
	
	public void fill() {
		if (this.isFilled) {
			if (color.equals("WHITE")) {
				this.setBackground(white);
			}else {
				this.setBackground(black);
			}
			this.isFilled = false;
		}else {
			this.setBackground(Color.lightGray);
			this.isFilled = true;
		}
	}
}
