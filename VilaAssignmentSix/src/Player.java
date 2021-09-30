import java.util.LinkedList;

public class Player {
	int playerNumber;
	LinkedList<Card> yourCards;
	
	public Player(int playerNumber) {    			//constructor
		this.playerNumber = playerNumber;
		yourCards = new LinkedList<Card>();
	}
	public Card flip() {						//removes cards from the deck that each player has
		return yourCards.removeFirst();
	}
	
	public void collect(Card newCard) {			//adds cards to the deck
		yourCards.addLast(newCard);
	}
	
	public int getNumberOfCards() {
		return yourCards.size();
	}
	
	public boolean hasWon() {				//boolean to determine if the game is won or not 
		if(yourCards.size() >= 52) {
			return true;
		}
		return false;
	}
	
	public void cardCollection(LinkedList<Card> stack) {        
		while(stack.size() > 0) {
			collect(stack.removeFirst());
		}
	}
}
