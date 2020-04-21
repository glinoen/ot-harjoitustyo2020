/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.ui;

import blokkiapp.domain.GameLogic;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author julinden 
 */
public class BlokkiUi extends Application{
    private GameLogic logic;
    private Stage stage;
    private int gridSize;
    
    private Scene gameSetupScene;
    private Scene mainScene;
    
    @Override
    public void init() throws Exception { 
        logic = new GameLogic();
    }
    
    @Override
    public void start(Stage stage) {  
        this.stage = stage;
        this.gameSetupScene = createGameSetupScene();
        stage.setTitle("Blokki");
        stage.setScene(this.gameSetupScene);
        stage.show();
        
        // setup primary stage
//        primaryStage.setTitle("Blokki");
//        primaryStage.setScene(gameSetupScene);
//        primaryStage.show();
    }
    
    public Scene createGameSetupScene() {
        VBox startPane = new VBox(10);
        HBox inputPane = new HBox(10);
        startPane.setPadding(new Insets(10));
        Label gridSizeLabel = new Label("Enter grid size (between 4-10)");
        TextField gridSizeInput = new TextField();
        
        inputPane.getChildren().addAll(gridSizeLabel, gridSizeInput);
        Label errorMessage = new Label();
        
        Button startButton = new Button("Start Game");
        startButton.setOnAction(e->{
            int tempGridSize = Integer.parseInt(gridSizeInput.getText());
            
            if ( tempGridSize > 3 && tempGridSize < 11 ){
                this.gridSize = tempGridSize;
                logic.newGame(gridSize);
                
                errorMessage.setText("");
                this.mainScene = createMainScene();
                sceneChange(this.mainScene);
                gridSizeInput.setText("");
            } else {
                errorMessage.setText("improper grid size");
                errorMessage.setTextFill(Color.RED);
            }      
        });  
        

        startPane.getChildren().addAll(errorMessage, inputPane, startButton);       
        
        gameSetupScene = new Scene(startPane, 500, 500); 
        return gameSetupScene;
    }
    
    public Scene createMainScene() { 
        BorderPane gamePane = new BorderPane();
        
        GridPane tileGrid = new GridPane();
        tileGrid.setHgap(4);
        tileGrid.setVgap(4);
        tileGrid.setAlignment(Pos.CENTER);
        
        updateGrid(tileGrid);
        gamePane.setCenter(tileGrid);
        
        HBox infoBox = new HBox();
        Label scoreCounter = new Label("Score: 0");
        infoBox.getChildren().addAll(scoreCounter);
        HBox.setHgrow(scoreCounter, Priority.ALWAYS);
        
        gamePane.setTop(infoBox);
        
        

        Scene newMainScene = new Scene(gamePane, 500, 500);
        
        // Moving the grid
        EventHandler<KeyEvent> tileMover = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ( event.getCode() == KeyCode.UP) {
                    logic.moveTiles("up");
                } else if ( event.getCode() == KeyCode.DOWN) {
                    logic.moveTiles("down");
                } else if ( event.getCode() == KeyCode.RIGHT) {
                    logic.moveTiles("right");
                } else if ( event.getCode() == KeyCode.LEFT) {
                    logic.moveTiles("left");
                }
                if ( logic.isGameOver() ) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Game Over");
                    alert.setHeaderText(null);
                    alert.setContentText("Game over. Your score: " + logic.getScore());
                    ButtonType buttonTypeOne = new ButtonType("Play again");
                    ButtonType buttonTypeTwo = new ButtonType("Quit to desktop");
                    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

                    alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
                    alert.getDialogPane().lookupButton(buttonTypeCancel).setVisible(false);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == buttonTypeOne){
                        start(stage);
                    } else {
                        Platform.exit();
                        System.exit(0);
                    }
                } else {
                    updateGrid(tileGrid);
                    scoreCounter.setText("Score: " + logic.getScore());
                }
                
            }
        };
        
        newMainScene.addEventHandler(KeyEvent.KEY_PRESSED, tileMover);
        
        return newMainScene;
    }
    
    public void updateGrid(GridPane grid) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                StackPane tile = new StackPane();
                tile.getChildren().addAll(new Rectangle(80, 80, Color.WHITE));
                int tilevalue = logic.getBoard().getGrid()[i][j].getValue();
                if ( tilevalue > 0) {
                    Label number = new Label(String.valueOf(tilevalue));
                    tile.getChildren().add(number);
                }
                grid.add(tile, j, i);
            }
        }
        
    }
    
    public void sceneChange(Scene scene) {
        this.stage.setScene(scene);
    }
  
    @Override
    public void stop() {
      // tee lopetustoimenpiteet täällä
      System.out.println("sovellus sulkeutuu");
    }    
    
    public static void main(String[] args) {
        launch(args);
    }
}

