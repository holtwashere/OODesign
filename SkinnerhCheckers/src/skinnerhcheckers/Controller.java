package skinnerhcheckers;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Controller implements Initializable {
    
    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private VBox vBox;
    
    // default values
    private int numRowsColumns = 8;
    private double boardWidth;	
    private double boardHeight;
    
    private Stage stage;
    private CheckerBoard board;

    public void ready(Stage stage) {
        this.stage = stage;
        this.boardWidth = stage.getWidth();
        this.boardHeight = stage.getHeight();
        this.board = new CheckerBoard(numRowsColumns, numRowsColumns, boardWidth, boardHeight);
        anchorPane = this.board.build();
        vBox.getChildren().add(anchorPane);
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            this.anchorPane = this.board.build();
        };

        vBox.widthProperty().addListener(lambdaChangeListener);
        vBox.heightProperty().addListener(lambdaChangeListener);

    }
    
//    ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
//     drawGrid();
//    };
//
    @FXML
    private void handleGridChange(ActionEvent event) {
        this.board = new CheckerBoard(numRowsColumns, numRowsColumns, boardWidth, boardHeight);
        this.anchorPane = this.board.build(); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
