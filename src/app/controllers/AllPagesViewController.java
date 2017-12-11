package app.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AllPagesViewController {

    public JFXButton addFeedBtn;
    public int session_id;

    public void setSession_id(int id){
        this.session_id=id;
    }

    public void viewToEdit(ActionEvent actionEvent){

    }

    public void direct_To_feeds_view(ActionEvent actionEvent){
        try {

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/feedsView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            FeedsViewController controller = fxmlLoader.<FeedsViewController>getController();
            controller.setSession_id(this.session_id);
            currentStage.setScene(new Scene(root, 800, 600));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
