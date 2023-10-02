import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Player {

	CardDeck hand;
	protected Color glove;
	protected int x;
	protected int y;
//	protected boolean goodSlap;
//	protected boolean badSlap;

	public Player(Color c) {
		hand = new CardDeck();
		glove = c;
		x = 780;
		y = 870;
	}
	
	public CardDeck getHand() {
		return hand;
	}

	public void setHand(CardDeck hand) {
		this.hand = hand;
	}

	public void drawGlove(Graphics g) {
//		g.setColor(Color.black);
//		g.fillRect(375, 525, 200, 800);
		
		g.setColor(glove);
		//hand base
		g.fillOval(x, y, 135, 110);
		//thumb
		g.fillArc(x-5, y, 35, 75, 90, 360);
		//index finger
		g.fillArc(x+25, y-50, 30, 100, 90, 360);
		//middle finger
		g.fillArc(x+55, y-55, 30, 100, 90, 360);
		//ring finger
		g.fillArc(x+85, y-50, 30, 100, 90, 360);
		//pinky
		g.fillArc(x+115, y-20, 25, 90, 90, 360);
	}
	
	public void drawDeck(Graphics g) {
		for(Card e : hand.getDeck())
			e.drawBack(g, 740, 860);
	}
	
	public void takeDeck(CardDeck deck) {
		for (int i = deck.getDeck().size()-1; i >= 0 ; i--) {
			hand.add(0, deck.getDeck().get(i));;
			deck.getDeck().remove(i);
		}
	}
	
	public void burnOne(CardDeck deck) {
		if(deck.getDeck().size()==0)
			return;
		else {
		deck.getDeck().add(0, hand.getDeck().remove(hand.getDeck().size() - 1));
		}
	}
	
//	public boolean isAWinner(CardDeck d) {
//		int rules = 0;
//		if (hand.isDouble()) 
//			rules++;
//		if (hand.isFamily())
//			rules++;
//		if (hand.isMarriage())
//			rules++;
//		if (hand.isRed10())
//			rules++;
//		if (hand.isSandwich())
//			rules++;
//		if (hand.isSandwich10())
//			rules++;
//		if (hand.isBottoms())
//			rules++;
//		if (hand.isSum10())
//			rules++;
//		if (rules > 0) {
//			return true;
//		}
//		return false;
//	}
	
	public Color getGlove() {
		return glove;
	}

	public void setGlove(Color glove) {
		this.glove = glove;
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
	
	
}