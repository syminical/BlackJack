
//theworldisquiethere

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJack extends JFrame {

	

	private static JFrame box;
	
	private String playerCards = "<font color = red>[1]</font> <font color = orange>[2]</font> <font color = yellow>[3]</font> <font color = #00BFFF>[4]</font>", dealerCards = "";

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
	private JLabel playerScore2 = new JLabel("0");
	private JLabel dealerScore = new JLabel("dealer: ");
	private JLabel dealerScore2 = new JLabel("0");
	private JLabel scoreSpacer = new JLabel("                   ");
	private JLabel playerHand = new JLabel("P: ");
	private JLabel playerHand2 = new JLabel("<html>" + playerCards + "</html>");
	private JLabel dealerHand = new JLabel("D: ");
	private JLabel dealerHand2 = new JLabel("<html>" + dealerCards + "</html>");
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

		//update();

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

	private void update() {

		double start = 0, end = 0;

		start = System.currentTimeMillis();

		againButton.setText("height: " + atlas.getHeight() + " : width: " + atlas.getWidth());

		end = System.currentTimeMillis();

		try {
		
			Thread.sleep(5000 - (int)(end - start));

		} catch (Exception e) {

			System.out.println("SOMEtING WNT WONG");

		}

		update();

	}

	private void again() {
	
		playerScore2.setText("again");
	
	}

	private void hit() {

		playerScore2.setText("hit");

	}

	private void stay() {

		againButton.setText("stay");

	}

	public static void main(String args[]) {

		box = new BlackJack();

	}

}

