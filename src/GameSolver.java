import java.util.Scanner;
import java.util.Random;
/**
 * Automatically find the secret to any NumberGame.
 * @author Thanakrit Daowrueang.
 */
public class GameSolver {

    Random ran =new Random();

    public int play (NumberGame game){

        Scanner console = new Scanner(System.in);

        // describe the game
        System.out.println(game.toString());

        // This is just an example.
        System.out.println(game.getMessage());

        int guess;

        guess = ran.nextInt(game.getUpperBound());

        do {
            Random rand = new Random();
            System.out.println("Your answer? "+guess);


            boolean correct = game.guess(guess);
            System.out.println(game.getMessage());

            if (correct == true) break;
            if (correct == false) {
                if (game.getMessage().contains("too small")) guess += 3;
                if (game.getMessage().contains("too large")) guess -= 5;
            }
        } while (true);

        return guess;

    }
}
