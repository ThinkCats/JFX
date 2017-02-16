package com.jfx.model;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Created by hehe on 2017/2/17.
 */
public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty age;
    private final ObjectProperty<LocalDate> birthday;

    public Person(String firstName,String lastName){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleIntegerProperty(22);
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(1990,2,11));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public int getAge(){
        return age.get();
    }

    public void setAge(int age){
        this.age.set(age);
    }

    public IntegerProperty ageProperty(){
        return age;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
}
