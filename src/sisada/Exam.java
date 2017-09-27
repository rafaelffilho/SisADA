/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author anaboth
 */
public class Exam {

    private String name;
    private String discipline;
    private String average;
    private double weight;
    private double score;
    
    private ObservableList obs;
    
    public void save(){
        try {
            File arc = new File("db.csv");
            FileWriter out = new FileWriter(arc, true);
            out.write(this.discipline + "," + this.average + "," + this.name + "," + this.weight + "," + this.score + "\n");
            out.close();
        } catch (Exception e) {}
    }
    
    public void update() throws IOException{
        File f = new File("db.csv");
        List<String> lines = Files.readAllLines(f.toPath());
        lines.remove(ExamsController.selectedIndex);
        lines.add(ExamsController.selectedIndex, this.discipline + "," + this.average + "," + this.name + "," + this.weight + "," + this.score);
        Files.write(f.toPath(), lines, StandardCharsets.UTF_8);
    }
    
    public static ArrayList <Exam> getExamsList(){
        
        ArrayList <Exam> exam = new ArrayList();
        ArrayList <String> string = new ArrayList();
        
        try {
            FileReader reader = new FileReader("db.csv");
            BufferedReader br = new BufferedReader(reader);
            String s;
            
            while ((s = br.readLine()) != null) {
                string.add(s);
            }
            
            for (int i = 0; i < string.size(); i++) {
                
                Exam a = new Exam();
                
                String[] splited = string.get(i).split(",");
                
                a.setDiscipline(splited[0]);
                a.setAverage(splited[1]);
                a.setName(splited[2]);
                a.setWeight(Double.parseDouble(splited[3]));
                a.setScore(Double.parseDouble(splited[4]));
                
                exam.add(a);
            }
            
            reader.close();
        } catch (Exception e) {}
        
        
        return exam;
    }
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the discipline
     */
    public String getDiscipline() {
        return discipline;
    }

    /**
     * @param discipline the discipline to set
     */
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    /**
     * @return the average
     */
    public String getAverage() {
        return average;
    }

    /**
     * @param average the average to set
     */
    public void setAverage(String average) {
        this.average = average;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }
    
}
