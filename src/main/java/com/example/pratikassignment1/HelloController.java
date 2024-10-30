package com.example.pratikassignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    public TextField user_name;
    @FXML
    public PasswordField password_field;
    @FXML
    public Label output_area;

    private final String realuser = "user420";
    private final String realpass = "555";

    @FXML
    public void redirecttodtbs(ActionEvent actionEvent) {
        String username = user_name.getText();
        String password = password_field.getText();

        if (username.isEmpty() || password.isEmpty()) {
            output_area.setText("Please Provide Username or Password.");
        } else if (username.equals(realuser) && password.equals(realpass)) {
            output_area.setText("Login Successful!");
            try {
                Parent secondScene = FXMLLoader.load(getClass().getResource("dashboardpage.fxml"));

                // Create a new stage for the second scene
                Stage secondStage = new Stage();
                secondStage.setTitle("User  Scene");
                secondStage.setScene(new Scene(secondScene));

                // Close the current stage
                Stage firstSceneStage = (Stage) user_name.getScene().getWindow(); // Corrected this line
                firstSceneStage.close();
                secondStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            output_area.setText("Invalid Username or Password");
        }
    }
}