package guiWarenuebersicht;

import business.TeeladenModel;
import business.Teesorte;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class WarenuebersichtView {
	
	private WarenuebersichtControl warenuebersichtControl;
	private TeeladenModel teesModel;
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeTees     
 		= new Label("Anzeige Tees");
    	private TextArea txtAnzeigeTees  = new TextArea();
    	private Button btnAnzeigeTees = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public WarenuebersichtView(WarenuebersichtControl warenuebersichtControl, Stage primaryStage, TeeladenModel teesModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige der Warenuebersicht");
    		primaryStage.show();
    		this.warenuebersichtControl 
 			= warenuebersichtControl;
 		this.teesModel = teesModel;
 		this.initKomponenten();
		this.initListener();
    	}

 	private void initKomponenten(){
    	// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeTees.setLayoutX(310);
    		lblAnzeigeTees.setLayoutY(40);
    		lblAnzeigeTees.setFont(font);
    		lblAnzeigeTees.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeTees);           
       	// Textbereich	
        	txtAnzeigeTees.setEditable(false);
     		txtAnzeigeTees.setLayoutX(310);
    		txtAnzeigeTees.setLayoutY(90);
     		txtAnzeigeTees.setPrefWidth(220);
    		txtAnzeigeTees.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeTees);        	
        	// Button
          	btnAnzeigeTees.setLayoutX(310);
        	btnAnzeigeTees.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeTees); 
   }
   
   private void initListener() {
	   
	    btnAnzeigeTees.setOnAction(e -> zeigeTeesAn());

    }
   
    public void zeigeTeesAn(){
    		if (teesModel.getTs().size() > 0) {
    			StringBuffer text = new StringBuffer();
    			for(Teesorte ts : teesModel.getTs())
    				text.append(ts.gibTeesorteZurueck(' ') + "\n");
    			txtAnzeigeTees.setText(text.toString());
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Tee aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	  
}

