package views;

import PirateModel.Entities.Entity;
import PirateModel.Entities.Player;
import PirateModel.Grid;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.AccessibleRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PirateGameView {

    PirateGame game;

    Stage stage;

    TextField inputTextField;

    static GridPane gridPane;

    GridPane displayGrid;

    static VBox vBox;

    String input;

    public HashMap<List<Integer>, StackPane> rectangleHashMap = new HashMap<>();

    int size;

    public Label prompt;
    public PirateGameView(PirateGame game, Stage stage, int size) {
        this.game = game;
        this.stage = stage;
        this.size = size;
        initUI();
    }
    public void initUI() {
        Ship ship = this.game.getPlayer().getShip();

        String shipName = ship.getName();
        int health = ship.getHealth();
        int damage = ship.getDamage();

        stage.setTitle("Swashbuckler’s Gambit");

        vBox = new VBox();
        vBox.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), new Insets(0))));



        gridPane = new GridPane();
        gridPane.setPrefWidth(1000);

        this.displayGrid = new GridPane(size, size);
        this.displayGrid.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));
        this.displayGrid.setAlignment(Pos.CENTER);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle rectangle = new Rectangle(40, 40);
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                Text text = new Text("a");
                StackPane stack = new StackPane();
                stack.getChildren().addAll(rectangle, text);
                displayGrid.add(stack, col, row);
                List<Integer> coordinate = new ArrayList<>();
                coordinate.add(row);
                coordinate.add(col);
                rectangleHashMap.put(coordinate, stack);
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
        ColumnConstraints column3 = new ColumnConstraints(160);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints( 550 );
        RowConstraints row3 = new RowConstraints();

        row1.setVgrow(Priority.SOMETIMES);
        row3.setVgrow(Priority.SOMETIMES);

        gridPane.getColumnConstraints().addAll(column1, column2, column3);
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

        this.prompt = new Label();
        this.prompt.setText("What would you like to do?");
        this.prompt.setFont(new Font("Arial", 20));
        this.prompt.setTextFill(Color.WHITE);
        this.prompt.setPadding(new Insets(10));

        this.inputTextField = new TextField();
        this.inputTextField.setFont(new Font("Arial", 16));
        this.inputTextField.setFocusTraversable(true);
        textHandlingEvent();

        VBox textEntry = new VBox();
        textEntry.setStyle("-fx-background-color: #000000;");
        textEntry.setPadding(new Insets(20, 20, 20, 20));
        textEntry.getChildren().addAll(this.prompt, this.inputTextField);
        textEntry.setSpacing(10);
        textEntry.setAlignment(Pos.BOTTOM_CENTER);

        StackPane centerPane = new StackPane();
        centerPane.getChildren().add(displayGrid);
        centerPane.setAlignment(Pos.CENTER);

        gridPane.add(shipStats, 0, 1, 1, 1);
        gridPane.add(centerPane, 1,1,3,1);
        gridPane.add(textEntry,0,2,3,1);

        vBox.getChildren().add(gridPane);

        Scene scene = new Scene(vBox, 1000, 850);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }

    public void textHandlingEvent() {
        this.inputTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                input = this.inputTextField.getText().strip();
                PirateGame.getInput(input);
                this.inputTextField.clear();
            }
        });
    }

    public static void displayTextFX(String text) {
        Label textLabel = new Label();
        textLabel.setText(text);
        textLabel.setTextFill(Color.WHITE);
        textLabel.setFont(new Font("Arial", 18));
        textLabel.setPadding(new Insets(20));

        vBox.getChildren().add(textLabel);
    }

}
