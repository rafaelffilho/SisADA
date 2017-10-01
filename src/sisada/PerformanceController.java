/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author anaboth
 */
public class PerformanceController extends UserInterface {

    public PerformanceController() {
        super("Performance.fxml");
    }

    @FXML
    BarChart chart;
    
    public void onBackClicked(){
        WindowManager.getInstace().back();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        chart.setTitle("Desempenho");
        xAxis.setLabel("Média");       
        yAxis.setLabel("Nota");
        
        ArrayList<Exam> list = Exam.getExamsList();
        
        XYChart.Series m1 = new XYChart.Series();
        XYChart.Series m2 = new XYChart.Series();
        XYChart.Series m3 = new XYChart.Series();
        
        m1.setName("Média 1");
        m2.setName("Média 2");
        m3.setName("Média 3");
        
        for (int i = 0; i < list.size(); i++) {
                for (int j = i; j < list.size(); j++) {
                    if(list.get(j).getDiscipline().equals(list.get(i).getDiscipline())){
                        if(list.get(i).getAverage().equals("Média 1")){
                            m1.getData().add(new XYChart.Data(list.get(j).getDiscipline(), list.get(j).getScore()));
                        }else if (list.get(i).getAverage().equals("Média 2")){
                            m2.getData().add(new XYChart.Data(list.get(j).getDiscipline(), list.get(j).getScore()));
                        }else if (list.get(i).getAverage().equals("Média 3")){
                            m3.getData().add(new XYChart.Data(list.get(j).getDiscipline(), list.get(j).getScore()));
                        }
                    }
                }
            }
        
        chart.getData().addAll(m1,m2,m3);
    }    
    
}
