package business;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import fileCreatorsHoffmann.ConcreteCsvReaderCreator;
import fileCreatorsHoffmann.ConcreteTxtReaderCreator;
import fileCreatorsHoffmann.ReaderCreator;
import fileCreatorsHoffmann.ReaderProduct;
import ownUtil.Observable;
import ownUtil.Observer;

public class TeeladenModel implements Observable {

	// Attribute / Objekte
	private Teesorte ts;
	
	// Liste von Observern
	private Vector<Observer> observer = new Vector<Observer>();
	
	// Singleton
	// 1. statisches Attribut
	private static TeeladenModel theInstance;
	
	// 2. privater Konstruktor
	private TeeladenModel() {
		
	}
	
	// 3. statische Methode getInstance;
	public static TeeladenModel getInstance() {
		if(theInstance == null)
			theInstance = new TeeladenModel();
		return theInstance;
	}
	
	// Konstruktormethode
	public void createTeesorte(int identnummer, String bezeichnung, String kategorie,String mitKoffein, String[] enthalteneKraeuter) {
		this.ts = new Teesorte(identnummer, bezeichnung, kategorie, mitKoffein, enthalteneKraeuter);
		notifyObservers();
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
		notifyObservers();
	}	
	
	public void leseAusTxtDatei() throws IOException {
		ReaderCreator rc = new ConcreteTxtReaderCreator();
		ReaderProduct rp = rc.factoryMethod();
		String[] zeile = rp.leseAusDatei();
		createTeesorte(Integer.parseInt(zeile[0]), zeile[1], zeile[2], zeile[3], zeile[4].split("_"));
		rp.schliesseDatei();
		notifyObservers();
	}	
	
	public void schreibeTeesInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("TeesortenAusgabe.csv", true));
		aus.write(ts.gibTeesorteZurueck(';'));
		aus.close();
	}

	@Override
	public void addObserver(Observer obs) {
		observer.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observer.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (Observer obs : observer) {
			obs.update();
		}
	}
}
