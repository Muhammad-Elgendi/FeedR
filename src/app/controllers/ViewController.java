package app.controllers;

import app.models.Page;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class ViewController  {
    public int session_id;
    public Page page;
//    public int page_id;
    public void setSession_id(int id) {
        this.session_id = id;
    }
    public void setPage(Page page) {
        this.page = page;
    }
//    public void setPage_id(int page_id) {
//        this.page_id = page_id;
//    }
    public Label title;
    public JFXTextArea description;
    public JFXTextArea link;
    public Label publish_date;

//    @FXML
//    private void initialize() {
//
//
//    }

    public void showData(){
        title.setText(page.getTitle());
        description.setText(page.getDescription());
        link.setText(page.getLink());
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        publish_date.setText(df.format(page.getPublish_date()));
       makeRead();
    }


    public void setFavourite(){

        DBController controller =new DBController();
        controller.set_page_favourite(page.getId());
        Notifications.create().text("This page set as favourite successfully ").darkStyle().showConfirm();

    }

    public void makeRead(){
        DBController controller =new DBController();
        controller.set_page_read(page.getId());
    }

    public void delete(){
        DBController controller =new DBController();
        controller.pages_delete(page.getId());
        Notifications.create().text("Your page has been deleted successfully ").darkStyle().showConfirm();
        direct_To_All_Pages_View();
    }

    public void direct_To_All_Pages_View() {
        try {
            Stage currentStage = (Stage) title.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/allPagesView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            AllPagesViewController controller = fxmlLoader.<AllPagesViewController>getController();
            controller.setSession_id(this.session_id);
            controller.initPages();
            currentStage.setScene(new Scene(root, 800, 600));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void direct_To_All_Pages_View(ActionEvent actionEvent) {
        try {
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/allPagesView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            AllPagesViewController controller = fxmlLoader.<AllPagesViewController>getController();
            controller.setSession_id(this.session_id);
            controller.initPages();
            currentStage.setScene(new Scene(root, 800, 600));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}