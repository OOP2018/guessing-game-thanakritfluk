/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 * @author Thanakrit Daowrueang.
 */
public class Main {

	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 1;
		NumberGame game = new FlukGame(upperBound);
		GameSolver ui = new GameSolver();
		int solution = ui.play( game );

		System.out.println("play() returned " + solution);
		System.out.println("Guess time: " + game.getCount());

	}
}
