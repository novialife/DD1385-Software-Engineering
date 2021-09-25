package Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class myButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Color first_c;
	Color second_c;
	String first_s;
	String second_s;
	static JButton button;
	
	
	public myButton(Color c1, Color c2, String s1, String s2) {		
		
		first_c = c1;
		second_c = c2;
		first_s = s1;
		second_s = s2;
		
		button = new JButton();
		this.setText(first_s);
		this.setBackground(first_c);
		this.addActionListener(this);
	}
	private void toggleState() {
		String label = this.getText();
		if (label == first_s) {
			this.setText(second_s);
			this.setBackground(second_c);
		} else {
			this.setText(first_s);
			this.setBackground(first_c);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		toggleState();
	}
}