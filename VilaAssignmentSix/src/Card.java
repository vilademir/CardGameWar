
public class Card {
	
	private int suit;
	private int cardType;
	
	public Card(int suit, int cardType) {              //constructor
		this.suit = suit;
		this.cardType = cardType;	
	}	
	
	public int getSuit() {						
		return suit;
	}
	
	public int getCardType() {
		return cardType;
	}
	
	public int cardComparison(Card compareCard) {            //compares the two flipped cards to each other
		if (cardType > compareCard.getCardType()) {
			return 1;
		}
		else if (cardType < compareCard.getCardType()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
