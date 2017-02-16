package com.jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getResource("/root.fxml"));
        primaryStage.setTitle("个人信息");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        //show person info
        AnchorPane personView = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        root.setCenter(personView);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
