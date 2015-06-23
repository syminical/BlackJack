
//theworldisquiethere

import java.util.ArrayList;

public class Deck {

	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {

		buildDeck();

	}

	private void buildDeck() {

		boolean checker = false;

		while (deck.size() < 25) {

			checker = false;
	
			Card temp = newCard();

			for (int i = 0; i < deck.size(); i++)

				if (deck.get(i).equals(temp))

					checker = true;

			if (!checker)

				deck.add(temp);

		}

	}

	private Card newCard() {

		return new Card( ((int)(Math.random() * 4)), ((int)(Math.random() * 13) + 1) );

	}	

	public Card drawCard() {

		Card temp = new Card(deck.get(0).getSuit(), deck.get(0).getValue());

		deck.remove(0);

		return temp;

	}

}

