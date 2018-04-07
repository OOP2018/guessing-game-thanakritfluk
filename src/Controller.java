import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceDialog;

/**
 * This use to handle the fxml to do the action.
 * @author Thanakrit Daorueang.
 */
public class Controller {
    @FXML
    TextField textfield;
    @FXML
    Button guess;
    @FXML
    Button giveup;
    @FXML
    Label result;

    private Counter counter;

    private FlukGame game = new FlukGame(50);

    private SecretNumber secret;

    /**
     * Set counter for controller to use.
     * @param counter is Counter class
     */
    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    /**
     * Set secret number for controller to use.
     * @param secret is Secret class.
     */
    public void setSecret(SecretNumber secret) { this.secret = secret; }

    /**
     * Use to give up to guess and show the result secret number then reset the game.
     */
    @FXML
    public void giveUpButtonHandle() {
        secret.setSecret(game.getSecret());
        counter.add(counter.getCount() * -1);
        result.setText(null);
        textfield.setText(null);
    }

    /**
     * Use to do about action that user made.
     */
    @FXML
    public void getButtonHandle(ActionEvent actionEvent) {
        String text = textfield.getText();
        int value = Integer.parseInt(text);
        System.out.println(value);
        guessButtonHandle(value);
    }

    /**
     * This method use to check player is guess correct or not.
     * @param value the value use to check with secret number.
     */
    public void guessButtonHandle(int value) {
        if (value < 0) {
            result.setText("\tNumber >= 0");
        } else if (value == game.getSecret()) {
            secret.setSecret(game.getSecret());
            counter.add(1);
            result.setText("***** You win ******");
            game = new FlukGame(50);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("Do you want to play again?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                counter.add(counter.getCount() * -1);
                result.setText(null);
                textfield.setText(null);
            } else {
                System.exit(0);
            }
        } else {
            if (value < game.getSecret()) {
                result.setText(" You guess is too small");
            }
            if (value > game.getSecret()) result.setText(" You guess is too large");
            counter.add(1);
        }
    }



}
