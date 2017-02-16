package com.jfx;

import com.jfx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public Main(){
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersonData(){
        return personData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getResource("/root.fxml"));
        primaryStage.setTitle("个人信息");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        //show person info
        FXMLLoader personLoader = new FXMLLoader();
        personLoader.setLocation(getClass().getResource("/sample.fxml"));
        AnchorPane personView = personLoader.load();
        root.setCenter(personView);
        SampleController controller = personLoader.getController();
        controller.setMainApp(this);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
