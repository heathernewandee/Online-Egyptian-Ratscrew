import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private int dimX;
	private int dimY;
	private boolean didDeal;

	// Home Screen Things
	// 0 = home screen, 1 = play; 2 = how to play; 3 = rules; 4 = background; 5 =
	// number players; 6 = pause; 7 = pause error; 8 = ending screen
	private int activeScreen;
	private boolean active;
	private int x;
	private int y;
	private Color color;
	private HomeScreenButtons play;
	private HomeScreenButtons howToPlay;
	private HomeScreenButtons customizeRules;
	private HomeScreenButtons customizeBackground;
	private HomeScreenButtons customizePlayers;
	private HomeScreenButtons back;

	// Play Stuff
	private CardDeck middle;
	private ClockTimer clock;
	private HomeScreenButtons pause;
	private HomeScreenButtons exit;
	private HomeScreenButtons resume;
	private HomeScreenButtons playAgain;

	// Rules
	private Rules dooble;
	private Rules sandwich;
	private Rules red10;
	private Rules addTo10;
	private Rules threeCardRun;
	private Rules sandwich10;
	private Rules bottoms;
	private Rules marriage;

	private boolean doobleDraw;
	private boolean sandwichDraw;
	private boolean red10Draw;
	private boolean addTo10Draw;
	private boolean threeCardRunDraw;
	private boolean sandwich10Draw;
	private boolean bottomsDraw;
	private boolean marriageDraw;

	// Background Colors
	private Background red;
	private Background orange;
	private Background yellow;
	private Background green;
	private Background blue;
	private Background purple;
	private Background pink;
	private Background black;
	private Background gray;

	private boolean redSwitch;
	private boolean orangeSwitch;
	private boolean yellowSwitch;
	private boolean greenSwitch;
	private boolean blueSwitch;
	private boolean purpleSwitch;
	private boolean pinkSwitch;
	private boolean blackSwitch;
	private boolean graySwitch;

	// Player settings
	private Player playerOne;
	private Computer playerTwo;
	private Computer playerThree;
	private Computer playerFour;

	private PlayerButton one;
	private PlayerButton two;
	private PlayerButton three;

	private boolean oneSwitch;
	private boolean twoSwitch;
	private boolean threeSwitch;

	private Background redGlove;
	private Background orangeGlove;
	private Background yellowGlove;
	private Background greenGlove;
	private Background blueGlove;
	private Background purpleGlove;
	private Background pinkGlove;
	private Background blackGlove;
	private Background grayGlove;
	private Background whiteGlove;

	private boolean redGloveSwitch;
	private boolean orangeGloveSwitch;
	private boolean yellowGloveSwitch;
	private boolean greenGloveSwitch;
	private boolean blueGloveSwitch;
	private boolean purpleGloveSwitch;
	private boolean pinkGloveSwitch;
	private boolean blackGloveSwitch;
	private boolean grayGloveSwitch;
	private boolean whiteGloveSwitch;

	// Computer Settings
	private SlapSpeed slow;
	private SlapSpeed medium;
	private SlapSpeed fast;
	private SlapSpeed extreme;

	private boolean slowSwitch;
	private boolean mediumSwitch;
	private boolean fastSwitch;
	private boolean extremeSwitch;

	private int turn;
	private int putdown;
	private boolean goodSlap;
	private boolean badSlap;

	private final long PERIOD;

	public ColorPanel(int x, int y) {

		// Button and Screen Settings
		activeScreen = 0;
		active = true;
		dimX = x;
		dimY = y;
		didDeal = false;
		turn = 1;
		putdown = 1;
		goodSlap = false;
		badSlap = false;

		PERIOD = 100000;

		play = new HomeScreenButtons(dimX / 2 - 300, dimY / 2 - 125, 600, 250, Color.GREEN, "PLAY");
		howToPlay = new HomeScreenButtons(95, 240, Color.BLUE, "HOW TO PLAY");
		customizeRules = new HomeScreenButtons(95, 390, Color.PINK, "CUSTOMIZE RULES");
		customizeBackground = new HomeScreenButtons(95, 540, Color.YELLOW, "CUSTOMIZE BACKGROUND");
		customizePlayers = new HomeScreenButtons(95, 690, Color.MAGENTA, "CUSTOMIZE PLAYER");

		back = new HomeScreenButtons(30, 30, 130, 50, Color.BLACK, "BACK");
		pause = new HomeScreenButtons(20, 20, 180, 50, Color.BLACK, "PAUSE");
		exit = new HomeScreenButtons(500, 480, 300, 150, Color.GRAY, "EXIT");
		resume = new HomeScreenButtons(870, 480, 300, 150, Color.GRAY, "RESUME");
		playAgain = new HomeScreenButtons(870, 480, 300, 150, Color.GRAY, "PLAY AGAIN");

		middle = new CardDeck(true);
		clock = new ClockTimer();

		// Rule Settings
		dooble = new Rules(200, 175, "DOUBLES");
		sandwich = new Rules(200, 225, "SANDWICH");
		red10 = new Rules(200, 275, "RED 10s");
		addTo10 = new Rules(200, 325, "ADD TO 10s");
		threeCardRun = new Rules(200, 375, "3 CARD RUN");
		sandwich10 = new Rules(200, 425, "SANDWICH 10s");
		bottoms = new Rules(200, 475, "BOTTOMS");
		marriage = new Rules(200, 525, "MARRIAGE");

		doobleDraw = true;
		sandwichDraw = true;
		red10Draw = true;
		addTo10Draw = true;
		threeCardRunDraw = true;
		sandwich10Draw = true;
		bottomsDraw = true;
		marriageDraw = true;

		// Background Settings
		red = new Background(150, Color.red, "RED");
		orange = new Background(200, Color.orange, "ORANGE");
		yellow = new Background(250, Color.yellow, "YELLOW");
		green = new Background(300, Color.green, "GREEN");
		blue = new Background(350, Color.blue, "BLUE");
		purple = new Background(400, Color.magenta, "PURPLE");
		pink = new Background(450, Color.pink, "PINK");
		black = new Background(500, Color.black, "BLACK");
		gray = new Background(550, Color.GRAY, "GRAY");

		redSwitch = false;
		orangeSwitch = false;
		yellowSwitch = false;
		greenSwitch = false;
		blueSwitch = false;
		purpleSwitch = false;
		pinkSwitch = false;
		blackSwitch = false;
		graySwitch = false;

		// Player Settings
		playerOne = null;
		playerTwo = null;
		playerThree = null;
		playerFour = null;

		one = new PlayerButton(175, 1);
		two = new PlayerButton(225, 2);
		three = new PlayerButton(275, 3);

		oneSwitch = true;
		twoSwitch = false;
		threeSwitch = false;

		slow = new SlapSpeed(410, 1);
		medium = new SlapSpeed(460, 2);
		fast = new SlapSpeed(510, 3);
		extreme = new SlapSpeed(560, 4);

		slowSwitch = true;
		mediumSwitch = false;
		fastSwitch = false;
		extremeSwitch = false;

		redGlove = new Background(false, 175, Color.red, "RED");
		orangeGlove = new Background(false, 225, Color.orange, "ORANGE");
		yellowGlove = new Background(false, 275, Color.yellow, "YELLOW");
		greenGlove = new Background(false, 325, Color.green, "GREEN");
		blueGlove = new Background(false, 375, Color.blue, "BLUE");
		purpleGlove = new Background(false, 425, Color.magenta, "PURPLE");
		pinkGlove = new Background(false, 475, Color.pink, "PINK");
		blackGlove = new Background(false, 525, Color.black, "BLACK");
		grayGlove = new Background(false, 575, Color.GRAY, "GRAY");
		whiteGlove = new Background(false, 625, Color.white, "WHITE");

		redGloveSwitch = false;
		orangeGloveSwitch = false;
		yellowGloveSwitch = false;
		greenGloveSwitch = false;
		blueGloveSwitch = false;
		purpleGloveSwitch = false;
		pinkGloveSwitch = false;
		blackGloveSwitch = false;
		grayGloveSwitch = false;
		whiteGloveSwitch = true;

		// Clicking Settings
		addMouseListener(new PanelListener());
		addKeyListener(new Controls());
		setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color.WHITE);
		g.fillRect(0, 0, 1680, 1050);

		// Home Screen Drawing
		if (activeScreen == 0) {
			g.setColor(color.DARK_GRAY);
			g.setFont(new Font("courier", Font.BOLD, 120));
			g.drawString("EGYPTIAN RATSCREW", dimX / 2 - (8 * 75), 125);

			// Home Screen Buttons
			play.draw(g, new Font("Helvetica", Font.BOLD, 75));
			howToPlay.draw(g, new Font("Helvetica", Font.BOLD, 30));
			customizeRules.draw(g, new Font("Helvetica", Font.BOLD, 28));
			customizeBackground.draw(g, new Font("Helvetica", Font.BOLD, 25));
			customizePlayers.draw(g, new Font("Helvetica", Font.BOLD, 28));

			// Right Part, Shows Game Settings
			g.setColor(Color.black);
			g.setFont(new Font("Helvetica", Font.BOLD, 30));
			g.drawString("CURRENT GAME SETTINGS: ", 1200, 280);
			g.setFont(new Font("courier", Font.BOLD, 20));
			g.drawString("-Background: ", 1200, 320);

			if (twoSwitch) {
				g.drawString("- 2 Opponents", 1200, 340);
			} else if (threeSwitch) {
				g.drawString("- 3 Opponents", 1200, 340);
			} else {
				oneSwitch = true;
				g.drawString("- 1 Opponent", 1200, 340);
			}

			if (mediumSwitch) {
				g.drawString("- Level: Medium", 1200, 360);
			} else if (fastSwitch) {
				g.drawString("- Level: Fast", 1200, 360);
			} else if (extremeSwitch) {
				g.drawString("- Level: Extreme", 1200, 360);
			} else {
				slowSwitch = true;
				g.drawString("- Level: Slow", 1200, 360);
			}

			g.drawString("- Rules:", 1200, 380);

			if (redSwitch) {
				g.setColor(Color.RED);
				g.drawString("Red", 1347, 320);
			} else if (orangeSwitch) {
				g.setColor(Color.ORANGE);
				g.drawString("Orange", 1347, 320);
			} else if (yellowSwitch) {
				g.setColor(Color.YELLOW);
				g.drawString("Yellow", 1347, 320);
			} else if (greenSwitch) {
				g.setColor(Color.GREEN);
				g.drawString("Green", 1347, 320);
			} else if (blueSwitch) {
				g.setColor(Color.BLUE);
				g.drawString("Blue", 1347, 320);
			} else if (purpleSwitch) {
				g.setColor(Color.MAGENTA);
				g.drawString("Purple", 1347, 320);
			} else if (pinkSwitch) {
				g.setColor(Color.PINK);
				g.drawString("Pink", 1347, 320);
			} else if (blackSwitch) {
				g.setColor(Color.BLACK);
				g.drawString("Black", 1347, 320);
			} else {
				graySwitch = true;
				g.setColor(Color.GRAY);
				g.drawString("Gray", 1347, 320);
			}

			g.setFont(new Font("courier", Font.BOLD, 20));
			int why = 400;
			if (doobleDraw) {
				g.drawString("* Doubles", 1250, why);
				why += 20;
			}
			if (sandwichDraw) {
				g.drawString("* Sandwiches", 1250, why);
				why += 20;
			}
			if (red10Draw) {
				g.drawString("* Red 10s", 1250, why);
				why += 20;
			}
			if (addTo10Draw) {
				g.drawString("* Add To 10s", 1250, why);
				why += 20;
			}
			if (sandwich10Draw) {
				g.drawString("* Sandwich 10s", 1250, why);
				why += 20;
			}
			if (bottomsDraw) {
				g.drawString("* Bottoms", 1250, why);
				why += 20;
			}
			if (marriageDraw) {
				g.drawString("* Marriage", 1250, why);
				why += 20;
			}
			if (threeCardRunDraw) {
				g.drawString("* Three Card Run", 1250, why);
				why += 20;
			}
			if (why < 400)
				g.drawString("Please Select Rules!", 1250, why);

		}
		// Play
		if (activeScreen == 1)
			drawPlay(g);
		// How to Play
		if (activeScreen == 2)
			drawHowToPlay(g, new Font("Helvetica", Font.PLAIN, 20));
		// Customize Rules
		if (activeScreen == 3) {
			drawCustomizeRules(g);
			if (doobleDraw)
				dooble.fillBox(g);
			if (sandwichDraw)
				sandwich.fillBox(g);
			if (red10Draw)
				red10.fillBox(g);
			if (addTo10Draw)
				addTo10.fillBox(g);
			if (threeCardRunDraw)
				threeCardRun.fillBox(g);
			if (sandwich10Draw)
				sandwich10.fillBox(g);
			if (bottomsDraw)
				bottoms.fillBox(g);
			if (marriageDraw)
				marriage.fillBox(g);
		}
		// Customize Background
		if (activeScreen == 4) {
			drawCustomizeBackground(g);
			if (redSwitch)
				red.fillCircle(g);
			if (orangeSwitch)
				orange.fillCircle(g);
			if (yellowSwitch)
				yellow.fillCircle(g);
			if (greenSwitch)
				green.fillCircle(g);
			if (blueSwitch)
				blue.fillCircle(g);
			if (purpleSwitch)
				purple.fillCircle(g);
			if (pinkSwitch)
				pink.fillCircle(g);
			if (blackSwitch)
				black.fillCircle(g);
			if (graySwitch)
				gray.fillCircle(g);
		}
		// Customize Players
		if (activeScreen == 5) {
			drawCustomizePlayers(g);

			if (oneSwitch)
				one.fillCircle(g);
			if (twoSwitch)
				two.fillCircle(g);
			if (threeSwitch)
				three.fillCircle(g);

			if (slowSwitch)
				slow.fillCircle(g);
			if (mediumSwitch)
				medium.fillCircle(g);
			if (fastSwitch)
				fast.fillCircle(g);
			if (extremeSwitch)
				extreme.fillCircle(g);

			if (redGloveSwitch)
				redGlove.fillCircle(g);
			if (orangeGloveSwitch)
				orangeGlove.fillCircle(g);
			if (yellowGloveSwitch)
				yellowGlove.fillCircle(g);
			if (greenGloveSwitch)
				greenGlove.fillCircle(g);
			if (blueGloveSwitch)
				blueGlove.fillCircle(g);
			if (purpleGloveSwitch)
				purpleGlove.fillCircle(g);
			if (pinkGloveSwitch)
				pinkGlove.fillCircle(g);
			if (blackGloveSwitch)
				blackGlove.fillCircle(g);
			if (grayGloveSwitch)
				grayGlove.fillCircle(g);
			if (whiteGloveSwitch)
				whiteGlove.fillCircle(g);

		}
		// Pause and Error Screen
		if (activeScreen == 6 || activeScreen == 7) {
			drawPlay(g);
			drawPause(g);
		}
