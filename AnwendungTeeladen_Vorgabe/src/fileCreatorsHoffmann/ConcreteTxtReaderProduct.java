package fileCreatorsHoffmann;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcreteTxtReaderProduct extends ReaderProduct {
	
	BufferedReader br;
	
	public ConcreteTxtReaderProduct() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("Teesorte.txt"));
	}

	@Override
	public List<String[]> leseAusDatei() throws IOException {
	    List<String[]> daten = new ArrayList<>();

	    while (true) {
	        String[] input = new String[5];

	        for (int i = 0; i < input.length; i++) {
	            String zeile = br.readLine();
	            if (zeile == null) {
	                return daten;   // Datei zu Ende → alles zurückgeben
	            }
	            input[i] = zeile.trim();
	        }

	        daten.add(input);
	    }
	}


	@Override
	public void schliesseDatei() throws IOException {
		br.close();
	}
}
