package com.example.pratikassignment1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    @FXML
    private TableView<Admission> tableView;
    @FXML
    private TableColumn<Admission,Integer > sub_id;
    @FXML
    private TableColumn<Admission, String> sub_title;
    @FXML
    private TableColumn<Admission,String> sub_instructor;
    @FXML
    private TableColumn<Admission,Integer> sub_grade;
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
                PropertyValueFactory<Admission,Integer>("sub_grade"));
        tableView.setItems(list);
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
            // Populate the table with data from the database
            while (resultSet.next()) {
                int sub_id = resultSet.getInt("sub_id");
                String sub_title = resultSet.getString("sub_title");
                String sub_instructor = resultSet.getString("sub_instructor");
                int sub_grade = resultSet.getInt("sub_grade");
                tableView.getItems().add(new Admission(sub_id, sub_title, sub_instructor,
                        sub_grade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}