package com.example.jasdeepkaurlab2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PageController implements Initializable {

    public TableView Tableview;
    public TableColumn TableID;
    public TableColumn TableName;
    public TableColumn TableLocation;
    public TableColumn TableMobileNumber;
    public TableColumn TableCost;
    public TextField InputLocation;
    public TextField InputName;
    public TextField InputID;
    public TextField InputMobileNumber;
    public TextField InputCost;

    ObservableList<renovation> list = FXCollections.observableArrayList();

    public void Load() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = ("SELECT * FROM renovation");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {

                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String location = resultSet.getString("Location");
                String mobile = resultSet.getString("MobileNumber");
                Double cost = resultSet.getDouble("Cost");

                System.out.println(id + name + location + mobile + cost);
                Tableview.getItems().add(new renovation(id,name,location,mobile,cost));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Insert() {
        String name=InputName.getText();
        String location=InputLocation.getText();
        String mobileNumber=InputMobileNumber.getText();
        Double cost=Double.parseDouble(InputCost.getText());


        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = String.format("INSERT INTO renovation (Name,Location,MobileNumber,Cost) VALUES ('%s','%s','%s',%f)",name,location,mobileNumber,cost);
            Statement statement = connection.createStatement();
            int a = statement.executeUpdate(query);
// Populate the table with data from the database
           if(a>0){
               System.out.println("Done");
           }
           else{
               System.out.println("Failed");
           }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        int id=Integer.parseInt(InputID.getText());
        String name=InputName.getText();
        String location=InputLocation.getText();
        String mobileNumber=InputMobileNumber.getText();
        Double cost=Double.parseDouble(InputCost.getText());


        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = String.format("update renovation set Name='%s',Location='%s',MobileNumber='%s',Cost=%f where ID=%d",name,location,mobileNumber,cost,id);
            Statement statement = connection.createStatement();
            int a = statement.executeUpdate(query);
// Populate the table with data from the database
            if(a>0){
                System.out.println("Done");
            }
            else{
                System.out.println("Failed");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Delete() {
        int id=Integer.parseInt(InputID.getText());



        String jdbcUrl = "jdbc:mysql://localhost:3306/lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = String.format("delete from renovation where ID=%d",id);
            Statement statement = connection.createStatement();
            int a = statement.executeUpdate(query);
// Populate the table with data from the database
            if(a>0){
                System.out.println("Done");
            }
            else{
                System.out.println("Failed");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableID.setCellValueFactory(new PropertyValueFactory<renovation, Integer>("ID"));
        TableName.setCellValueFactory(new PropertyValueFactory<renovation, String>("Name"));
        TableLocation.setCellValueFactory(new PropertyValueFactory<renovation, Integer>("Location"));
        TableMobileNumber.setCellValueFactory(new PropertyValueFactory<renovation, Integer>("MobileNumber"));
        TableCost.setCellValueFactory(new PropertyValueFactory<renovation, Integer>("Cost"));

        Tableview.setItems(list);

    }
}

