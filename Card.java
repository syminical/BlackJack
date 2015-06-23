
//theworldisquiethere

public class Card {

	private int suit, value;

	public Card(int container1, int container2) {
	
		suit = container1;
	
		value = container2;

	}

	public int getSuit() {

		return suit;

	}

	public int getValue() {

		return value;

	}

	public boolean equals(Object container) {

		if (container instanceof Card) {

			Card temp = (Card)container;

			if (this.suit == temp.suit && this.value == temp.value)

				return true;

			else

				return false;

		} else

			return false;

	}

}

