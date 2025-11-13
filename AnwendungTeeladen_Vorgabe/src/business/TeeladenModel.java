package business;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import fileCreatorsHoffmann.ConcreteCsvReaderCreator;
import fileCreatorsHoffmann.ConcreteTxtReaderCreator;
import fileCreatorsHoffmann.ReaderCreator;
import fileCreatorsHoffmann.ReaderProduct;

public class TeeladenModel {

	// Attribute / Objekte
	private Teesorte ts;
	
	// Konstruktormethode
	public void createTeesorte(int identnummer, String bezeichnung, String kategorie,String mitKoffein, String[] enthalteneKraeuter) {
		this.ts = new Teesorte(identnummer, bezeichnung, kategorie, mitKoffein, enthalteneKraeuter);
	}
	
	// Getter & Setter
	public Teesorte getTs() {
		return ts;
	}

	public void setTs(Teesorte ts) {
		this.ts = ts;
	}
	
	// Methoden / Datenverarbeitung	
	public void leseAusCsvDatei() throws IOException {
		ReaderCreator rc = new ConcreteCsvReaderCreator();
		ReaderProduct rp = rc.factoryMethod();
		String[] zeile = rp.leseAusDatei();
		createTeesorte(Integer.parseInt(zeile[0]), zeile[1], zeile[2], zeile[3], zeile[4].split("_"));
		rp.schliesseDatei();
	}	
	
	public void leseAusTxtDatei() throws IOException {
		ReaderCreator rc = new ConcreteTxtReaderCreator();
		ReaderProduct rp = rc.factoryMethod();
		String[] zeile = rp.leseAusDatei();
		createTeesorte(Integer.parseInt(zeile[0]), zeile[1], zeile[2], zeile[3], zeile[4].split("_"));
		rp.schliesseDatei();
	}	
	
	public void schreibeTeesInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("TeesortenAusgabe.csv", true));
		aus.write(ts.gibTeesorteZurueck(';'));
		aus.close();
	}
}
