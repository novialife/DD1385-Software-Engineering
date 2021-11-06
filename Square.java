package labb2;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Square extends JButton {
	private static final long serialVersionUID = 1L;
	

	public JButton button;

	
	public Square(String Value) {
		this.setText(Value);
		this.setBackground(Color.gray);
		
		setBorder(new LineBorder(Color.BLACK));
		
	}
	
	public void toggleState() {
		System.out.println("Tryck på knapp ");
		}
}
