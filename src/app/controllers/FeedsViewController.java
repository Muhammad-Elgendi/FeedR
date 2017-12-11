package app.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedsViewController {

    public JFXButton backbtn;

    public void direct_To_All_Pages_View(ActionEvent actionEvent) {
        try {

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../views/allPagesView.fxml"));
            currentStage.setScene(new Scene(root, 800, 600));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
