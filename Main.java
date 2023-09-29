import java.awt.Color;
import Button.myButton;
import Frame.myFrame;

public class Main {

	public static void main(String[] args) {
		myFrame frame = new myFrame();
		myButton button1 = new myButton(Color.white, Color.cyan, "On", "Off");
		myButton button2 = new myButton(Color.green, Color.red, "Run", "Stop");
		
		frame.add(button1);
		frame.add(button2);
		
		frame.setVisible(true);
	}

}
