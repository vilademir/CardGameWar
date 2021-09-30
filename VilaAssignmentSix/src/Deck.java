import java.util.LinkedList;

public class Deck {
	LinkedList<Card> deck;
	
	public Deck(){
		deck = new LinkedList<Card>();				//creates a new list
		for(int suit = 1; suit <= 4; suit++) {
			for(int cardType = 2; cardType <= 14; cardType++) {
				deck.addLast(new Card(suit, cardType));
			}
		}
	}
	
	public Card deal() {
		int dealCards = (int)(deck.size() * Math.random());
		return deck.remove(dealCards);					//removes cards from the deck that is being dealt
	}
	
	public int getSize() {
		return deck.size();
	}
}
