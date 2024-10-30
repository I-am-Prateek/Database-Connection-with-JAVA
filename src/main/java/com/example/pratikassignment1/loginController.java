package com.example.pratikassignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    public TextField id;
    public TextField title;
    public TextField inst;
    public TextField grade;
    @FXML
    private TableView<Admission> tableView;
    @FXML
    private TableColumn<Admission,Integer > sub_id;
    @FXML
    private TableColumn<Admission, String> sub_title;
    @FXML
    private TableColumn<Admission,String> sub_instructor;
    @FXML
    private TableColumn<Admission,String> sub_grade;
    ObservableList<Admission> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sub_id.setCellValueFactory(new
                PropertyValueFactory<Admission,Integer>("sub_id"));
        sub_title.setCellValueFactory(new
                PropertyValueFactory<Admission,String>("sub_title"));
        sub_instructor.setCellValueFactory(new
                PropertyValueFactory<Admission,String>("sub_instructor"));
        sub_grade.setCellValueFactory(new
                PropertyValueFactory<Admission,String>("sub_grade"));
//        tableView.setItems(list);
        list.clear();tableView.setItems(list);
    }
    @FXML
    protected void CheckDatabaseBtn() {
        populateTable();
    }
    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/java-lab-prateek";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM subjects";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list.clear();tableView.setItems(list);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int sub_id = resultSet.getInt("sub_id");
                String sub_title = resultSet.getString("sub_title");
                String sub_instructor = resultSet.getString("sub_instructor");
                String sub_grade = resultSet.getString("sub_grade");
                tableView.getItems().add(new Admission(sub_id, sub_title, sub_instructor,
                        sub_grade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createbtn(ActionEvent actionEvent) {
        String getId= id.getText();
        String getTitle= title.getText();

        String getInst= grade.getText();
        String getGrade= inst.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/java-lab-prateek";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `subjects`(`sub_id`,`sub_title`, `sub_instructor`, `sub_grade`) VALUES ('"+getId+"', '"+getTitle+"','"+getInst+"','"+getGrade+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadbtn(ActionEvent actionEvent) {
        String getId= id.getText();

        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/java-lab-prateek";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM subjects WHERE `sub_id`='"+getId+"' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int sub_id = resultSet.getInt("sub_id");
                String sub_title = resultSet.getString("sub_title");
                String sub_instructor = resultSet.getString("sub_instructor");
                String sub_grade = resultSet.getString("sub_grade");

                title.setText(sub_title);
                inst.setText(sub_instructor);
                grade.setText(sub_grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatebtn(ActionEvent actionEvent) {

        String getId= id.getText();
        String getTitle= title.getText();
        String getInst= inst.getText();
        String getGrade= grade.getText();
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/java-lab-prateek";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `subjects` SET `sub_title`='"+getTitle+"',`sub_instructor`='"+getInst+"',`sub_grade`='"+getGrade+"'WHERE `sub_id` = '"+getId+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deletebtn(ActionEvent actionEvent) {

        String getId= id.getText();
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/java-lab-prateek";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM subjects WHERE `sub_id`='"+getId+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}