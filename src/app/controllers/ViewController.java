
package app.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class ViewController extends Application {

    @Override public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("singlePageView.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("allPagesView.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("feedsView.fxml"));
        //.
        VBox box = new VBox(root3);
        //.
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}