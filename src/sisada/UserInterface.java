/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sisada;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author marcelo
 */
public abstract class UserInterface implements Initializable{
    
    private Scene scene;
    private String path;
    
    protected UserInterface(String path) {
        this.path = path;
    }
    
    public void back(){
        System.out.println("Classe "+this+" não faz tratamento de retorno.");
    }
    
    public final Scene getScene()  {
        if(this.scene != null){
            return this.scene;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            loader.setController(this);            
            Pane temp = loader.load();            
            this.scene = new Scene(temp);
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.scene;
    }
}