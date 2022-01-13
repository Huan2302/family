package sample.Util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class Utils {
    private void loadPage(ActionEvent event, String title, String url) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        //stage.setMaximized(true);
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(Main.class.getResource(url)));
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    private void loadSubPage(ActionEvent event, String title, String url) throws IOException {
        //stage.setMaximized(true);
//        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(FXMLLoader.load(Main.class.getResource(url)));
//        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
//        stage.show();
        stage.showAndWait();
    }

    public static void load (ActionEvent event, String title, String url) throws IOException{
        new Utils().loadPage(event,title,url);
    }

    public static void loadSub (ActionEvent event, String title, String url) throws IOException{
        new Utils().loadSubPage(event,title,url);
    }
}
