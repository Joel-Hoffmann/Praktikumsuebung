package fileCreatorsHoffmann;

import java.io.IOException;
import java.util.List;

public abstract class ReaderProduct {

	public abstract List<String[]> leseAusDatei() throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
	
}
