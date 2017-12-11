package app.controllers;

import app.models.User;
import com.jfoenix.controls.JFXButton;
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

public class LoginController {

    public JFXTextField username;
    public JFXPasswordField password;
    public JFXButton login;
    public int sessionId;


    public void login(ActionEvent actionEvent) {
        if (!username.getText().equals("") && !password.getText().equals("")) {
            DBController controller = new DBController();
            User user = new User();
            user.setUsername(username.getText());
            user.setPassword(password.getText());
            if (controller.user_is_exist(user)) {
                sessionId = controller.find_user_id(user);
                Notifications.create().text("You have been successfully logged-in").darkStyle().showConfirm();
                direct_To_All_Pages_View(sessionId);
            } else {
                Notifications.create().text("Incorrect Username / Password").darkStyle().showWarning();
            }
        } else {

        }
    }

    public void directToSignup(ActionEvent actionEvent) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../views/signupView.fxml"));
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            appStage.setTitle("Feedr Application");
            appStage.setScene(new Scene(root, 800, 600));
            appStage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void direct_To_All_Pages_View(int sessionId) {
        try {

            Stage currentStage = (Stage) login.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/allPagesView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            AllPagesViewController controller = fxmlLoader.<AllPagesViewController>getController();
            controller.setSession_id(sessionId);
            currentStage.setScene(new Scene(root, 800, 600));


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

