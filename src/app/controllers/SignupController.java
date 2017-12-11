package app.controllers;


import app.models.User;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class SignupController {

    public JFXTextField username;
    public JFXPasswordField password;

    public void signup(ActionEvent actionEvent) {
        try {
            if(!username.getText().equals("")&&!password.getText().equals("")){
            DBController controller = new DBController();
            User user = new User();
            user.setUsername(username.getText());
            user.setPassword(password.getText());
            controller.user_insert(user);

            Notifications.create().text("You have been successfully registered").darkStyle().showConfirm();

            Parent root = FXMLLoader.load(getClass().getResource("../views/loginView.fxml"));
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            appStage.setTitle("Feedr Application");
            appStage.setScene(new Scene(root, 800, 600));
            appStage.show();
            }
            else{

            }

        } catch (IOException ex) {

        }
    }
}

