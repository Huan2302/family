package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Dao.impl.PersonDao;
import sample.Model.PersonModel;
import sample.Model.StatusModel;
import sample.Util.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddPersonController implements Initializable {
    private PersonDao personDao = new PersonDao();
    @FXML
    private TextField txtFather;
    @FXML
    private TextField txtname;
    @FXML
    private Label txtNotification;
    @FXML
    private TextField numberChild;
    @FXML
    private ChoiceBox<StatusModel> choice;
    @FXML
    private DatePicker birth;

    private void loadStatus(){
        ObservableList<StatusModel> listStatus = FXCollections.observableArrayList();
        listStatus.add(new StatusModel("Đã kết hôn",0));
        listStatus.add(new StatusModel("Chưa kết hôn",1));
        choice.setItems(listStatus);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadStatus();
    }

    public void loadHome(ActionEvent event){
        try{
            Utils.load(event,"Trang chủ","sample.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(ActionEvent event){
        PersonModel checkNumberChild = personDao.findById(txtFather.getText());
        if (checkNumberChild != null){
            if (personDao.countName(txtFather.getText()) >= checkNumberChild.getNumberChild()
            ){
            txtNotification.setText("Thêm thất bại "+ txtFather.getText() +
                    " chỉ có "+ checkNumberChild.getNumberChild() +
                    " người con");
            return;
            }
        }

        List<PersonModel> list = personDao.findAll();
        PersonModel personModel = new PersonModel();
        personModel.setGeneration(1);

        for (PersonModel item: list){
            if (item.getName().equals(txtFather.getText())){
                personModel.setGeneration(item.getGeneration()+1);
            }
        }
        personModel.setName(txtname.getText());
        personModel.setNameFather(txtFather.getText());
        personModel.setBirth(String.valueOf(birth.getValue()));
        personModel.setStatus(choice.getValue().getStatus());
        personModel.setNumberChild(Integer.parseInt(numberChild.getText()));
        System.out.println(personModel.toString());
        try {
            personDao.insertPerson(personModel);
            txtNotification.setText("Thêm thành công");
        }catch (Exception e){
            txtNotification.setText("Thêm thất bại");
        }
    }
}
