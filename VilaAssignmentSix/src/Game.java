import java.util.LinkedList;

public class Game {
	//variables being created
	int numberOfBattles;
	int numberOfWars;
	int numberOfDoubleWars;
	int gameWins;
	
	Deck deck;
	Player firstPlayer;
	Player secondPlayer;
	
	LinkedList <Card> firstPlayerStack = new LinkedList<Card>();
	LinkedList <Card> secondPlayerStack = new LinkedList<Card>();
	

	public Game() {       //constructor
		numberOfBattles = 0;
		numberOfWars = 0;
		numberOfDoubleWars = 0;
		gameWins = 0;
		
		deck = new Deck();
		
		firstPlayer = new Player(1);
		secondPlayer = new Player(2);

	}
	
	public int getNumberOfBattles() {
		return numberOfBattles;
	}
	
	public int getNumberOfWars() {
		return numberOfWars;
	}
	
	public int getNumberOfDoubleWars() {
		return numberOfDoubleWars;
	}
	
	public int getGameWins() {
		return gameWins;
	}
	
	public void play() {                                 //game is being played
		while(deck.getSize() > 0) {
			firstPlayer.collect(deck.deal());
			secondPlayer.collect(deck.deal());
		}
		
		while (gameWins == 0) {
			firstPlayerStack.addFirst(firstPlayer.flip());
			secondPlayerStack.addFirst(secondPlayer.flip());
			
			int winnerOfRound = firstPlayerStack.getFirst().cardComparison(secondPlayerStack.getFirst());
			numberOfBattles++;
			
			if(winnerOfRound == 0) {
				numberOfWars++;							//counter
				winnerOfRound = war();				
			}
			
			int randomOrder = (int)(Math.random() * 2);                  //randomizer
			
			if (winnerOfRound > 0) {
				if (randomOrder == 1) {
					firstPlayer.cardCollection(firstPlayerStack);
					firstPlayer.cardCollection(secondPlayerStack);
				}
				else {
					firstPlayer.cardCollection(secondPlayerStack);
					firstPlayer.cardCollection(firstPlayerStack);
				}
			}
				else if (winnerOfRound < 0) {
					if(randomOrder == 1) {
						secondPlayer.cardCollection(firstPlayerStack);
						secondPlayer.cardCollection(secondPlayerStack);
					}
					else {
						secondPlayer.cardCollection(secondPlayerStack);
						secondPlayer.cardCollection(firstPlayerStack);
					}
				}
			if(firstPlayer.hasWon()) {
				gameWins = 1;
			}
			else if (secondPlayer.hasWon()) {
				gameWins = 2;
			}
		}	
	}
	
	private int war() {									//method to initiate war if cards are the same
		for(int x = 0; firstPlayer.getNumberOfCards() > 0 && x < 4; x++) {
			firstPlayerStack.addFirst(firstPlayer.flip());
		}
		for (int y = 0; secondPlayer.getNumberOfCards() > 0 && y < 4; y++) {
			secondPlayerStack.addFirst(secondPlayer.flip());
		}
		
		int winnerOfWar = firstPlayerStack.getFirst().cardComparison(secondPlayerStack.getFirst());
		
		if (winnerOfWar == 0) {
			numberOfDoubleWars++;
			winnerOfWar = war();
		}
		
		return winnerOfWar;
	}
	
}
