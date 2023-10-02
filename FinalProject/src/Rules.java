import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Rules {

	private static int count = 0;
	private int x = 0;
	private int y = 0;
	private String ruleName = "";
	private boolean isPlaying;
	private int boxY = 100;
	
	public Rules(int ex, int why, String str) {
		x = ex;
		y = why;
		ruleName = str;
		isPlaying = false;
		count++;
		boxY += 50*count;
	}
	
	public void drawText(Graphics g) {
		g.setColor(Color.magenta);
		g.setFont(new Font("courier", Font.BOLD, 30));
		
		g.drawRect(150, boxY, 30, 30);
		g.drawString(ruleName, x, y);
	
	}
	
	public void fillBox(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(150, boxY, 30, 30);
	}
	
	public boolean checkIfInside(int clickX, int clickY) {
		// TODO Auto-generated method stub
		if(clickX<150||clickX>180)
			return false;
		if(clickY<boxY||clickY>boxY+30)
			return false;
		return true;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Rules.count = count;
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

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public int getBoxY() {
		return boxY;
	}

	public void setBoxY(int boxY) {
		this.boxY = boxY;
	}
	
	
}
