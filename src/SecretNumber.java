/**
 * This class use to set the secert number of the game.
 * @author Thanakrit daorueang.
 */
public class SecretNumber extends java.util.Observable {
    private int secret;

    /**
     * Constructor of Secret class.
     */
    public SecretNumber(){ this.secret = 0;}

    /**
     * Set secret number that recieved from game.
     * @param secretNumber is secret number.
     */
    public void setSecret(int secretNumber){
        secret = secretNumber;
        setChanged();
        notifyObservers();
    }

    /**
     * get secret number to use.
     * @return secret number.
     */
    public int getSecret(){
        return secret;
    }
}

