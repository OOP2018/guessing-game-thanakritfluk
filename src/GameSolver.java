/**
 * Automatically find the secret to any NumberGame.
 * @author Thanakrit Daowrueang.
 */
public class GameSolver {

    /**
     * This play a numbergame automatically and return the solution of the secrect number.
     * The NumberGame should return the phrase that contain "large" and "small",for good solution.
     * @param game is an object to solve in this class.
     * @return result of the game
     */

    public int play (NumberGame game){
        int guess,max = game.getUpperBound(),min = 0;
        do {
            guess = min + ((max - min) / 2);
            boolean correct = game.guess(guess);
            if (correct == true){
                break;
            }
            else{
                if (game.getMessage().contains("large")) max = guess - 1;
                else if (game.getMessage().contains("small")) min = guess + 1;
                else {
                    System.out.println("System error terminated");
                    System.exit(1);
                }
            }

        } while (true);
       return guess;

    }
}
