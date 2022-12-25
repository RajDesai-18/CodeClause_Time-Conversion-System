package com.time.timeconversion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primary){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("convert.fxml")));
            Scene scene = new Scene(root);
            primary.setScene(scene);
            primary.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}