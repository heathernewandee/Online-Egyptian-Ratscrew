import java.awt.Color;
import java.awt.Graphics;

public class Computer extends Player {

	private String speed;
	private int slapTempo;
	private int num;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private static int numPlayers;

	public Computer(Color c, int numPlayer, String speedLevel) {

		super(c);
		x1 = 780;
		y1 = 10;
		x2 = 30;
		y2 = 450;
		x3 = 1550;
		y3 = 450;

		num = numPlayer;

		if (speedLevel.equals("slow")) {
			slapTempo = 4000;
		} else if (speedLevel.equals("medium")) {
			slapTempo = 3000;
		} else if (speedLevel.equals("fast")) {
			slapTempo = 2000;
		} else {
			slapTempo = 1000;
		}
		speed = speedLevel;

	}

	public void drawGlove(Graphics g) {
		g.setColor(Color.black);
		if (num == 1) {
			// hand base
			g.fillOval(x1, y1, 135, 110);
			// thumb
			g.fillArc(x1 + 105, y1 + 30, 35, 75, 90, 360);
			// index finger
			g.fillArc(x1 + 25, y1 + 50, 30, 100, 90, 360);
			// middle finger
			g.fillArc(x1 + 55, y1 + 55, 30, 100, 90, 360);
			// ring finger
			g.fillArc(x1 + 85, y1 + 50, 30, 100, 90, 360);
			// pinky
			g.fillArc(x1, y1 + 30, 25, 90, 90, 360);
		} else if (num == 2) {
			// hand base
			g.fillOval(x2, y2, 110, 135);
			// thumb
			g.fillArc(x2 + 30, y2 - 5, 75, 40, 90, 360);
			// index finger
			g.fillArc(x2 + 60, y2 + 25, 100, 30, 90, 360);
			// middle finger
			g.fillArc(x2 + 65, y2 + 55, 100, 30, 90, 360);
			// ring finger
			g.fillArc(x2 + 60, y2 + 85, 100, 30, 90, 360);
			// pinky
			g.fillArc(x2 + 40, y2 + 115, 90, 25, 90, 360);
		} else {
			// hand base
			g.fillOval(x3, y3, 110, 135);
			// thumb
			g.fillArc(x3, y3 + 100, 75, 40, 90, 360);
			// index finger
			g.fillArc(x3 - 60, y3 + 20, 100, 30, 90, 360);
			// middle finger
			g.fillArc(x3 - 65, y3 + 50, 100, 30, 90, 360);
			// ring finger
			g.fillArc(x3 - 60, y3 + 80, 100, 30, 90, 360);
			// pinky
			g.fillArc(x3 - 30, y3 - 5, 90, 25, 90, 360);
		}

	}

	public void drawDeck(Graphics g) {
		if (num == 1)
			for (Card e : hand.getDeck())
				e.drawBack(g, x1 - 40, y1 - 170);
		if (num == 2)
			for (Card e : hand.getDeck())
				e.drawBack(g, x2 - 100, y2 - 80);
		if (num == 3)
			for (Card e : hand.getDeck())
				e.drawBack(g, x3, y3 - 80);
	}

	public double computerSlap(CardDeck middle, boolean canDouble, boolean canSandwich, boolean canAddTo10,
			boolean canThreeCardRun, boolean canRed10, boolean canSandwich10, boolean canBottoms, boolean canMarriage) {
		int canSlap = 0;
		if (canDouble && middle.isDouble())
			canSlap++;
		if (canSandwich && middle.isSandwich())
			canSlap++;
		if (canAddTo10 && middle.isSum10())
			canSlap++;
		if (canThreeCardRun && middle.isFamily())
			canSlap++;
		if (canRed10 && middle.isRed10())
			canSlap++;
		if (canSandwich10 && middle.isSandwich10())
			canSlap++;
		if (canBottoms && middle.isBottoms())
			canSlap++;
		if (canMarriage && middle.isMarriage())
			canSlap++;
		if (canSlap > 0) {
			if (speed.equals("slow"))
				if ((int) (Math.random() * 5) > 2)
					return Math.random() * 5500 + 1500;
			if (speed.equals("medium"))
				if ((int) (Math.random() * 5) > 1)
					return Math.random() * 5000 + 800;
			if (speed.equals("fast"))
				if ((int) (Math.random() * 5) > 0)
					return Math.random() * 4500 + 500;
			if (speed.equals("extreme"))
				return Math.random() * 4000 + 300;
			return -1;
		} else {
			if (speed.equals("slow"))
				if ((int) (Math.random() * 100) > 20)
					return Math.random() * 5500 + 1500;
			if (speed.equals("medium"))
				if ((int) (Math.random() * 100) > 60)
					return Math.random() * 5000 + 800;
			if (speed.equals("fast"))
				if ((int) (Math.random() * 100) > 70)
					return Math.random() * 4500 + 500;
			if (speed.equals("extreme"))
				if ((int) (Math.random() * 100) > 97)
					return Math.random() * 4000 + 300;
			return -1;
		}
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	public int getY3() {
		return y3;
	}

	public void setY3(int y3) {
		this.y3 = y3;
	}

	public static int getNumPlayers() {
		return numPlayers;
	}

	public static void setNumPlayers(int numPlayers) {
		Computer.numPlayers = numPlayers;
	}

	public int getSlapTempo() {
		return slapTempo;
	}

	public void setSlapTempo(int slapTempo) {
		this.slapTempo = slapTempo;
	}

}
