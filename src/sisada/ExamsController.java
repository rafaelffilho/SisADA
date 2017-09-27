/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author anaboth
 */
public class ExamsController extends UserInterface {

    @FXML
    private TableView table;
    
    @FXML
    private TableColumn tableName;
    
    @FXML
    private TableColumn tableDiscipline;
    
    @FXML
    private TableColumn tableAverage;
    
    @FXML
    private TableColumn tableWeight;
    
    @FXML
    private TableColumn tableScore;
    
    private ObservableList data;
    
    public static int selectedIndex;
    
    
    @Override
    public void back(){
        initialize(null, null);
    }
    
    private void setDataToTable() {
        Exam temp = new Exam();
        ArrayList <Exam> lista = temp.getExamsList();
        
        data = FXCollections.observableList(lista);
    }

    
    public ExamsController(){
       super("Exams.fxml");
    }
    
    @FXML
    public void onBtBackClick() throws IOException{
        WindowManager.getInstace().back();
    }
    
    @FXML
    public void onAddExamClick(){
        AddExamController temp = new AddExamController();
        WindowManager.getInstace().openWindow(temp);
    }
    
    public void onAddScoreClicked(){
        selectedIndex = table.getSelectionModel().getSelectedIndex();
        AddScoreController score = new AddScoreController();
        WindowManager.getInstace().openWindow(score);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDataToTable();
        table.setItems(data);
        
        tableName.setCellValueFactory(new PropertyValueFactory("name"));
        tableDiscipline.setCellValueFactory(new PropertyValueFactory("discipline"));
        tableWeight.setCellValueFactory(new PropertyValueFactory("weight"));
        tableAverage.setCellValueFactory(new PropertyValueFactory("average"));
        tableScore.setCellValueFactory(new PropertyValueFactory("score"));
    }    
    
}
