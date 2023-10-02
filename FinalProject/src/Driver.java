import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		// frame.setSize(1920,1080);
		frame.setSize(1680, 1050);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ColorPanel myPanel = new ColorPanel(1680, 1050);
		frame.getContentPane().add(myPanel);

		frame.setVisible(true);
		while (true) {
			frame.repaint();
		}
		
	}

}