package fileCreatorsHoffmann;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProduct extends ReaderProduct {
	
	BufferedReader br;
	
	public ConcreteCsvReaderProduct() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("Teesorte.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] zeile = br.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();		
	}
}
