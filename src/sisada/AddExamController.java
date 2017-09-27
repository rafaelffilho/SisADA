/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anaboth
 */
public class AddExamController extends UserInterface {

    public AddExamController() {
        super("AddExam.fxml");
    }
    
    @FXML
    TextField textName;
    
    @FXML
    TextField textWeight;
    
    @FXML
    ComboBox<String> cbAverages;
    
    @FXML
    ComboBox<String> cbDisciplines;

    @FXML
    public void onSaveClick(){
        Exam temp = new Exam();
        temp.setName(textName.getText());
        temp.setWeight(Double.parseDouble(textWeight.getText()));
        temp.setDiscipline(cbDisciplines.getValue());
        temp.setAverage(cbAverages.getValue().toString());
        temp.save();
        
        WindowManager.getInstace().back();
    }
    
    @FXML
    public void onBackClick(){
        WindowManager.getInstace().back();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbDisciplines.getItems().addAll(
                "ÉTICA EM INFORMÁTICA",
                "MATEMÁTICA COMPUTACIONAL",
                "ALGORITMOS E PROGRAMAÇÃO 1",
                "ÁLGEBRA 1",
                "INTRODUÇÃO AO CÁLCULO",
                "INICIAÇÃO TÉCNICO-CIENTÍFICA",
                "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO",
                "INTRODUÇÃO À FÍSICA",
                "CÁLCULO 1",
                "ALGORITMOS E PROGRAMAÇÃO 2",
                "CIRCUITOS DIGITAIS",
                "DESENHO TÉCNICO",
                "FÍSICA GERAL",
                "ÁLGEBRA 2",
                "CÁLCULO 2",
                "ESTRUTURAS DE DADOS",
                "PROGRAMAÇÃO ORIENTADA A OBJETOS 1",
                "ARQUITETURA DE COMPUTADORES 1",
                "FÍSICA",
                "QUÍMICA 1",
                "ARQUITETURA DE COMPUTADORES 2",
                "PROGRAMAÇÃO ORIENTADA A OBJETOS 2",
                "CÁLCULO 3",
                "ANÁLISE DE CIRCUITOS ELÉTRICOS",
                "QUÍMICA 2",
                "ÓTICA E FÍSICA PARA SEMICONDUTORES",
                "RESISTÊNCIA DOS MATERIAIS",
                "BANCO DE DADOS",
                "SISTEMAS OPERACIONAIS",
                "MATEMÁTICA APLICADA À ENGENHARIA",
                "ENGENHARIA DE SOFTWARE 1",
                "PROBABILIDADE E ESTATÍSTICA",
                "ELETRÔNICA BÁSICA",
                "INTERFACE HUMANO - COMPUTADOR",
                "ENGENHARIA DE SOFTWARE 2",
                "REDES DE COMPUTADORES 1",
                "CÁLCULO NUMERICO",
                "LINGUAGENS FORMAIS",
                "ELETRÔNICA APLICADA",
                "ANÁLISE E CONTROLE DE PROCESSOS",
                "ENGENHARIA ECONÔMICA",
                "REDES DE COMPUTADORES 2",
                "GRAFOS",
                "CONTROLE LÓGICO DE SISTEMAS",
                "MICROCONTROLADORES",
                "PROJETO DE SISTEMAS DIGITAIS",
                "INTELIGÊNCIA ARTIFICIAL",
                "PROJETO DE SISTEMAS EMBARCADOS",
                "SISTEMAS EM TEMPO REAL",
                "COMUNICAÇÃO DIGITAL",
                "PROCESSADOR DIGITAL DE SINAIS",
                "SISTEMAS ROBÓTICOS",
                "SIMULAÇÃO DISCRETA",
                "GERÊNCIA DE PROJETOS",
                "TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO",
                "TÓPICOS ESPECIAIS EM HARDWARE",
                "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA",
                "TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
                "SISTEMAS DISTRIBUÍDOS "
        );
        cbAverages.getItems().addAll(
                "Média 1",
                "Média 2",
                "Média 3"
        );
    }    
    
}
