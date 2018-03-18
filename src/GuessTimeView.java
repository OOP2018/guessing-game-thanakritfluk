import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Observable;

public class GuessTimeView implements java.util.Observer {

    /** the stage (top-level window) for showing scene */
    private Stage stage;
    /** a counter to show value of */
    private Counter counter;
    /** the label that shows the counter value. */
    private Label text;
    private Label GuessText;

    /**
     * Initialize a CounterView, which shows value of a counter.
     * @param counter the Counter to show.
     */
    public GuessTimeView(Counter counter) {
        this.counter = counter;
        initComponents();
    }

    private void initComponents() {
        stage = new Stage();
        stage.setResizable(false);
        // components and containers for our window
        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        // The label that will show the counter value.

        text = new Label("Count: ");
        text.setPrefWidth(180);
        text.setTextFill(Color.SKYBLUE);
        text.setFont(new Font("Arial",50));
        text.setAlignment(Pos.BASELINE_LEFT);

        GuessText = new Label("   ");
        GuessText.setTextFill(Color.SKYBLUE);
        // make the label big enough
        GuessText.setPrefWidth(100);
        GuessText.setFont(new Font("Arial", 50.0));
        GuessText.setAlignment(Pos.CENTER);
        // Add the label to the HBox.  You can all more components, too.
        root.getChildren().add(text);
        root.getChildren().add(GuessText);

        // Create a Scene using HBox as the root element
        Scene scene = new Scene(root);
        // show the scene on the stage
        stage.setScene(scene);
        stage.setTitle("Guess Time");
        stage.sizeToScene();
    }

    /** Show the window and update the counter value. */
    public void run() {
        stage.show();
        displayCount();
    }

    public void displayCount() {
        GuessText.setText( String.format("%2d", counter.getCount()) );
    }

    @Override
    public void update(Observable o, Object arg) {
        displayCount();
    }


}
