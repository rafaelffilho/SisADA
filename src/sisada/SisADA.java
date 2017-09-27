/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author anaboth
 */
public class SisADA extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        MainController main = new MainController();
        WindowManager.getInstace().initializeStage(stage, main);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
