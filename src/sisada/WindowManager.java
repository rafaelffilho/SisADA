/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sisada;
import java.util.Stack;
import javafx.stage.Stage;


/**
 *
 * @author marcelo
 */
public class WindowManager {
    
    private static WindowManager instance;
    
    private WindowManager(){
        this.stack = new Stack<>();
    }
    
    public static WindowManager getInstace(){
        if(WindowManager.instance == null){
            WindowManager.instance = new WindowManager();
        }
        return WindowManager.instance;
    }
    
    private Stage stage;
    private Stack<UserInterface> stack;
    private UserInterface activeWindow;
    
    public void initializeStage(Stage p, UserInterface firstInterface){
        this.stage = p;
        this.activeWindow = firstInterface;
        this.stage.setScene(firstInterface.getScene());
        this.stage.show();
    }
    
    private Stage getStage(){
        return this.stage;
    }
    
    public void openWindow(UserInterface newWindow) {
        this.stack.push(this.activeWindow);
        this.getStage().setScene(newWindow.getScene());
        this.activeWindow = newWindow;
        System.out.println(this.stack.size());
    }
    
    public void back() {
        if(!this.stack.empty()){
            UserInterface prev = this.stack.pop();
            this.getStage().setScene(prev.getScene());
            this.activeWindow = prev;
            prev.back();
            return;
        }
        System.err.println("A pilha de retorno vazia");
    }
    
    public void back(int qnt) {
        if(qnt <= this.stack.size()){
            while(qnt > 1){
                this.stack.pop();
                qnt--;
            }
            UserInterface prev = this.stack.pop();
            this.getStage().setScene(prev.getScene());   
            this.activeWindow = prev;
            prev.back();
            return;
        }
        System.err.println("Numero de retornos maior que o tamanho da pilha");       
    }
    
    
    public void popup(UserInterface window){
        Stage popUp = new Stage();
        popUp.setScene(window.getScene());
    }
}