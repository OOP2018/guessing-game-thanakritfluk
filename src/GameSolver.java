import java.util.Scanner;
import java.util.Random;
/**
 * Automatically find the secret to any NumberGame.
 */
public class GameSolver {


    public int play (NumberGame game){

        Scanner console = new Scanner(System.in);

        // describe the game
        System.out.println(game.toString());

        // This is just an example.
        System.out.println(game.getMessage());

        int guess;
        guess = game.getUpperBound();

        do {
            Random rand = new Random();
            System.out.println("Your answer? "+guess);


            boolean correct = game.guess(guess);
            System.out.println(game.getMessage());

            if (correct == true) break;
            if (correct == false)
                if (game.getMessage().equals("You guess is too small")) guess += 2;
                if (game.getMessage().equals("You guess is too large")) guess -= 3;

        } while (true);

        return guess;

    }
}
