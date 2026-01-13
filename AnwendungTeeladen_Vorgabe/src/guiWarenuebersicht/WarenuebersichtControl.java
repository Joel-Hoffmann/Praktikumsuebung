package guiWarenuebersicht;

import business.TeeladenModel;

import java.io.IOException;

import business.TeekanneModel;

import javafx.stage.Stage;
import ownUtil.Observer;
public class WarenuebersichtControl implements Observer {
	
	private WarenuebersichtView warenuebersichtView;
	private TeeladenModel teesModel;
	private TeekanneModel teekanneModel;
	
	public WarenuebersichtControl(Stage primaryStage){
 		this.teesModel = TeeladenModel.getInstance(); 
 		this.teesModel.addObserver(this);
 		
 		this.teekanneModel = TeekanneModel.getInstance();
 		
		this.warenuebersichtView = new WarenuebersichtView(this, primaryStage, teesModel, teekanneModel);
		
	}
	
	public void leseTeekannenAusCsvDatei() {
	    try {
	        this.teekanneModel.leseTeekanneAusCsvDatei();
	    } catch (IOException exc) {
	        this.warenuebersichtView.zeigeInformationsfensterAn(
	            "IOException beim Lesen von Teekannen!");
	    } catch (Exception exc) {
	        this.warenuebersichtView.zeigeInformationsfensterAn(
	            "Unbekannter Fehler beim Lesen von Teekannen!");
	    }
	}
	
	@Override
	public void update() {
		warenuebersichtView.zeigeTeesAn();
	}
}

