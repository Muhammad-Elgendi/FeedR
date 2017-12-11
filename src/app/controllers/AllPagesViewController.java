package app.controllers;

import app.models.Feed;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class AllPagesViewController {

    public JFXButton addFeedBtn;
    public int session_id;

    @FXML
    public TableView<Feed> tableView;
    @FXML
    public TableColumn<Feed, String> linkColumn;
    @FXML
    public TableColumn<Feed, Date> Addition_dateColumn;

    @FXML
    private void initialize() {
//        linkColumn.setCellValueFactory(new PropertyValueFactory<>("link"));
//        Addition_dateColumn.setCellValueFactory(new PropertyValueFactory<>("addtion_date"));
//        viewPages();
    }

    public void viewPages() {

//        DBController controller = new DBController();
//        tableView.setItems(controller.pages_getAllDB(session_id));

    }


    public void updatePages() {
        DBController controller = new DBController();
        ArrayList<String> feeds = controller.feeds_getAll(session_id);
        for (int i =0 ;i < feeds.size() ;i++){
            ParserController.parseAndUpdate((String) feeds.get(i));
        }
    }

    public void clearAllPages() {

//        DBController controller = new DBController();
//        tableView.setItems(controller.pages_getAllDB(session_id));

    }

    public void deleteReadPages() {

//        DBController controller = new DBController();
//        tableView.setItems(controller.pages_getAllDB(session_id));

    }


    public void setSession_id(int id) {
        this.session_id = id;
    }

    public void viewToEdit(ActionEvent actionEvent) {

    }

    public void direct_To_feeds_view(ActionEvent actionEvent) {
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
