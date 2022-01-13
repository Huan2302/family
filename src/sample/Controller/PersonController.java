package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Util.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonController implements Initializable {

    @FXML
    private Button addbtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addPerson(ActionEvent event){
        try{
            Utils.load(event,"Thêm","addPerson.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSearch(ActionEvent event){
        try{
            Utils.load(event,"Tìm kiếm","searchPerson.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
