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
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anaboth
 */
public class AddScoreController extends UserInterface {
    
    @FXML
    public Label lblName;
    
    @FXML
    public Label lblDiscipline;
    
    @FXML
    public Label lblAverage;
    
    @FXML
    public TextField textScore;
    
    public AddScoreController() {
        super("AddScore.fxml");
    }
    
    public void onSaveClicked() throws IOException{
        ArrayList<Exam> exams = Exam.getExamsList();
        exams.get(ExamsController.selectedIndex).setScore(Double.parseDouble(textScore.getText()));
        exams.get(ExamsController.selectedIndex).update();
        WindowManager.getInstace().back();
    }
    
    public void onBackClicked(){
        WindowManager.getInstace().back();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Exam> exams;
        exams = Exam.getExamsList();
        lblName.setText("Nome: " + exams.get(ExamsController.selectedIndex).getName());
        lblDiscipline.setText("Disciplina: " + exams.get(ExamsController.selectedIndex).getDiscipline());
        lblAverage.setText("Média: " + exams.get(ExamsController.selectedIndex).getAverage());
    }    
}
