package fileCreatorsHoffmann;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtReaderProduct extends ReaderProduct {
	
	BufferedReader br;
	
	public ConcreteTxtReaderProduct() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("Teesorte.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] input = new String[5];
		for (int i = 0; i < input.length; i++) {
			String zeile = br.readLine();
			if(zeile == null)
				throw new IOException("Leer!");	
			input[i] = zeile.trim();
		}
		return input;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
	}
}
