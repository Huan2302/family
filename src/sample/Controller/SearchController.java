package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Dao.impl.PersonDao;
import sample.Model.PersonModel;
import sample.Util.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    private PersonDao personDao = new PersonDao();
    @FXML
    private TextField txtName;
    @FXML
    private TableView<PersonModel> personTable;
    @FXML
    private TableView<PersonModel> genTable;
    @FXML
    private TableColumn<PersonModel, String> c1Colum;
    @FXML
    private TableColumn<PersonModel, String> c2Colum;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c1Colum.setCellValueFactory(new PropertyValueFactory<>("name"));
        c2Colum.setCellValueFactory(new PropertyValueFactory<>("name"));
        try {
            load();

        }catch (Exception e){
            e.getMessage();
        }
        try {
            loadGen();
        }catch (Exception e){
            e.getMessage();
        }


    }

    public void loadHome(ActionEvent event){
        try{
            Utils.load(event,"Trang chủ","sample.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void search(ActionEvent event){
        load();
        loadGen();
    }

    public void load(){
        ObservableList<PersonModel> listPerson = FXCollections.observableArrayList();
        List<PersonModel> list = personDao.getName(txtName.getText());
        for (PersonModel item:list){
            listPerson.add(item);
        }
        personTable.setItems(listPerson);
    }

    public void loadGen(){
        ObservableList<PersonModel> listPerson = FXCollections.observableArrayList();
        genTable.setItems(null);
        try {
            int gen = personDao.findById(txtName.getText()).getGeneration();
            List<PersonModel> list = personDao.getGen(gen);
            for (PersonModel item:list){
                listPerson.add(item);
            }
        }catch (Exception e){

        }
        genTable.setItems(listPerson);
    }
}
