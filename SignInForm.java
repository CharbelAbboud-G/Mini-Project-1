package com.example.signinform;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SignInForm extends Application {
    private TableView<Employe> table;
    private ObservableList<Employe> employees;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sign In Form ");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        grid.add(btn, 1, 4);

        Text signedInMsg = new Text();
        signedInMsg.setFill(Color.RED);
        grid.add(signedInMsg, 0, 5, 2, 1);

        employees = FXCollections.observableArrayList();

        btn.setOnAction(evt -> {
            String username = userTextField.getText();
            String password = pwBox.getText();
            if (username.equals("") || password.equals("")) {
                signedInMsg.setText("Username and password are required!");
            } else if (!username.equals("admin") || !password.equals("12345")) {
                signedInMsg.setText("Incorrect username and/or password");
            } else {
                signedInMsg.setText("");
                showWelcomeMessage(username);
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showWelcomeMessage(String username) {
        Stage welcomeStage = new Stage();
        welcomeStage.setTitle("Welcome");

        VBox welcomeLayout = new VBox(10);
        welcomeLayout.setPadding(new Insets(20));

        Text welcomeMsg = new Text("Welcome " + username + "!");
        welcomeMsg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        Button proceedButton = new Button("Proceed to Employee Management");
        proceedButton.setOnAction(e -> {
            welcomeStage.close();
            showEmployeeManagement();
        });

        welcomeLayout.getChildren().addAll(welcomeMsg, proceedButton);
        Scene welcomeScene = new Scene(welcomeLayout, 400, 200);
        welcomeStage.setScene(welcomeScene);
        welcomeStage.show();
    }

    private void showEmployeeManagement() {
        Stage employeeStage = new Stage();
        employeeStage.setTitle("Employe Management");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        table = new TableView<>();
        table.setItems(employees);

        TableColumn<Employe, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Employe, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employe, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employe, Double> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Employe, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        TableColumn<Employe, Boolean> fullTimeColumn = new TableColumn<>("Full Time");
        fullTimeColumn.setCellValueFactory(new PropertyValueFactory<>("isFullTime"));

        TableColumn<Employe, Boolean> partTimeColumn = new TableColumn<>("Part Time");
        partTimeColumn.setCellValueFactory(new PropertyValueFactory<>("isPartTime"));

        TableColumn<Employe, LocalDate> hireDateColumn = new TableColumn<>("Hire Date");
        hireDateColumn.setCellValueFactory(new PropertyValueFactory<>("hireDate"));

        table.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, salaryColumn, departmentColumn, fullTimeColumn, partTimeColumn, hireDateColumn);

        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(25, 25, 25, 25));

        TextField idField = new TextField();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField salaryField = new TextField();
        TextField departmentField = new TextField();
        CheckBox fullTimeCheckBox = new CheckBox("Full Time");
        CheckBox partTimeCheckBox = new CheckBox("Part Time");
        DatePicker hireDatePicker = new DatePicker();
        Button addButton = new Button("Add Employe");

        formGrid.add(new Label("ID:"), 0, 0);
        formGrid.add(idField, 1, 0);
        formGrid.add(new Label("First Name:"), 0, 1);
        formGrid.add(firstNameField, 1, 1);
        formGrid.add(new Label("Last Name:"), 0, 2);
        formGrid.add(lastNameField, 1, 2);
        formGrid.add(new Label("Salary:"), 0, 3);
        formGrid.add(salaryField, 1, 3);
        formGrid.add(new Label("Department:"), 0, 4);
        formGrid.add(departmentField, 1, 4);
        formGrid.add(fullTimeCheckBox, 1, 5);
        formGrid.add(partTimeCheckBox, 1, 6);
        formGrid.add(new Label("Hire Date:"), 0, 7);
        formGrid.add(hireDatePicker, 1, 7);
        formGrid.add(addButton, 1, 8);

        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        formGrid.add(new Label("Gender:"), 0, 8);
        formGrid.add(maleRadio, 2, 8);
        formGrid.add(femaleRadio, 2, 9);

        addButton.setOnAction(e -> {
            int id = Integer.parseInt(idField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            double salary = Double.parseDouble(salaryField.getText());
            String department = departmentField.getText();
            boolean isFullTime = fullTimeCheckBox.isSelected();
            boolean isPartTime = partTimeCheckBox.isSelected();
            LocalDate hireDate = hireDatePicker.getValue();

            Employe newEmployee = new Employe(id, firstName, lastName, salary, department, isFullTime, isPartTime, hireDate);
            employees.add(newEmployee);

            idField.clear();
            firstNameField.clear();
            lastNameField.clear();
            salaryField.clear();
            departmentField.clear();
            fullTimeCheckBox.setSelected(false);
            partTimeCheckBox.setSelected(false);
            hireDatePicker.setValue(null);
        });

        layout.getChildren().addAll(table, formGrid);

        Scene employeeScene = new Scene(layout, 900, 700);
        employeeStage.setScene(employeeScene);
        employeeStage.show();
    }
}