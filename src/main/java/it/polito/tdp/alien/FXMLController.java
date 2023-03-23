package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.copy.Dizionario;
import java.util.*;

public class FXMLController {
	
	private Dizionario model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void doClear(ActionEvent event) {
    	txtParola.setText(null);

    }

    @FXML
    void doTraduzione(ActionEvent event) {
    	String[] parole = txtParola.getText().split(" ");
    	
    	if( parole.length == 2) {
    		Dizionario.Outcome risultato =  this.model.AggiungiParola(parole);
    		if( risultato == Dizionario.Outcome.Aggiunto) 
    			txtRisultato.setText("Parola aggiunta al dizionario.");
    		if( risultato == Dizionario.Outcome.ErrCaratteri)
    			txtRisultato.setText("Inserire solo caratteri alfabetici.");
    		if( risultato == Dizionario.Outcome.ErrFormato)
    			txtRisultato.setText("Inserire le parole in un formato valido.");
    	}
    	
    	if( parole.length == 0 || parole.length == 1) {
    		String result = this.model.RitornaParola(txtParola.getText());
    		txtRisultato.setText(result);
    	}
    	
    	

    	
    	
    	
    	
    	
    	
    	
    	
    }
    
    public void setModel( Dizionario model) {
		this.model = model;
	}
	

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        
        

    }

}
