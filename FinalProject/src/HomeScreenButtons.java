import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HomeScreenButtons {
	
	private int x;
	private int y;
	private int length;
	private int width;
	private Color color;
	private String text;
	
	public HomeScreenButtons(int x, int y, Color c, String t) {
		this.x = x; this.y = y;
		length = 350; width = 125;
		color = c;
		text = t;
	}
	
	public HomeScreenButtons(int x, int y, int l, int w, Color c, String t) {
		this.x = x; this.y = y;
		length = l; width = w;
		color = c;
		text = t;
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean checkIfInsideButton(int clickX, int clickY) {
		// TODO Auto-generated method stub
		if(clickX<x||clickX>x+length)
			return false;
		if(clickY<y||clickY>y+width)
			return false;
		return true;
	}

	public void draw(Graphics g, Font f) {
		g.setFont(f);
		g.setColor(color);
		g.fillRect(x, y, length, width);
		g.setColor(color.WHITE);
		if(length<150)
			g.drawString(text, x+(length/2)-(text.length()*6), y+(width/2)+7);
		else if(length>400)
			g.drawString(text, x+(length/2)-(text.length()*23), y+(width/2)+15);
		else if(text.length()<17) 
			g.drawString(text, x+(length/2)-(text.length()*10), y+(width/2)+7);
		else {
			g.drawString(text.substring(0, text.indexOf(' ')), x+(length/2)-(text.length()+55),  y+(width/2)-4);
			g.drawString(text.substring(text.indexOf(' ')+1), x+(length/2)-(text.length()+70), y+(width/2)+19);
		}
	}

	public void move(int i, int j) {
		x = i-(length/2); y = j-(width/2);
	}
	
}
