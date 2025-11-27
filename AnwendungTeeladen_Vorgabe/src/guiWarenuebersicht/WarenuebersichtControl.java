package guiWarenuebersicht;

import business.TeeladenModel;

import javafx.stage.Stage;
import ownUtil.Observer;
public class WarenuebersichtControl implements Observer {	
	private WarenuebersichtView warenuebersichtView;
	private TeeladenModel teesModel;
	public WarenuebersichtControl(Stage primaryStage){
 		this.teesModel = TeeladenModel.getInstance(); 
 		this.teesModel.addObserver(this);
		this.warenuebersichtView 
		 	= new WarenuebersichtView(this, primaryStage,
			teesModel);
	}
	@Override
	public void update() {
		warenuebersichtView.zeigeTeesAn();
	}
}
