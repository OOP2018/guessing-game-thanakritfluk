import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects,
 * connecting objects, and running the game UI.
 *
 * @author Thanakrit Daowrueang.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Counter counter = new Counter();
        SecretNumber secretNumber = new SecretNumber();
        try {
            URL url = getClass().getResource("GameUI.fxml");
            if (url == null) {
                System.out.println("Couldn't find file: GameUI.fxml");
                Platform.exit();
            }
            // Load the FXML and get reference to the loader
            FXMLLoader loader = new FXMLLoader(url);
            // Create the UI. This will instantiate the controller object, too.
            Parent root = loader.load();
            // Now we can get the controller object from the FXMLloader.
            // This is interesting -- we don't need to use a cast!
            Controller controller = loader.getController();

            // Dependency Injection:
            // Set the Counter object we want the view to update.
            controller.setCounter(counter);
            controller.setSecret(secretNumber);

            // Build and show the scene
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.setTitle("Guessing Game");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ResultView resultView = new ResultView(secretNumber);
        secretNumber.addObserver(resultView);
        resultView.run();

        GuessTimeView guessTimeView = new GuessTimeView(counter);

        counter.addObserver(guessTimeView);

        guessTimeView.run();

    }

    public static void main(String[] args) {
        launch(args);
    }


    public void playWithCosoleGame() {
        // upper limit for secret number in guessing game
        int upperBound = 250;
        NumberGame game = new FlukGame(upperBound);
        GameConsole ui = new GameConsole();
        int solution = ui.play(game);

        System.out.println("play() returned " + solution);
        System.out.println("Guess time: " + game.getCount());

    }
}