//		if (activeScreen == 8)
//			drawEnd(g);

	}

	public void drawPlay(Graphics g) {
		if (!didDeal) {
			setPlayers();
			didDeal = true;
		}

		// Setting the background color
		if (redSwitch) {
			g.setColor(Color.red);
		}
		if (orangeSwitch) {
			g.setColor(Color.orange);
		}
		if (yellowSwitch) {
			g.setColor(Color.yellow);
		}
		if (greenSwitch) {
			g.setColor(Color.green);
		}
		if (blueSwitch) {
			g.setColor(Color.blue);
		}
		if (purpleSwitch) {
			g.setColor(Color.magenta);
		}
		if (pinkSwitch) {
			g.setColor(Color.pink);
		}
		if (blackSwitch) {
			g.setColor(Color.black);
		}
		if (graySwitch) {
			g.setColor(Color.gray);
		}
		g.fillRect(0, 0, 1680, 1050);

		// draw pause button
		pause.draw(g, new Font("courier", Font.PLAIN, 40));

		// drawing the clock
		clock.drawClockTimer(g);

		// drawing the table
		g.setColor(new Color(205, 133, 63));
		g.fillOval(dimX / 2 - 650, dimY / 2 - 400, 1300, 800);

		// drawing the middle deck
		middle.draw(g);

		// drawing the players
		playerOne.drawDeck(g);
		playerOne.drawGlove(g);
		playerTwo.drawDeck(g);
		playerTwo.drawGlove(g);
		if (twoSwitch || threeSwitch) {
			playerThree.drawDeck(g);
			playerThree.drawGlove(g);
		}
		if (threeSwitch) {
			playerFour.drawDeck(g);
			playerFour.drawGlove(g);
		}

		if (goodSlap) {
			g.setColor(Color.black);
			g.fillArc(400, 400, 200, 70, 0, 360);
			g.setColor(Color.yellow);
			g.drawString("GOOD SLAP!", 410, 440);
			playerOne.takeDeck(middle);
		}
		if (badSlap) {
			g.setColor(Color.black);
			g.fillArc(400, 400, 200, 70, 0, 360);
			g.setColor(Color.yellow);
			g.drawString("OOPS! BURNING ONE!", 410, 440);
			playerOne.burnOne(middle);
		}

		// HEREEEEEEEEEEEEEEEEEEEEEEEEEE

		do {

			// when a player wins
			if (playerOne != null && playerOne.getHand().getDeck().size() == 52)
				turn = 3;
			if (playerTwo != null && playerTwo.getHand().getDeck().size() == 52)
				turn = 3;
			if (playerThree != null && playerThree.getHand().getDeck().size() == 52)
				turn = 3;
			if (playerFour != null && playerFour.getHand().getDeck().size() == 52)
				turn = 3;
			// user places
			if (turn == 1 && playerOne.getHand().getDeck().size() > 0) {
				if (putdown == 1) {
					return;
				}
				turn = 2;
				putdown = 2;

			}

			// bot1
			if (oneSwitch && middle.getDeck().size() > 0 && turn == 2) {
				if (onTick()) {
					middle.add(playerTwo.getHand().getDeck().remove(playerTwo.getHand().getDeck().size() - 1));
					System.out.println(turn);
				}
			}
			turn = 1;
			putdown = 1;

		} while (turn != 3);

		// when a player wins
		if (playerOne != null && playerOne.getHand().getDeck().size() == 52)

			drawEnd(g, 1);
		if (playerTwo != null && playerTwo.getHand().getDeck().size() == 52)
			drawEnd(g, 2);
		if (playerThree != null && playerThree.getHand().getDeck().size() == 52)
			drawEnd(g, 3);
		if (playerFour != null && playerFour.getHand().getDeck().size() == 52)
			drawEnd(g, 4);

		// HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE

	}

	public boolean onTick() {// Called every "Tick"
		long thisTime = System.currentTimeMillis();
		long newTime = thisTime + 100000;
		if ((newTime - thisTime) >= PERIOD) {
			return true;
		}

		return false;
	}

	public void drawHowToPlay(Graphics g, Font font) {
		g.setColor(color.WHITE);
		g.fillRect(0, 0, 1920, 1080);

		back.draw(g, new Font("courier", Font.PLAIN, 20));
		g.setColor(color.DARK_GRAY);
		g.setFont(new Font("courier", Font.BOLD, 120));
		g.drawString("HOW TO PLAY", dimX / 2 - (5 * 75), 125);

		g.setFont(new Font("courier", Font.BOLD, 20));
		g.setColor(color.BLACK);
		g.drawString(
				"The goal of Egyptian Ratscrew (ERS) is to obtain all 52 cards faster than the opponents. To set up the game, every player gets the same ",
				30, 240);
		g.drawString("amount of cards from a regular deck of cards.", 30, 270);
		g.drawString(
				"Since 52 does not evenly divide into every possible number of players, then the remainder will be distributed, starting from player 1.",
				30, 300);
		g.drawString("Each player is NOT allowed to look at each other's deck, including their own.", 30, 330);
		g.drawString(
				"In every round, each player takes turns to place a card, face side up, into the middle pile. Players keep on placing cards into the",
				30, 360);
		g.drawString("middle of the pile until the pile is eligible to be slapped.", 30, 390);

		g.setColor(Color.magenta);
		g.drawString("A pile is eligible to be slapped in many different instances:", 30, 465);
		g.setColor(Color.black);
		g.drawString("DOUBLE: the last two cards placed in the middle of the deck are the same number/face", 30, 495);
		g.drawString(
				"SANDWICH: the last three cards consist of the top and the 3rd top card being the same number/face, with any card in between",
				30, 525);
		g.drawString("ADD TO 10: the last two cards have the numbers add to 10", 30, 555);
		g.drawString(
				"SANDWICH 10: the last three cards consist of the top and 3rd top card adding to 10, with any card in between",
				30, 585);
		g.drawString("RED 10: a 10 of hearts or a 10 of diamonds", 30, 615);
		g.drawString(
				"3 CARD RUN: the last three cards are consecutive numbers/faces, does not have to be in order, and A and K are considered consecutive",
				30, 645);
		g.drawString("BOTTOM: the first card on the deck and the last card of the deck  are the same number/face", 30,
				675);
		g.drawString("MARRIAGE: the last two cards consist of any queen and any king, in any order", 30, 705);
		g.drawString(
				"*These rules are not dead set, and can be customized by clicking the Customized Rules button on the home screen*",
				30, 735);

		g.drawString(
				"The first/fastest player who slaps an eligible middle deck will get the middle deck added to their personal deck, and will draw first",
				30, 810);
		g.drawString(
				"the next round. If a player slaps the deck when the deck is not eligible, then they will get a penalty by having to drawa card and",
				30, 840);
		g.drawString("putting it on the bottom of the deck.", 30, 870);
		g.drawString(
				"This game is all about reaction time and it takes practice and experience to get better. I hope you have fun and thank you for reading!",
				30, 900);
	}

	public void drawCustomizeRules(Graphics g) {
		back.draw(g, new Font("courier", Font.PLAIN, 20));

		g.setColor(Color.black);
		g.setFont(new Font("courier", Font.BOLD, 40));
		g.drawString("Please select the boxes", 200, 60);
		g.drawString("of the rules you wish to play by.", 200, 100);
		dooble.drawText(g);
		sandwich.drawText(g);
		red10.drawText(g);
		addTo10.drawText(g);
		threeCardRun.drawText(g);
		sandwich10.drawText(g);
		bottoms.drawText(g);
		marriage.drawText(g);
	}

	public void drawCustomizeBackground(Graphics g) {
		back.draw(g, new Font("courier", Font.PLAIN, 20));

		g.setColor(Color.black);
		g.setFont(new Font("courier", Font.BOLD, 40));
		g.drawString("CUSTOMIZE BACKGROUND COLOR", 200, 60);

		red.display(g);
		orange.display(g);
		yellow.display(g);
		green.display(g);
		blue.display(g);
		purple.display(g);
		pink.display(g);
		black.display(g);
		gray.display(g);

	}

	public void drawCustomizePlayers(Graphics g) {
		back.draw(g, new Font("courier", Font.PLAIN, 20));

		g.setColor(Color.black);
		g.setFont(new Font("courier", Font.BOLD, 40));
		g.drawString("How many opponents?", 50, 150);

		one.display(g);
		two.display(g);
		three.display(g);

		g.setColor(Color.black);
		g.setFont(new Font("courier", Font.BOLD, 40));
		g.drawString("Opponents' slap speed?", 50, 375);

		slow.display(g);
		medium.display(g);
		fast.display(g);
		extreme.display(g);

		g.setColor(Color.black);
		g.setFont(new Font("courier", Font.BOLD, 40));
		g.drawString("What glove color would you like?", 800, 150);
		g.fillRect(795, 620, 150, 30);

		redGlove.display(g);
		orangeGlove.display(g);
		yellowGlove.display(g);
		greenGlove.display(g);
		blueGlove.display(g);
		purpleGlove.display(g);
		pinkGlove.display(g);
		blackGlove.display(g);
		grayGlove.display(g);
		whiteGlove.display(g);

	}

	public void drawPause(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRect(dimX / 2 - 400, dimY / 2 - 300, 800, 600);
		g.setColor(Color.WHITE);
		g.fillRect(dimX / 2 - 399, dimY / 2 - 299, 798, 598);
		g.setFont(new Font("courier", Font.BOLD, 50));
		g.setColor(Color.BLACK);
		if (activeScreen == 6) {
			g.drawString("Would You Like to Exit", dimX / 2 - (16 * 20), 350);
			g.drawString("or Resume?", dimX / 2 - (16 * 10), 400);
			exit.setX(500);
			resume.draw(g, new Font("courier", Font.BOLD, 40));
		}
		if (activeScreen == 7) {
			g.drawString("Error:", dimX / 2 - (3 * 40), 350);
			g.drawString("Not enough information", dimX / 2 - (11 * 30), 400);
			exit.setX(dimX / 2 - exit.getWidth());
		}
		exit.draw(g, new Font("courier", Font.BOLD, 40));
	}

	public void drawEnd(Graphics g, int n) {
		clock.stop();
		g.setColor(Color.GRAY);
		g.drawRect(dimX / 2 - 400, dimY / 2 - 300, 800, 600);
		g.setColor(Color.WHITE);
		g.fillRect(dimX / 2 - 399, dimY / 2 - 299, 798, 598);

		g.setFont(new Font("courier", Font.BOLD, 50));
		g.setColor(Color.BLACK);
		String winnerName = "Nobody";
		if (n == 1)
			winnerName = "You";
		if (n == 2)
			winnerName = "Player 2";
		if (n == 3)
			winnerName = "Player 3";
		if (n == 4)
			winnerName = "Player 4";
		g.drawString(winnerName + " Won!", dimX / 2 - (16 * 20), 350);
		g.drawString("Exit or Play Again?", dimX / 2 - (16 * 15), 400);
		exit.setX(500);
		exit.draw(g, new Font("courier", Font.BOLD, 40));
		playAgain.draw(g, new Font("courier", Font.BOLD, 40));
	}

	public void setPlayers() {
		middle = new CardDeck(true);

		// set the color of the players' gloves
		Color playerColor = Color.WHITE;
		if (redGloveSwitch)
			playerColor = Color.red;
		if (orangeGloveSwitch)
			playerColor = Color.orange;
		if (yellowGloveSwitch)
			playerColor = Color.yellow;
		if (greenGloveSwitch)
			playerColor = Color.green;
		if (blueGloveSwitch)
			playerColor = Color.blue;
		if (purpleGloveSwitch)
			playerColor = Color.magenta;
		if (pinkGloveSwitch)
			playerColor = Color.pink;
		if (blackGloveSwitch)
			playerColor = Color.black;
		if (grayGloveSwitch)
			playerColor = Color.gray;

		// set the level of the computers' gloves
		String speedLevel = "extreme";
		if (slowSwitch)
			speedLevel = "slow";
		if (mediumSwitch)
			speedLevel = "medium";
		if (fastSwitch)
			speedLevel = "fast";

		playerOne = new Player(playerColor);

		if (oneSwitch) {
			playerTwo = new Computer(playerColor, 1, speedLevel);
			middle.deal(middle, playerOne.getHand(), 26);
			middle.deal(middle, playerTwo.getHand(), 26);
		}
		if (twoSwitch) {
			playerTwo = new Computer(playerColor, 2, speedLevel);
			playerThree = new Computer(playerColor, 3, speedLevel);
			middle.deal(middle, playerOne.getHand(), 18);
			middle.deal(middle, playerTwo.getHand(), 17);
			middle.deal(middle, playerThree.getHand(), 17);
		}
		if (threeSwitch) {
			playerTwo = new Computer(playerColor, 2, speedLevel);
			playerThree = new Computer(playerColor, 1, speedLevel);
			playerFour = new Computer(playerColor, 3, speedLevel);
			middle.deal(middle, playerOne.getHand(), 13);
			middle.deal(middle, playerTwo.getHand(), 13);
			middle.deal(middle, playerThree.getHand(), 13);
			middle.deal(middle, playerFour.getHand(), 13);
		}
	}

	public boolean isAWinner(CardDeck d) {
		int rules = 0;
		if (middle.isDouble())
			rules++;
		if (middle.isFamily())
			rules++;
		if (middle.isMarriage())
			rules++;
		if (middle.isRed10())
			rules++;
		if (middle.isSandwich())
			rules++;
		if (middle.isSandwich10())
			rules++;
		if (middle.isBottoms())
			rules++;
		if (middle.isSum10())
			rules++;
		if (rules > 0) {
			return true;
		}
		return false;
	}

	private class PanelListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {

			int clickX = e.getX();
			int clickY = e.getY();

			// check if all the requirements to run the game is good, check needs to be at
			// least 3 to be able to play the game correctly
			int check = 0;
			if (doobleDraw)
				check++;
			if (sandwichDraw)
				check++;
			if (red10Draw)
				check++;
			if (addTo10Draw)
				check++;
			if (threeCardRunDraw)
				check++;
			if (sandwich10Draw)
				check++;
			if (bottomsDraw)
				check++;
			if (marriageDraw)
				check++;
			if (oneSwitch)
				check++;
			if (twoSwitch)
				check++;
			if (threeSwitch)
				check++;
			if (slowSwitch)
				check++;
			if (mediumSwitch)
				check++;
			if (fastSwitch)
				check++;
			if (extremeSwitch)
				check++;

			// Home Screen Button Clicking and Back Clicking
			if (activeScreen == 0 && howToPlay.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 2;
				active = true;
			}
			if (activeScreen == 0 && customizeRules.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 3;
				active = true;
			}
			if (activeScreen == 0 && customizeBackground.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 4;
				active = true;
			}
			if (activeScreen == 0 && customizePlayers.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 5;
				active = true;
			}
			if (active == true && back.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 0;
			}

			// Play and PauseScreen Button Clicking
			if (activeScreen == 0 && play.checkIfInsideButton(clickX, clickY)) {
				if (check < 3) {
					activeScreen = 7;
				} else {
					activeScreen = 1;
					active = false;
					clock.reset();
					clock.start();
				}
			}
			if (activeScreen == 1 && pause.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 6;
				clock.stop();
			}
			if (activeScreen == 6 && resume.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 1;
				active = false;
				clock.start();
			}
			if (activeScreen == 6 && exit.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 0;
				active = false;
				didDeal = false;
				clock.stop();
				clock.reset();
			}
			if (activeScreen == 7 && exit.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 0;
			}
			if (activeScreen == 8 && playAgain.checkIfInsideButton(clickX, clickY)) {
				activeScreen = 1;
				active = false;
				clock.reset();
				clock.start();
			}

			// Customize Rules Clicking
			if (activeScreen == 3) {
				if (dooble.checkIfInside(clickX, clickY)) {
					doobleDraw = !doobleDraw;
				}
				if (sandwich.checkIfInside(clickX, clickY)) {
					sandwichDraw = !sandwichDraw;
				}
				if (addTo10.checkIfInside(clickX, clickY)) {
					addTo10Draw = !addTo10Draw;
				}
				if (threeCardRun.checkIfInside(clickX, clickY)) {
					threeCardRunDraw = !threeCardRunDraw;
				}
				if (red10.checkIfInside(clickX, clickY)) {
					red10Draw = !red10Draw;
				}
				if (sandwich10.checkIfInside(clickX, clickY)) {
					sandwich10Draw = !sandwich10Draw;
				}
				if (bottoms.checkIfInside(clickX, clickY)) {
					bottomsDraw = !bottomsDraw;
				}
				if (marriage.checkIfInside(clickX, clickY)) {
					marriageDraw = !marriageDraw;
				}
			}

			// Background Color Clicking
			if (activeScreen == 4) {
				if (red.checkIfInside(clickX, clickY)) {
					redSwitch = !redSwitch;
					orangeSwitch = false;
					yellowSwitch = false;
					greenSwitch = false;
					blueSwitch = false;
					purpleSwitch = false;
					pinkSwitch = false;
					blackSwitch = false;
					graySwitch = false;
				}
				if (orange.checkIfInside(clickX, clickY)) {
					orangeSwitch = !orangeSwitch;
					redSwitch = false;
					yellowSwitch = false;
					greenSwitch = false;
					blueSwitch = false;
					purpleSwitch = false;
					pinkSwitch = false;
					blackSwitch = false;
					graySwitch = false;
				}
				if (yellow.checkIfInside(clickX, clickY)) {
					yellowSwitch = !yellowSwitch;
					redSwitch = false;
					orangeSwitch = false;
					greenSwitch = false;
					blueSwitch = false;
					purpleSwitch = false;
					pinkSwitch = false;
					blackSwitch = false;
					graySwitch = false;
				}
				if (green.checkIfInside(clickX, clickY)) {
					greenSwitch = !greenSwitch;
					redSwitch = false;
					orangeSwitch = false;
					yellowSwitch = false;
					blueSwitch = false;
					purpleSwitch = false;
					pinkSwitch = false;
					blackSwitch = false;
					graySwitch = false;
				}
				if (blue.checkIfInside(clickX, clickY)) {
					blueSwitch = !blueSwitch;
					redSwitch = false;
					orangeSwitch = false;
					yellowSwitch = false;
					greenSwitch = false;
					purpleSwitch = false;
					pinkSwitch = false;
					blackSwitch = false;
					graySwitch = false;
				}
				if (purple.checkIfInside(clickX, clickY)) {
					purpleSwitch = !purpleSwitch;
					redSwitch = false;
					orangeSwitch = false;
					yellowSwitch = false;
					greenSwitch = false;
					blueSwitch = false;
					pinkSwitch = false;
					blackSwitch = false;
					graySwitch = false;
				}
				if (pink.checkIfInside(clickX, clickY)) {
					pinkSwitch = !pinkSwitch;
					redSwitch = false;
					orangeSwitch = false;
					yellowSwitch = false;
					greenSwitch = false;
					blueSwitch = false;
					purpleSwitch = false;
					blackSwitch = false;
					graySwitch = false;
				}
				if (black.checkIfInside(clickX, clickY)) {
					blackSwitch = !blackSwitch;
					redSwitch = false;
					orangeSwitch = false;
					yellowSwitch = false;
					greenSwitch = false;
					blueSwitch = false;
					purpleSwitch = false;
					pinkSwitch = false;
					graySwitch = false;
				}
				if (gray.checkIfInside(clickX, clickY)) {
					graySwitch = !graySwitch;
					redSwitch = false;
					orangeSwitch = false;
					yellowSwitch = false;
					greenSwitch = false;
					blueSwitch = false;
					purpleSwitch = false;
					pinkSwitch = false;
					blackSwitch = false;
				}
			}

			// Player Clicking
			if (activeScreen == 5) {
				if (one.checkIfInside(clickX, clickY)) {
					Computer.setNumPlayers(2);
					oneSwitch = true;
					twoSwitch = false;
					threeSwitch = false;
				}
				if (two.checkIfInside(clickX, clickY)) {
					Computer.setNumPlayers(3);
					twoSwitch = true;
					oneSwitch = false;
					threeSwitch = false;
				}
				if (three.checkIfInside(clickX, clickY)) {
					Computer.setNumPlayers(4);
					threeSwitch = true;
					oneSwitch = false;
					twoSwitch = false;
				}

				if (slow.checkIfInside(clickX, clickY)) {
					slowSwitch = true;
					mediumSwitch = false;
					fastSwitch = false;
					extremeSwitch = false;
				}
				if (medium.checkIfInside(clickX, clickY)) {
					mediumSwitch = true;
					slowSwitch = false;
					fastSwitch = false;
					extremeSwitch = false;
				}
				if (fast.checkIfInside(clickX, clickY)) {
					fastSwitch = true;
					slowSwitch = false;
					mediumSwitch = false;
					extremeSwitch = false;
				}
				if (extreme.checkIfInside(clickX, clickY)) {
					extremeSwitch = true;
					slowSwitch = false;
					mediumSwitch = false;
					fastSwitch = false;
				}
				if (redGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = true;
					orangeGloveSwitch = false;
					yellowGloveSwitch = false;
					greenGloveSwitch = false;
					blueGloveSwitch = false;
					purpleGloveSwitch = false;
					pinkGloveSwitch = false;
					blackGloveSwitch = false;
					grayGloveSwitch = false;
					whiteGloveSwitch = false;
				}
				if (orangeGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = true;
					yellowGloveSwitch = false;
					greenGloveSwitch = false;
					blueGloveSwitch = false;
					purpleGloveSwitch = false;
					pinkGloveSwitch = false;
					blackGloveSwitch = false;
					grayGloveSwitch = false;
					whiteGloveSwitch = false;
				}
				if (yellowGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = false;
					yellowGloveSwitch = true;
					greenGloveSwitch = false;
					blueGloveSwitch = false;
					purpleGloveSwitch = false;
					pinkGloveSwitch = false;
					blackGloveSwitch = false;
					grayGloveSwitch = false;
					whiteGloveSwitch = false;
				}
				if (greenGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = false;
					yellowGloveSwitch = false;
					greenGloveSwitch = true;
					blueGloveSwitch = false;
					purpleGloveSwitch = false;
					pinkGloveSwitch = false;
					blackGloveSwitch = false;
					grayGloveSwitch = false;
					whiteGloveSwitch = false;
				}
				if (blueGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = false;
					yellowGloveSwitch = false;
					greenGloveSwitch = false;
					blueGloveSwitch = true;
					purpleGloveSwitch = false;
					pinkGloveSwitch = false;
					blackGloveSwitch = false;
					grayGloveSwitch = false;
					whiteGloveSwitch = false;
				}
				if (purpleGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = false;
					yellowGloveSwitch = false;
					greenGloveSwitch = false;
					blueGloveSwitch = false;
					purpleGloveSwitch = true;
					pinkGloveSwitch = false;
					blackGloveSwitch = false;
					grayGloveSwitch = false;
					whiteGloveSwitch = false;
				}
				if (pinkGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = false;
					yellowGloveSwitch = false;
					greenGloveSwitch = false;
					blueGloveSwitch = false;
					purpleGloveSwitch = false;
					pinkGloveSwitch = true;
					blackGloveSwitch = false;
					grayGloveSwitch = false;
					whiteGloveSwitch = false;
				}
				if (blackGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = false;
					yellowGloveSwitch = false;
					greenGloveSwitch = false;
					blueGloveSwitch = false;
					purpleGloveSwitch = false;
					pinkGloveSwitch = false;
					blackGloveSwitch = true;
					grayGloveSwitch = false;
					whiteGloveSwitch = false;
				}
				if (grayGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = false;
					yellowGloveSwitch = false;
					greenGloveSwitch = false;
					blueGloveSwitch = false;
					purpleGloveSwitch = false;
					pinkGloveSwitch = false;
					blackGloveSwitch = false;
					grayGloveSwitch = true;
					whiteGloveSwitch = false;
				}
				if (whiteGlove.checkIfInside(clickX, clickY)) {
					redGloveSwitch = false;
					orangeGloveSwitch = false;
					yellowGloveSwitch = false;
					greenGloveSwitch = false;
					blueGloveSwitch = false;
					purpleGloveSwitch = false;
					pinkGloveSwitch = false;
					blackGloveSwitch = false;
					grayGloveSwitch = false;
					whiteGloveSwitch = true;
				}
			}

		}

		public void mouseReleased(MouseEvent e) {

		}
	}

	private class Controls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// place card down
			if (e.getKeyCode() == KeyEvent.VK_ENTER && turn == 1) {
				putdown = 3;
				middle.add(playerOne.getHand().getDeck().remove(playerOne.getHand().getDeck().size() - 1));
				repaint();
			}
			// slap
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				playerOne.setX((int) (Math.random() * 40) + 720);
				playerOne.setY((int) (Math.random() * 40) + 450);
				repaint();

				if (isAWinner(middle)) {
					goodSlap = true;
				} else {
					badSlap = true;
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			goodSlap = false;
			badSlap = false;
			playerOne.setX(780);
			playerOne.setY(870);
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}

	public ClockTimer getClock() {
		return clock;
	}

	public void setClock(ClockTimer clock) {
		this.clock = clock;
	}

}