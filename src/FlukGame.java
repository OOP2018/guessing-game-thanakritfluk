import java.util.Random;

/**
 * Game of guessing a secret number that have range 0 - upperbound that user set.
 * @author Thanakrit Daowrueang.
 */

public class FlukGame extends NumberGame {
    private int upperBound;
    private int secret;
    private int guesse;

    public FlukGame(int upperBound) {
        this.upperBound = upperBound;
        Random rand = new Random();
        this.secret = rand.nextInt(upperBound) + 0;
        super.setMessage("I'm thinking of a number between 1 to " + upperBound);
    }

    @Override
    public boolean guess(int number) {
        guesse += 1;
        if (number < 0) super.setMessage("Guess number can't less than 0");
        if (number < secret) super.setMessage("You guess is too small");
        if (number > secret) super.setMessage("You guess is too large");
        if (number == secret) super.setMessage("*** You win ****");
        if (number == secret) return true;
        else return false;
    }

    @Override
    public int getUpperBound(){
        return upperBound;
    }

    @Override
    public String toString(){
    return "This game is guessing the secret number between 0 and " + upperBound;
    }

    @Override
    public int getCount(){
       return guesse;
    }


}