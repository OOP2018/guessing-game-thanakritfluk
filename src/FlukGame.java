import java.util.Random;

/**
 * Game of guessing a secret number that have range 0 - upperbound that user set.and this will class will return the solution of
 * the number that user guess compare with secrect number and show message "Too small" or "Too large".
 * @author Thanakrit Daowrueang.
 */

public class FlukGame extends NumberGame {
    private int upperBound;
    private int secret;
    private int guesse = 0;

    /**
     * This method set the value of any variable.
     * @param upperBound is the max value of that can guessing.
     */

    public FlukGame(int upperBound) {
        this.upperBound = upperBound;
        Random rand = new Random();
        this.secret = rand.nextInt(upperBound) + 0;
        super.setMessage("I'm thinking of a number between 0 to " + upperBound);
    }

    /**
     * This method use to solve the guess number is equals secret number or not.
     * @param number is the number that user guess.
     * @return your number guess right or not
     */

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

    public int getSecret(){
        return secret;
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
