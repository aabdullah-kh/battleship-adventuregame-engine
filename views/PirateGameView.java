package views;

import PirateModel.Entities.Entity;
import PirateModel.Entities.Player;
import PirateModel.Ships.Ship;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.AccessibleRole;

public class PirateGameView extends Application{

    Entity player;
    public static void main(String[] args) {
        launch(args);
    }

    public PirateGameView(Entity player) {
        this.player = player;
    }
    @Override
    public void start(Stage stage) throws Exception {
        Ship ship = this.player.getShip();

        String shipName = ship.getName();
        int health = ship.getHealth();
        int damage = ship.getDamage();

        stage.setTitle("Pirate Game");

        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(20));
        gridPane.setBackground(new Background(new BackgroundFill(
                Color.valueOf("#000000"),
                new CornerRadii(0),
                new Insets(0)
        )));

        ColumnConstraints column1 = new ColumnConstraints(150);
        ColumnConstraints column2 = new ColumnConstraints(650);
        ColumnConstraints column3 = new ColumnConstraints(150);


        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints( 550 );
        RowConstraints row3 = new RowConstraints();

        row1.setVgrow(Priority.SOMETIMES);
        row3.setVgrow(Priority.SOMETIMES);

        gridPane.getColumnConstraints().addAll(column1, column2, column1);
        gridPane.getRowConstraints().addAll(row1, row2, row1);

        VBox shipStats = new VBox();
        shipStats.setAlignment(Pos.TOP_LEFT);
        shipStats.setBackground(new Background(new BackgroundFill(
                Color.valueOf("#FFFFFF"),
                new CornerRadii(0),
                new Insets(0)
        )));

        Label shipStatsLabel = new Label();
        shipStatsLabel.setText("Ship Stats:");
        shipStatsLabel.setFont(new Font("Arial", 20));
        shipStatsLabel.setTextFill(Color.BLACK);

        Label label = new Label();
        label.setText("What would you like to do?");
        label.setFont(new Font("Arial", 20));
        label.setTextFill(Color.WHITE);
        label.setPadding(new Insets(10));

        TextField inputTextField = new TextField();
        inputTextField.setFont(new Font("Arial", 16));
        inputTextField.setFocusTraversable(true);

        VBox textEntry = new VBox();
        textEntry.setStyle("-fx-background-color: #000000;");
        textEntry.setPadding(new Insets(20, 20, 20, 20));
        textEntry.getChildren().addAll(label, inputTextField);
        textEntry.setSpacing(10);
        textEntry.setAlignment(Pos.BOTTOM_CENTER);

        gridPane.add(textEntry, 0, 2, 3, 1);
        gridPane.getChildren().add(shipStats);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(gridPane, 1000, 800);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);

        stage.show();
    }
}
