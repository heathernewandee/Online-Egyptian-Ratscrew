import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PlayerButton {

	int x;
	int y;
	String count = " ";
	
	public PlayerButton(int why, int num) {
		x = 50;
		y = why;
		count += num;
	}
	
	public void display(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("courier", Font.BOLD, 30));
		g.drawOval(x, y, 20, 20);
		
		g.drawString(count, x+50, y+20);
	}
	
	public void fillCircle(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(x, y, 20, 20);
	}
	
	public boolean checkIfInside(int clickX, int clickY) {
		// TODO Auto-generated method stub
		int centerX = x+10;
		int centerY = y+10;
		
		double distance = Math.sqrt(Math.pow(centerX-clickX,2) + Math.pow(centerY-clickY, 2));
		if(distance<10)
			return true;
		
		return false;
	}
	
}
