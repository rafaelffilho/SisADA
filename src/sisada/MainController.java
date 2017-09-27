/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

/**
 *
 * @author anaboth
 */
public class MainController extends UserInterface {

    public MainController(){
        super("Main.fxml");
    }
    
    public void onBtExamsClick(ActionEvent e) throws IOException{
        ExamsController exams = new ExamsController();
        WindowManager.getInstace().openWindow(exams);
    }
    
    public void onBtPerformanceClick(){
        PerformanceController perf = new PerformanceController();
        WindowManager.getInstace().openWindow(perf);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
