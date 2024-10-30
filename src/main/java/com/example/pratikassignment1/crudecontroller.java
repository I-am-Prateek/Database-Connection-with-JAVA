package com.example.pratikassignment1;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class crudecontroller {
    public Button user_btn;
    public Button logout_btn;

    public void myuserlogin(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("Login-user-view.fxml"));

            // Create a new stage for the second scene
            Stage secondStage = new Stage();
            secondStage.setTitle("User  Scene");
            secondStage.setScene(new Scene(secondScene));
            // Close the current stage
            Stage firstSceneStage = (Stage) user_btn.getScene().getWindow(); // Corrected this line
            firstSceneStage.close();
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void myuserlogout(ActionEvent actionEvent) {
        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            // Create a new stage for the second scene
            Stage secondStage = new Stage();
            secondStage.setTitle("User  Scene");
            secondStage.setScene(new Scene(secondScene));

            // Close the current stage
            Stage firstSceneStage = (Stage) logout_btn.getScene().getWindow(); // Corrected this line
            firstSceneStage.close();
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}