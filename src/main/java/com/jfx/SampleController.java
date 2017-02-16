package com.jfx;

import com.jfx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.converter.LocalDateStringConverter;

public class SampleController {
    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person,String> firstNameColumn;
    @FXML
    private TableColumn<Person,String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label birthLabel;

    private Main main;

    public SampleController(){}

    @FXML
    private void initialize(){
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        showPersonDetail(null);

        personTableView.getSelectionModel().selectedItemProperty()
                .addListener(((observable, oldValue, newValue) -> showPersonDetail(newValue)));
    }

    void setMainApp(Main mainApp){
        this.main = mainApp;
        personTableView.setItems(mainApp.getPersonData());
    }

    private void showPersonDetail(Person person){
        if (person != null){
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            ageLabel.setText(Integer.toString(person.getAge()));
            birthLabel.setText(new LocalDateStringConverter().toString(person.getBirthday()));
        }else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            ageLabel.setText("");
            birthLabel.setText("");
        }
    }

    public void handleDelete(ActionEvent event) {
        int index = personTableView.getSelectionModel().getSelectedIndex();
        if(index >=0){
            personTableView.getItems().remove(index);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setContentText("未选择人员！无法删除");
            alert.showAndWait();
        }
    }
}
