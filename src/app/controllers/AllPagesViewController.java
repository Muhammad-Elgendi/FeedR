package app.controllers;

import app.models.Page;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class AllPagesViewController {

    public JFXButton addFeedBtn;
    public int session_id;
    public JFXTextField searchfield;
    public JFXButton viewbtn;

    @FXML
    public TableView<Page> tableView;
    @FXML
    public TableColumn<Page, Integer> idColumn;
    @FXML
    public TableColumn<Page, String> titleColumn;
    @FXML
    public TableColumn<Page, Date> dateColumn;

//    @FXML
//    private void initialize() {
////        System.out.println(session_id);
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
//        dateColumn.setCellValueFactory(new PropertyValueFactory<>("publish_date"));
//        viewPages();
//    }

    public void initPages(){
//        System.out.println(session_id);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("publish_date"));
        viewPages();
    }

    public void viewPages() {

        DBController controller = new DBController();
        tableView.setItems(controller.pages_getAllDB());

    }

    public void viewFavourites(){
        DBController controller = new DBController();
        tableView.setItems(controller.pages_getAllFavourites());
    }

    public void getModel() {

        Page page = tableView.getSelectionModel().getSelectedItem();
//        System.out.println(page.getId());
        direct_To_single_page_view(page,session_id);

    }

    public void search(){
        DBController controller = new DBController();
        tableView.setItems(controller.pages_search(searchfield.getText()));
    }


    public void updatePages() {
        DBController controller = new DBController();
        ArrayList<String> feeds = controller.feeds_getAll(session_id);
//        for (int i = 0; i < feeds.size(); i++) {
//            ParserController.parseAndUpdate((String) feeds.get(i));
//        }
        ParserController.parseAndUpdate(feeds);
        viewPages();
    }

    public void clearAllPages() {

        DBController controller = new DBController();
        controller.pages_clear_all();
        viewPages();
        Notifications.create().text("Your Pages has been successfully deleted").darkStyle().showConfirm();

    }

    public void deleteReadPages() {


        DBController controller = new DBController();
        controller.pages_clear_read();
        viewPages();
        Notifications.create().text("Your read Pages has been successfully deleted").darkStyle().showConfirm();

    }


    public void setSession_id(int id) {
        this.session_id = id;
    }



    public void direct_To_feeds_view(ActionEvent actionEvent) {
        try {
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/feedsView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            FeedsViewController controller = fxmlLoader.<FeedsViewController>getController();
            controller.setSession_id(this.session_id);
            controller.viewFeed();
            currentStage.setScene(new Scene(root, 800, 600));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void direct_To_single_page_view(Page page,int session_id) {
        try {
            Stage currentStage = (Stage) viewbtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/singlePageView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            ViewController controller = fxmlLoader.<ViewController>getController();
            controller.setSession_id(session_id);
            controller.setPage(page);
            controller.showData();

            currentStage.setScene(new Scene(root, 800, 600));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
