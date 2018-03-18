import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceDialog;

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

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    @FXML
    public void giveUpButtonHandle() {
        System.exit(0);
    }

    @FXML
    public void getButtonHandle(ActionEvent actionEvent) {
        String text = textfield.getText();
        int value = Integer.parseInt(text);
        System.out.println(value);
        guess(value);
    }

    public void guess(int value) {
        if (value < 0) {
            result.setText("\tNumber >= 0");
        } else if (value == game.getSecret()) {
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
