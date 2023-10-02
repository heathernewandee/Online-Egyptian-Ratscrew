import java.awt.Graphics;
import java.util.ArrayList;

public class CardDeck {

	private ArrayList<Card> deck;

	public CardDeck() {
		deck = new ArrayList<Card>();
	}

	public CardDeck(boolean isMiddle) {
		deck = new ArrayList<Card>();
		deck.add(new Card('c', 1));
		deck.add(new Card('s', 1));
		deck.add(new Card('h', 1));
		deck.add(new Card('d', 1));
		deck.add(new Card('c', 2));
		deck.add(new Card('s', 2));
		deck.add(new Card('h', 2));
		deck.add(new Card('d', 2));
		deck.add(new Card('c', 3));
		deck.add(new Card('s', 3));
		deck.add(new Card('h', 3));
		deck.add(new Card('d', 3));
		deck.add(new Card('c', 4));
		deck.add(new Card('s', 4));
		deck.add(new Card('h', 4));
		deck.add(new Card('d', 4));
		deck.add(new Card('c', 5));
		deck.add(new Card('s', 5));
		deck.add(new Card('h', 5));
		deck.add(new Card('d', 5));
		deck.add(new Card('c', 6));
		deck.add(new Card('s', 6));
		deck.add(new Card('h', 6));
		deck.add(new Card('d', 6));
		deck.add(new Card('c', 7));
		deck.add(new Card('s', 7));
		deck.add(new Card('h', 7));
		deck.add(new Card('d', 7));
		deck.add(new Card('c', 8));
		deck.add(new Card('s', 8));
		deck.add(new Card('h', 8));
		deck.add(new Card('d', 8));
		deck.add(new Card('c', 9));
		deck.add(new Card('s', 9));
		deck.add(new Card('h', 9));
		deck.add(new Card('d', 9));
		deck.add(new Card('c', 10));
		deck.add(new Card('s', 10));
		deck.add(new Card('h', 10));
		deck.add(new Card('d', 10));
		deck.add(new Card('c', 11));
		deck.add(new Card('s', 11));
		deck.add(new Card('h', 11));
		deck.add(new Card('d', 11));
		deck.add(new Card('c', 12));
		deck.add(new Card('s', 12));
		deck.add(new Card('h', 12));
		deck.add(new Card('d', 12));
		deck.add(new Card('c', 13));
		deck.add(new Card('s', 13));
		deck.add(new Card('h', 13));
		deck.add(new Card('d', 13));

		shuffle();
	}

	public void shuffle() {
		for (int i = 0; i < 52; i++) {
			int ran = (int) (Math.random() * (52));
			Card temp = deck.get(i);
			deck.set(i, deck.get(ran));
			deck.set(ran, temp);
		}
	}

	public void deal(CardDeck middle, CardDeck receiver, int n) {
		for (int i = 0; i < n; i++)
			receiver.getDeck().add(middle.getDeck().remove(0));
	}

	public void add(Card c) {
		deck.add(c);
	}

	public void add(int n, Card c) {
		deck.add(n, c);
	}

	public void draw(Graphics g) {
		for (int i = 0; i < deck.size(); i++) {
			if (i % 5 == 0)
				deck.get(i).drawFront(g, 700, 360);
			if (i % 5 == 1)
				deck.get(i).drawFront(g, 740, 390);
			if (i % 5 == 2)
				deck.get(i).drawFront(g, 770, 330);
			if (i % 5 == 3)
				deck.get(i).drawFront(g, 680, 340);
			if (i % 5 == 4)
				deck.get(i).drawFront(g, 750, 380);
		}
	}

	public int isFace() {
		if (deck.get(deck.size() - 1).getNumber() == 1)
			return 1;
		if (deck.get(deck.size() - 1).getNumber() == 11)
			return 11;
		if (deck.get(deck.size() - 1).getNumber() == 12)
			return 12;
		if (deck.get(deck.size() - 1).getNumber() == 13)
			return 3;
		return -1;
	}

	public boolean isDouble() {
		if (deck.size() < 2)
			return false;
		if (deck.get(deck.size() - 1).getNumber() == deck.get(deck.size() - 2).getNumber())
			return true;
		return false;
	}

	public boolean isSandwich() {
		if (deck.size() < 3)
			return false;
		if (deck.get(deck.size() - 1).getNumber() == deck.get(deck.size() - 3).getNumber())
			return true;
		return false;
	}

	public boolean isSum10() {
		if (deck.size() < 2)
			return false;
		if (deck.get(deck.size() - 1).getNumber() + deck.get(deck.size() - 2).getNumber() == 10)
			return true;
		return false;
	}

	public boolean isSandwich10() {
		if (deck.size() < 3)
			return false;
		if (deck.get(deck.size() - 1).getNumber() + deck.get(deck.size() - 3).getNumber() == 10)
			return true;
		return false;
	}

	public boolean isRed10() {
		if (deck.size() < 1)
			return false;
		if (deck.get(deck.size() - 1).getNumber() == 10)
			if (deck.get(deck.size() - 1).getSuit() == 'd' || deck.get(deck.size() - 1).getSuit() == 'h')
				return true;
		return false;
	}

	public boolean isBottoms() {
		if (deck.size() < 3) {
			return false;
		}
		if (deck.get(0).getNumber() == deck.get(deck.size() - 1).getNumber()) {
			return true;
		}
		return false;
	}

	public boolean isFamily() {
		if (deck.size() < 3)
			return false;
		int a = deck.get(deck.size() - 1).getNumber();
		int b = deck.get(deck.size() - 2).getNumber();
		int c = deck.get(deck.size() - 3).getNumber();
		if (a == 1) {
			if ((b == 2 && c == 13) || (b == 13 && c == 2))
				return true;
			if ((b == 13 && c == 12) || (b == 12 && c == 13))
				return true;
		}
		if (b == 1) {
			if ((a == 2 && c == 13) || (a == 13 && c == 2))
				return true;
			if ((a == 13 && c == 12) || (a == 12 && c == 13))
				return true;
		}
		if (c == 1) {
			if ((b == 2 && a == 13) || (b == 13 && a == 2))
				return true;
			if ((b == 13 && a == 12) || (b == 12 && a == 13))
				return true;
		}
		return 1.0 * (a + b + c) / 3 == (double) a || 1.0 * (a + b + c) / 3 == (double) b
				|| 1.0 * (a + b + c) / 3 == (double) c;
	}

	public boolean isMarriage() {
		if (deck.size() < 2)
			return false;
		if (deck.get(deck.size() - 1).getNumber() == 13 && deck.get(deck.size() - 2).getNumber() == 12)
			return true;
		if (deck.get(deck.size() - 1).getNumber() == 12 && deck.get(deck.size() - 2).getNumber() == 13)
			return true;
		return false;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		deck = deck;
	}

}
