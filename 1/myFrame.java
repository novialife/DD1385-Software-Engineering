package Frame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Button.myButton;

public class myFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public myButton[] buttons;
	
	
	public myFrame() {
		super("Frame made by Mervan Kaya");
	
		setSize(600,600); //width x height
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());	
		
	}
	
	public myFrame(myButton[] button_list) {
		super("Frame made by Mervan Kaya");
		
		this.buttons = button_list;
		
		for (myButton button: buttons) {
			button.addActionListener(this); 
			add(button);
		}
		//https://stackoverflow.com/questions/47292516/when-i-press-1-button-i-want-all-other-buttons-to-change-states
		
		setSize(600,600); //width x height
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	for (myButton button: this.buttons){
	    if (button != e.getSource())
	        button.toggleState();
		}
	}
}
