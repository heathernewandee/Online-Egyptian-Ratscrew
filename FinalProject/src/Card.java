import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {

	private char suit;
	private int number;
	private BufferedImage suitImg;
	private BufferedImage suitImgSmall;
	private BufferedImage suitImgSmallUD;
	private BufferedImage back;

	public Card(char s, int n) {
		suit = s;
		number = n;
		try {
			back = ImageIO.read(new File("back.png"));

			if (suit == 's') {
				suitImg = ImageIO.read(new File("spade.png"));
				suitImgSmall = ImageIO.read(new File("spadeSmall.png"));
				suitImgSmallUD = ImageIO.read(new File("spadeSmallUD.png"));
			}
			if (suit == 'c') {
				suitImg = ImageIO.read(new File("clover.png"));
				suitImgSmall = ImageIO.read(new File("cloverSmall.png"));
				suitImgSmallUD = ImageIO.read(new File("cloverSmallUD.png"));
			}
			if (suit == 'h') {
				suitImg = ImageIO.read(new File("heart.png"));
				suitImgSmall = ImageIO.read(new File("heartSmall.png"));
				suitImgSmallUD = ImageIO.read(new File("heartSmallUD.png"));
			}
			if (suit == 'd') {
				suitImg = ImageIO.read(new File("diamond.png"));
				suitImgSmall = ImageIO.read(new File("diamondSmall.png"));
				suitImgSmallUD = ImageIO.read(new File("heartSmallUD.png"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public char getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void drawFront(Graphics g, int x, int y) {
		long limit = 25000000;
		for (int i = 0; i < limit; i++)
			;

		Font f = new Font("courier", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 200, 300);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 200, 300);

		if (suit == 'h' || suit == 'd')
			g.setColor(Color.RED);

		String n = "" + number;
		if (n.equals("1"))
			n = "A";
		if (n.equals("11"))
			n = "J";
		if (n.equals("12"))
			n = "Q";
		if (n.equals("13"))
			n = "K";

		// draw middle
		g.drawImage(suitImg, x + 49, y + 100, null);

		// draw the tinies in the corners
		if (number == 10)
			g.drawImage(suitImgSmall, x + 18, y + 35, null);
		else
			g.drawImage(suitImgSmall, x + 9, y + 35, null);
		g.drawString("" + n, x + 10, y + 30);

		if (number == 10)
			g.drawImage(suitImgSmallUD, x + 162, y + 245, null);
		else
			g.drawImage(suitImgSmallUD, x + 172, y + 245, null);
		Graphics2D g2D = (Graphics2D) g;
		g2D.rotate(Math.PI);
		g2D.translate(-1680, -1050);
		g2D.drawString("" + n, 1680 - x - 193, 1050 - y - 275);
		g2D.rotate(Math.PI);
		g2D.translate(-1680, -1050);

	}
	
	public void drawBack(Graphics g, int x, int y) {
		g.drawImage(back, x, y, null);
	}

	public String toString() {
		return "" + suit + " " + number;
	}

}
