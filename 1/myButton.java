package Button;
import java.awt.Color;
import javax.swing.JButton;

public class myButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	public Color first_c;
	public Color second_c;
	public String first_s;
	public String second_s;
	public JButton button;
	
	
	public myButton(Color c1, Color c2, String s1, String s2) {		
		
		first_c = c1;
		second_c = c2;
		first_s = s1;
		second_s = s2;
		
		this.setText(first_s);
		this.setBackground(first_c);
	}
	
	public void toggleState() {
		String label = this.getText();
		if (label == this.first_s) {
			this.setText(this.second_s);
			this.setBackground(this.second_c);
		} else {
			this.setText(this.first_s);
			this.setBackground(this.first_c);
			}
		}
		
	}

