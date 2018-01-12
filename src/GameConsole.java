import java.util.Scanner;

/** 
 *  Play guessing game on the console that have the rule you should guessing number until you guess it right.
 *  @author Thanakrit Daowrueang.
 */
public class GameConsole {


	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game.toString());

		// This is just an example.
		System.out.println(game.getMessage());

		int guess;

		do {
			System.out.print("Your answer? ");

			guess = console.nextInt();
			boolean correct = game.guess(guess);
			System.out.println(game.getMessage());

			if (correct == true) break;
			if (correct == false) continue;


		} while (true);

		return guess;
	}
	
}
