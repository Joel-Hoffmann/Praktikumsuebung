package business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TeekanneModel {

		private ArrayList<Teekanne> teekannen = new ArrayList<Teekanne>() ;
		private static TeekanneModel instance = null;

		
		public static TeekanneModel getInstance() {
			if (instance == null) {
				instance = new TeekanneModel();
			}
			return instance;
			
		}
		
		private TeekanneModel() {
			super();
		}
		
		public void leseTeekanneAusCsvDatei() throws IOException {
			
			System.out.println(new java.io.File("Teekannen.csv").getAbsolutePath());

				BufferedReader ein = new BufferedReader(new FileReader("Teekannen.csv"));
		 		ArrayList<Teekanne> ergebnis = new ArrayList<Teekanne>(); 
				String zeileStr = ein.readLine();
				while(zeileStr != null) {
					String[] zeile = zeileStr.split(";");
					
		           		ergebnis.add( new Teekanne(zeile[0], zeile[1], zeile[2]));
		           		zeileStr = ein.readLine();
				}    
		 		ein.close();
		 		this.teekannen = ergebnis;
		 	}


		public ArrayList<Teekanne> getTeekannen() {
			return this.teekannen;
		}


		public void setTeekannen(ArrayList<Teekanne> teekannen) {
			this.teekannen = teekannen;
		}	
}
