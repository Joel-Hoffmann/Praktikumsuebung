package fileCreatorsHoffmann;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcreteCsvReaderProduct extends ReaderProduct {
	
	BufferedReader br;
	
	public ConcreteCsvReaderProduct() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("TeesortenAusgabe.csv"));
	}
	
	@Override
	public void schliesseDatei() throws IOException {
		br.close();		
	}
	
	@Override
	public List<String[]> leseAusDatei() throws IOException {
		List<String[]> daten = new ArrayList<>();
		String line;
		
		while((line = br.readLine()) != null) {
			daten.add(line.split(";"));
		}

		return daten;
	}
}


