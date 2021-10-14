package cz.upce.bdats.sema;

// Autopujcovna
import cz.upce.bdats.sema.autopujcovna.*;

// JavaFX
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

public class App extends Application {
    private static final String TITLE = "Hejduk - Semestrální práce A";
    private static final double WIDTH = 1200;
    private static final double HEIGHT = 700;

    private final IAutopujcovna autopujcovna = new Autopujcovna("Autopujcovna u Skákajícho poníka");

    private final Label lbTitle = new Label();
    private final ListView<IPobocka> lvPobocky = new ListView<>();
    private final ListView<Auto> lvAutaPobocky = new ListView<>();
    private final ListView<Auto> lvAutaVypujcene = new ListView<>();

    private final HBox hb1 = new HBox();
    private final VBox vb1 = new VBox();
    private final VBox vb2 = new VBox();
    private final VBox vb3 = new VBox();
    private final BorderPane root = new BorderPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        lbTitle.setText("Autopujcovna u Skákajícího poníka");

        HBox.setHgrow(lvPobocky, Priority.ALWAYS);
        HBox.setHgrow(lvAutaPobocky, Priority.ALWAYS);
        HBox.setHgrow(lvAutaVypujcene, Priority.ALWAYS);

        hb1.setSpacing(10);
        hb1.getChildren().addAll(lvPobocky, lvAutaPobocky, lvAutaVypujcene);

        root.setTop(lbTitle);
        root.setCenter(hb1);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }
}
