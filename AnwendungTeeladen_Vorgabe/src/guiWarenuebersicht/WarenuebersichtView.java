package guiWarenuebersicht;

import business.Teekanne;

import business.TeekanneModel;
import business.TeeladenModel;
import business.Teesorte;
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
	private TeekanneModel teekanneModel;
	
	//---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new  Pane();
	private Label lblAnzeigeTees     = new Label("Anzeige Tees");
	private TextArea txtAnzeigeTees  = new TextArea();
	private Button btnAnzeigeTees = new Button("Anzeige");
	
	// Grafische Oberfläche linke Seite: Teekannen
	private Label lblAnzeigeTeekannen = new Label("Anzeige Teekannen");
	private TextArea txtAnzeigeTeekannen = new TextArea();
	private Button btnCsvImportTeekannen = new Button("csv-Import und Anzeige");
	
	//-------Ende Attribute der grafischen Oberflaeche-------

	public WarenuebersichtView(WarenuebersichtControl warenuebersichtControl, Stage primaryStage, TeeladenModel teesModel, TeekanneModel teekanneModel)
	{
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige der Warenuebersicht");
		primaryStage.show();
		this.warenuebersichtControl = warenuebersichtControl;
		this.teesModel = teesModel;
		this.teekanneModel = teekanneModel;
		
		//this.initKomponenten();
		
		this.initKomponentenTeekannen();
		this.initKomponentenTees();
		
		//this.initListener();
		
		this.initListenerTeekannen();
		this.initListenerTees();
	}

// 	private void initKomponenten(){
//    	// Label
// 		Font font = new Font("Arial", 20);
//       	lblAnzeigeTees.setLayoutX(310);
//    		lblAnzeigeTees.setLayoutY(40);
//    		lblAnzeigeTees.setFont(font);
//    		lblAnzeigeTees.setStyle("-fx-font-weight: bold;"); 
//       	pane.getChildren().add(lblAnzeigeTees);           
//       	// Textbereich	
//        	txtAnzeigeTees.setEditable(false);
//     		txtAnzeigeTees.setLayoutX(310);
//    		txtAnzeigeTees.setLayoutY(90);
//     		txtAnzeigeTees.setPrefWidth(220);
//    		txtAnzeigeTees.setPrefHeight(185);
//       	pane.getChildren().add(txtAnzeigeTees);        	
//        	// Button
//          	btnAnzeigeTees.setLayoutX(310);
//        	btnAnzeigeTees.setLayoutY(290);
//        	pane.getChildren().add(btnAnzeigeTees); 
//   }
	
	
	// Getrennte InitKomponenten
	private void initKomponentenTeekannen() {
	    Font font = new Font("Arial", 20);

	    lblAnzeigeTeekannen.setLayoutX(20);
	    lblAnzeigeTeekannen.setLayoutY(40);
	    lblAnzeigeTeekannen.setFont(font);
	    lblAnzeigeTeekannen.setStyle("-fx-font-weight: bold;");

	    txtAnzeigeTeekannen.setEditable(false);
	    txtAnzeigeTeekannen.setLayoutX(20);
	    txtAnzeigeTeekannen.setLayoutY(90);
	    txtAnzeigeTeekannen.setPrefWidth(220);
	    txtAnzeigeTeekannen.setPrefHeight(185);

	    btnCsvImportTeekannen.setLayoutX(20);
	    btnCsvImportTeekannen.setLayoutY(290);

	    pane.getChildren().addAll(lblAnzeigeTeekannen, txtAnzeigeTeekannen, btnCsvImportTeekannen);
	}
	
	private void initKomponentenTees() {
	    Font font = new Font("Arial", 20);

	    lblAnzeigeTees.setLayoutX(310);
	    lblAnzeigeTees.setLayoutY(40);
	    lblAnzeigeTees.setFont(font);
	    lblAnzeigeTees.setStyle("-fx-font-weight: bold;");

	    txtAnzeigeTees.setEditable(false);
	    txtAnzeigeTees.setLayoutX(310);
	    txtAnzeigeTees.setLayoutY(90);
	    txtAnzeigeTees.setPrefWidth(220);
	    txtAnzeigeTees.setPrefHeight(185);

	    btnAnzeigeTees.setLayoutX(310);
	    btnAnzeigeTees.setLayoutY(290);

	    pane.getChildren().addAll(lblAnzeigeTees, txtAnzeigeTees, btnAnzeigeTees);
	}
	
	// Getrennte InitListener
	private void initListenerTeekannen() {
	    btnCsvImportTeekannen.setOnAction(e -> zeigeTeekannenAn());
	}
	
	private void initListenerTees() {
	    btnAnzeigeTees.setOnAction(e -> zeigeTeesAn());
	}

   
//   private void initListener() {
//	   
//	    btnAnzeigeTees.setOnAction(e -> zeigeTeesAn());
//
//   }
   
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
    
    // Teekannen einlesen, wahrscheinlich vorgegeben
    public void zeigeTeekannenAn() {
        warenuebersichtControl.leseTeekannenAusCsvDatei();

        if (teekanneModel.getTeekannen().size() > 0) {
            StringBuffer text = new StringBuffer();
            for (Teekanne tk : teekanneModel.getTeekannen()) {
                text.append(tk.gibTeekanneZurueck(' ') + "\n");
            }
            txtAnzeigeTeekannen.setText(text.toString());
        } else {
            zeigeInformationsfensterAn("Es gibt keine Teekanne in der csv-Datei!");
        }
    }
   
    public void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	  
}

