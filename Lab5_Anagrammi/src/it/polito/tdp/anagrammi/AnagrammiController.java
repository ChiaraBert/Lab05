package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.*;
import it.polito.tdp.anagrammi.DAO.*;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
									
public class AnagrammiController {  
									
	private Model m;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtField;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;
    
    public void setModel(Model model) {
		this.m=model;
		}
  
    @FXML
    void doCalcola(ActionEvent event) {
    	String parola=txtField.getText();
    	
    	if(!parola.matches("[a-zA-Z]*")){
			txtCorretti.setText("Inserire solo caratteri alfabetici");
			return;}
    	
    	/*if(m.CercaParola(parola)==false){
			txtCorretti.appendText("Parola non presente nel dizionario\n");
			return;
		}*/
    	
    	String ris="";
    	String ris2="";
    	
    	m.risolvi(parola);
    	
    	if(!m.getParoleGiuste().isEmpty()){
    	for(String s: m.getParoleGiuste()){
    		ris+=s+"\n";
    	}}
    	
    	if(!m.getParoleSbaliate().isEmpty()){
    	for(String s: m.getParoleSbaliate()){
    		ris2+=s+"\n";
    	}}	
    	
    	txtCorretti.appendText(ris);
    	txtErrati.appendText(ris2);

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtErrati.clear();
    	txtCorretti.clear();
    	txtField.clear();

    }

    @FXML
    void initialize() {
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	
}

