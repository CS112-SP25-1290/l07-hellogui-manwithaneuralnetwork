package edu.miracosta.cs112.lab07;//package name here depending on your IDE

import javafx.application.Application;  //abstract class used for JavaFX GUI's
import javafx.event.Event;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;              //class for GUI window
import javafx.scene.Scene;              //class for specific view in GUI window
import javafx.scene.layout.VBox;        //class for layout pane, organized top-to-bottom
import javafx.scene.control.Label;      //class for label component
import javafx.scene.control.Button;     //class for button component
import javafx.event.EventHandler;       //interface for handling events
import javafx.event.ActionEvent;        //class for type of event for action (like button or key pressed)

public class HelloApplication extends Application implements EventHandler<ActionEvent>  { //inheriting core functionality + this class will handle events
    /*** GUI COMPONENTS ***/
    // TODO: follow step 25 in README.md to create reference variables
    Label label;
    Label label2;
    Button button;
    Button button2;
    TextField textField;

    int clicks;

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args); //method from Application class, must be called to setup javafx application
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello GUI: Alex");
        StackPane pane = new StackPane();
        clicks = 0;

        AnchorPane anchorPane = new AnchorPane();

        label = new Label("Hello I am label 1");
        label2 = new Label("Hello I will count clicks");
        button = new Button("Click me!");
        button2 = new Button("No, click me!");
        textField = new TextField();

        button.setOnAction(this);
        button2.setOnAction(this);

        AnchorPane.setTopAnchor(label, 5.0);
        AnchorPane.setLeftAnchor(label, 10.0);
        AnchorPane.setTopAnchor(label2, 5.0);
        AnchorPane.setRightAnchor(label2, 10.0);
        AnchorPane.setTopAnchor(button, 180.0);
        AnchorPane.setLeftAnchor(button, 115.0);
        AnchorPane.setTopAnchor(button2, 250.0);
        AnchorPane.setLeftAnchor(button2, 106.0);
        AnchorPane.setTopAnchor(textField, 140.0);
        AnchorPane.setLeftAnchor(textField, 75.0);


        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(button);
        anchorPane.getChildren().add(button2);
        anchorPane.getChildren().add(textField);

        pane.getChildren().add(anchorPane);

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button){
            label.setText(textField.getText());
        }
        else if(event.getSource() == button2){
            clicks++;
            label2.setText("Clicks: "+clicks);
        }
    }
}