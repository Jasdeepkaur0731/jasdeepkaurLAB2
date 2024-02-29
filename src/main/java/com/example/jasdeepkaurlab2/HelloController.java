package com.example.jasdeepkaurlab2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class HelloController {
    public TextField TextUsername;
    public PasswordField TextPassword;
    @FXML
    private Label welcomeText;

    @FXML

    public void login() throws SQLException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";

        String uName = TextUsername.getText();
        String pass = TextPassword.getText();

        System.out.println(uName + pass);
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = String.format("SELECT Password FROM website WHERE Username='%s'", uName);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {

                String Password = resultSet.getString("Password");

                if(Password.equals(pass)){
                    System.out.println("Login");
                    Parent secondScene= FXMLLoader.load(getClass().getResource("page-view.fxml"));
                    Stage secondStage=new Stage();
                    secondStage.setScene(new Scene(secondScene));
                    Stage firstStage=(Stage) welcomeText.getScene().getWindow();
                    firstStage.close();
                    secondStage.show();


                }
                else{
                    System.out.println("Invalid passsword");
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

