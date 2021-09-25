package Frame;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class myFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public myFrame() {
		super("Frame made by Mervan Kaya");
		setSize(600,600); //width x height
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());		
	}
}
