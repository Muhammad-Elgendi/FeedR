package app.controllers;

import app.models.Feed;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class FeedsViewController{

    public JFXButton backbtn;
    public JFXTextField link;
    public int session_id;

    public TableView<Feed> tableView;

    public TableColumn<Feed,String> linkColumn;

    public TableColumn<Feed,String> Addition_dateColumn;

    public void setSession_id(int id) {
        this.session_id = id;
    }

    public void createFeed(ActionEvent actionEvent) {
        if (!link.getText().equals("")) {
            if (ParserController.validate_feed(link.getText())) {
                DBController controller = new DBController();
                Feed feed = new Feed();
                feed.setLink(link.getText());
                feed.setUserid(session_id);
                controller.feed_insert(feed);

                Notifications.create().text("Your feed has been successfully added").darkStyle().showConfirm();
            }
        }
    }

    public void updateFeed(ActionEvent actionEvent) {
        try {

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../views/allPagesView.fxml"));
            currentStage.setScene(new Scene(root, 800, 600));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteFeed(ActionEvent actionEvent) {
        try {

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../views/allPagesView.fxml"));
            currentStage.setScene(new Scene(root, 800, 600));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void direct_To_All_Pages_View(ActionEvent actionEvent) {
        try {

            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("../views/allPagesView.fxml"));
            currentStage.setScene(new Scene(root, 800, 600));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        DBController controller = new DBController();
        tableView.setItems(controller.feeds_getAllDB(session_id));
    }
}
