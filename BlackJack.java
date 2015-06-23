
//theworldisquiethere

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJack extends JFrame {
	

	
	private Deck deck = new Deck();

	private String playerCards = "", dealerCards = "", playerCards2 = "<html>" + playerCards + "</html>", dealerCards2 = "<html>" + dealerCards + "</html>";

	private int pScore = 0, dScore = 0, pAces = 0, dAces = 0;

	private Card temp;

	private static JFrame box;
	
	private JPanel atlas = new JPanel();
	private JPanel scoreContainer = new JPanel();
	private JPanel playerHandContainer = new JPanel();
	private JPanel dealerHandContainer = new JPanel();
	private JPanel playerContainer = new JPanel();
	private JPanel dealerContainer = new JPanel();
	private JPanel menuContainer = new JPanel();
	private JPanel buttonContainer = new JPanel();
	private JPanel lButtonContainer = new JPanel();
	private JPanel rButtonContainer = new JPanel();
	
	private JLabel playerScore = new JLabel("player: ");
	private JLabel playerScore2 = new JLabel("" + pScore);
	private JLabel dealerScore = new JLabel("dealer: ");
	private JLabel dealerScore2 = new JLabel("" + dScore);
	private JLabel scoreSpacer = new JLabel("                   ");
	private JLabel playerHand = new JLabel("P:");
	private JLabel playerHand2 = new JLabel(playerCards2);
	private JLabel dealerHand = new JLabel("D:");
	private JLabel dealerHand2 = new JLabel(dealerCards2);
	private JLabel comment1 = new JLabel("neither  ");
	private JLabel comment2 = new JLabel("  wins!");
	private JLabel againButton = new JLabel("again?");
	private JLabel hitButton = new JLabel("hit!");
	private JLabel buttonSpacer = new JLabel("             ");
	private JLabel stayButton = new JLabel("stay");
	private Border fencing = BorderFactory.createLineBorder(Color.GREEN, 1);	

	public BlackJack() {

		super("Black Jack");

		addListeners();

		buildComponents();

		buildContainers();
		
		buildAtlas();

		buildABox();

	}

	private void addListeners() {

		againButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				again();
			
			}

		});

		hitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
				hit();

			}

		});

		stayButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				stay();

			}

		});

	}

	private void buildComponents() {
	
		scoreContainer.setOpaque(false);
		playerHandContainer.setOpaque(false);
		dealerHandContainer.setOpaque(false);
		playerContainer.setOpaque(false);
		dealerContainer.setOpaque(false);
		menuContainer.setOpaque(false);
		buttonContainer.setOpaque(false);
		lButtonContainer.setOpaque(false);
		rButtonContainer.setOpaque(false);
		playerScore.setOpaque(false);
		playerScore2.setOpaque(false);
		dealerScore.setOpaque(false);
		dealerScore2.setOpaque(false);
		scoreSpacer.setOpaque(false);
		playerHand.setOpaque(false);
		playerHand2.setOpaque(false);
		dealerHand.setOpaque(false);
		dealerHand2.setOpaque(false);
		comment1.setOpaque(false);
		comment2.setOpaque(false);
		againButton.setOpaque(false);
		hitButton.setOpaque(false);
		buttonSpacer.setOpaque(false);
		stayButton.setOpaque(false);

		playerScore.setForeground(Color.GREEN);
		playerScore2.setForeground(Color.GREEN);
		dealerScore.setForeground(Color.GREEN);
		dealerScore2.setForeground(Color.GREEN);
		playerHand.setForeground(Color.GREEN);
		playerHand2.setForeground(Color.GREEN);
		dealerHand.setForeground(Color.GREEN);
		dealerHand2.setForeground(Color.GREEN);
		comment1.setForeground(Color.GREEN);
		comment2.setForeground(Color.GREEN);
		againButton.setForeground(Color.GREEN);
		hitButton.setForeground(Color.GREEN);
		stayButton.setForeground(Color.GREEN);

		againButton.setBorder(fencing);
		hitButton.setBorder(fencing);
		stayButton.setBorder(fencing);

		menuContainer.setVisible(false);

	}

	private void buildContainers() {
	
		playerContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		playerContainer.add(playerScore);
		playerContainer.add(playerScore2);

		dealerContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		dealerContainer.add(dealerScore);
		dealerContainer.add(dealerScore2);
		
		scoreContainer.add(playerContainer);
		scoreContainer.add(scoreSpacer);
		scoreContainer.add(dealerContainer);

		playerHandContainer.add(playerHand);
		playerHandContainer.add(playerHand2);

		dealerHandContainer.add(dealerHand);
		dealerHandContainer.add(dealerHand2);

		menuContainer.add(comment1);
		menuContainer.add(againButton);
		menuContainer.add(comment2);

		lButtonContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
		lButtonContainer.add(stayButton);
		
		rButtonContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		rButtonContainer.add(hitButton);

		buttonContainer.add(lButtonContainer);
		buttonContainer.add(buttonSpacer);
		buttonContainer.add(rButtonContainer);

	};

	private void buildAtlas() {
	
		atlas.setBackground(Color.BLACK);
		atlas.setForeground(Color.GREEN);

		atlas.setLayout(new BoxLayout(atlas, BoxLayout.Y_AXIS));
		
		atlas.add(scoreContainer);
		atlas.add(playerHandContainer);
		atlas.add(menuContainer);
		atlas.add(dealerHandContainer);
		atlas.add(buttonContainer);

	}

	private void buildABox() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(atlas);
		setContentPane(atlas);
		getContentPane().setPreferredSize(new Dimension(294, 156));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private String faceWrapper(int container) {

		if (container == 1)

			return "A";
		
		else if (container == 11)

			return "J";

		else if (container == 12)

			return "Q";

		else if (container == 13)

			return "K";

		else

			return "" + container;

	}

	private String wrapCard(Card container) {

		if (container.getSuit() == 0) {

			return " <font color = red>[ " + faceWrapper(container.getValue()) + " ]</font>";

		} else if (container.getSuit() == 1) {

			return " <font color = orange>[ " + faceWrapper(container.getValue()) + " ]</font>";

		} else if (container.getSuit() == 2) {
		
			return " <font color = yellow>[ " + faceWrapper(container.getValue()) + " ]</font>";

		} else if (container.getSuit() == 3) {

			return " <font color = #00BFFF>[ " + faceWrapper(container.getValue()) + " ]</font>";

		} else {

			return " <font color = white>[ " + faceWrapper(container.getValue()) + " ]</font>";

		}

	}

	private int valueWrapper(int container) {

		if (container == 1)

			return 11;

		else if (container > 10)

			return 10;

		else 

			return container;

	}

	private boolean checkScores() {

		if (pScore > 21) {

			if (dScore <= 21)

				comment1.setText("dealer  ");

			return true;

		} else if (dScore > 21) {

			 if (pScore <= 21)

				comment1.setText("player  ");

			return true;

		} else if (pScore == 21) {

			comment1.setText("player  ");

			return true;

		} else if (dScore == 21) {

			comment1.setText("dealer  ");

			return true;

		}

		return false;

	}

	private void checkScores2() {

		if (!checkScores())

			if (pScore > dScore)

				comment1.setText("player  ");

			else if (dScore > pScore)

				comment1.setText("dealer  ");
			
	}

	private void again() {

		menuContainer.setVisible(false);

		pScore = 0;
		pAces = 0;
		dScore = 0;
		dAces = 0;

		comment1.setText("neither  ");

		playerCards = "";
		dealerCards = "";

		playerHand2.setText("");
		dealerHand2.setText("");

		playerScore2.setText("" + 0);
		dealerScore2.setText("" + 0);

		deck = new Deck();
	
	}

	private void hit() {

		if (pScore < 21 && dScore < 21 && !menuContainer.isVisible()) {
	
			temp = deck.drawCard();

			pScore += valueWrapper(temp.getValue());

			if (temp.getValue() == 1)

				pAces++;

			if (pScore > 21)

				if (pAces > 0) {

					while (pScore > 21 && pAces > 0) {

						pScore -= 10;

						pAces--;

					}

				}

			playerCards += wrapCard(temp);

			playerCards2 = "<html>" + playerCards + "</html>";

			playerHand2.setText(playerCards2);

			playerScore2.setText("" + pScore);

			if (dScore < 17) {
	
				temp = deck.drawCard();

				dScore += valueWrapper(temp.getValue());

				if (temp.getValue() == 1)

					dAces++;


				if (dScore > 21)

					if (dAces > 0) {

						while (dScore > 21 && dAces > 0) {

							dScore -= 10;

							dAces--;

						}

					}

				dealerCards += wrapCard(temp);
	
				dealerCards2 = "<html>" + dealerCards + "</html>";

				dealerHand2.setText(dealerCards2);

				dealerScore2.setText("" + dScore);

			}

			if (checkScores())
	
				menuContainer.setVisible(true);

		}
	}

	private void stay() {

		if (!menuContainer.isVisible()) {

			while (dScore < 17) {

				temp = deck.drawCard();

				dScore += valueWrapper(temp.getValue());

				if (temp.getValue() == 1)

					dAces++;


				if (dScore > 21)

					if (dAces > 0) {

						while (dScore > 21 && dAces > 0) {

							dScore -= 10;

							dAces--;

						}

					}

				dealerCards += wrapCard(temp);
		
				dealerCards2 = "<html>" + dealerCards + "</html>";

				dealerHand2.setText(dealerCards2);

				dealerScore2.setText("" + dScore);

			}

			checkScores2();

			menuContainer.setVisible(true);

		}

	}

	public static void main(String args[]) {

		box = new BlackJack();

	}

}

