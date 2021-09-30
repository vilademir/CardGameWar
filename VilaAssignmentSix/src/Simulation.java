import javax.swing.JOptionPane;

public class Simulation {
	//data
	int totalAmountOfGames;
	int totalNumberOfRounds;
	int totalAmountOfWars;
	int totalAmountOfDoubleWars;
	int maxRounds;
	int minRounds;
	int maxWars;
	int minWars;
	int averageRounds;
	int averageWars;
	int averageDoubleWars;
	
	public Simulation(int numberOfGames) {    //constructor
		totalAmountOfGames = numberOfGames;
		totalNumberOfRounds = 0;
		totalAmountOfWars = 0;
		totalAmountOfDoubleWars = 0;
		maxRounds = Integer.MIN_VALUE;
		minRounds = Integer.MAX_VALUE;
		maxWars = Integer.MIN_VALUE;
		minWars = Integer.MAX_VALUE;
	}
	
	public static void main (String[] args) { 			//main to call the functions of the game
		String askForInput = JOptionPane.showInputDialog("How many games would you like to run?");
		int numberOfGames = Integer.parseInt(askForInput);
		
		Simulation runGame = new Simulation(numberOfGames);
		
		runGame.simulate();
		runGame.calculate();
		runGame.report();
	}
	
	public void simulate() {					//runs the game in order to get the data
		for(int x = 0; x < totalAmountOfGames; x++) {
			Game newGame = new Game();
			newGame.play();
			
			totalNumberOfRounds += newGame.getNumberOfBattles();
			totalAmountOfWars += newGame.getNumberOfWars();
			totalAmountOfDoubleWars += newGame.getNumberOfDoubleWars();
			
			if(newGame.getNumberOfBattles() < minRounds) {
				minRounds = newGame.getNumberOfBattles();
			}
			if(newGame.getNumberOfBattles() > maxRounds) {
				maxRounds = newGame.getNumberOfBattles();
			}
			if (newGame.getNumberOfWars() < minWars) {
				minWars = newGame.getNumberOfWars();
			}
			if(newGame.getNumberOfWars() > maxWars) {
				maxWars = newGame.getNumberOfWars();
			}
			
		}
	}
	
	public void calculate() {							//does the math for averages of each aspect of teh game
		averageRounds = (totalNumberOfRounds / totalAmountOfGames);
		averageWars = (totalAmountOfWars / totalAmountOfGames);
		averageDoubleWars = (totalAmountOfDoubleWars / totalAmountOfGames);
	}
	
	public void report() {						//prints out the end data of the game
		System.out.println("====== For " + totalAmountOfGames + " Games ======");
		System.out.println("Average battles per game: " + averageRounds);
		System.out.println("Average wars per game: " + averageWars);
		System.out.println("Average Double Wars per game: " + averageDoubleWars);
		System.out.println("Max battles in a game: " + maxRounds);
		System.out.println("Min battles in a game: " + minRounds);
		System.out.println("Max wars in a game: " + maxWars);
		System.out.println("Min wars in a game: " + minWars);
	}
}
