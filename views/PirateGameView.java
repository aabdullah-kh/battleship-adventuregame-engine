package views;

import PirateModel.Entities.Entity;
import PirateModel.Entities.Player;
import PirateModel.PirateGame;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.AccessibleRole;

public class PirateGameView {

    PirateGame game;

    Stage stage;
    public PirateGameView(PirateGame game, Stage stage) {
        this.game = game;
        this.stage = stage;
        initUI();
    }
    public void initUI() {
        Ship ship = this.game.getPlayer().getShip();

        String shipName = "GALLEON";
        int health = 1;
        int damage = 2;

        stage.setTitle("Swashbuckler’s Gambit");

        GridPane gridPane = new GridPane();

        GridPane displayGrid = new GridPane(10, 10);
        displayGrid.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));
        displayGrid.setAlignment(Pos.CENTER);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Rectangle rectangle = new Rectangle(40, 40);
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                displayGrid.add(rectangle, col, row);
            }
        }

        gridPane.setPadding(new Insets(20));
        gridPane.setBackground(new Background(new BackgroundFill(
                Color.valueOf("#000000"),
                new CornerRadii(0),
                new Insets(0)
        )));

        ColumnConstraints column1 = new ColumnConstraints(150);
        ColumnConstraints column2 = new ColumnConstraints(650);

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
        shipStatsLabel.setFont(new Font("Poppins", 25));
        shipStatsLabel.setTextFill(Color.BLACK);

        Label shipNameLabel = new Label();
        shipNameLabel.setText("Ship: " + shipName);
        shipNameLabel.setFont(new Font("Poppins", 18));
        shipNameLabel.setTextFill(Color.BLACK);

        Label shipHealthLabel = new Label();
        shipHealthLabel.setText("Health: " + health);
        shipHealthLabel.setFont(new Font("Poppins", 18));
        shipHealthLabel.setTextFill(Color.BLACK);

        Label shipDamageLabel = new Label();
        shipDamageLabel.setText("Damage: " + damage);
        shipDamageLabel.setFont(new Font("Poppins", 18));
        shipDamageLabel.setTextFill(Color.BLACK);

        shipStats.getChildren().addAll(shipStatsLabel, shipNameLabel, shipHealthLabel, shipDamageLabel);

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

        StackPane centerPane = new StackPane();
        centerPane.getChildren().add(displayGrid);
        centerPane.setAlignment(Pos.CENTER);

        gridPane.add(shipStats, 0, 1, 1, 1);
        gridPane.add(centerPane, 1,1,3,1);
        gridPane.add(textEntry,0,2,3,1);

        Scene scene = new Scene(gridPane, 1000, 800);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }
}
