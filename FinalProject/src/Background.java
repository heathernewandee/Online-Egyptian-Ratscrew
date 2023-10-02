import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Background {

	int x;
	int y;
	Color backColor;
	String colorName = "";
	
	public Background(int why, Color c, String str) {
		x = 200;
		y = why;
		backColor = c;
		colorName = str;
	}
	
	public Background(boolean a, int why, Color c, String str) {
		x = 800;
		y = why;
		backColor = c;
		colorName = str;
	}
	
	public void display(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("courier", Font.BOLD, 30));
		g.drawOval(x, y, 20, 20);
		
		g.setColor(backColor);
		g.drawString(colorName, x+50, y+20);
	}
	
	public void fillCircle(Graphics g) {
		g.setColor(backColor);
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getBackColor() {
		return backColor;
	}

	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	
}
