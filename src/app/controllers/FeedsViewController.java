package app.controllers;

import app.models.Feed;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.Date;

import java.io.IOException;
import java.util.ResourceBundle;


public class FeedsViewController {

    public JFXButton backbtn;
    public JFXTextField link;
    public int session_id;

    @FXML
    public TableView<Feed> tableView;
    @FXML
    public TableColumn<Feed,String> linkColumn;
    @FXML
    public TableColumn<Feed,Date> Addition_dateColumn;
    @FXML
    private void initialize(){
        linkColumn.setCellValueFactory(new PropertyValueFactory<>("link"));
        Addition_dateColumn.setCellValueFactory(new PropertyValueFactory<>("addtion_date"));
        viewFeed();
    }

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
                viewFeed();
                Notifications.create().text("Your feed has been successfully added").darkStyle().showConfirm();
            }
        }
    }

    public void viewFeed(){

        DBController controller = new DBController();
        tableView.setItems(controller.feeds_getAllDB(session_id));

    }

    public void getModel(){

        Feed feed = tableView.getSelectionModel().getSelectedItem();
        DBController controller = new DBController();
        link.setText(feed.getLink());

    }

    public void deleteFeed(ActionEvent actionEvent) {
        DBController controller = new DBController();
        controller.feed_delete(link.getText());
        viewFeed();
        Notifications.create().text("Your feed has been successfully deleted").darkStyle().showConfirm();
    }


    public void direct_To_All_Pages_View(ActionEvent actionEvent) {
        try {
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/allPagesView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            AllPagesViewController controller = fxmlLoader.<AllPagesViewController>getController();
            controller.setSession_id(this.session_id);
            currentStage.setScene(new Scene(root, 800, 600));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
