import Button.myButton;
import Frame.myFrame;
import java.awt.Color;


public class Bonus {

	public static void main(String[] args) {
		

		int amount = Integer.parseInt(args[0]);
		

		myButton[] button_List = new myButton[20];
		
		
		int j = 0;
		
		for (int i=0; i<amount; i++) {
			button_List[i] = new myButton(Color.green, Color.red, args[j+1], args[j+2]);
			j+=2;
		}
		
		myFrame frame = new myFrame(button_List);

		frame.setVisible(true);
	}
}
