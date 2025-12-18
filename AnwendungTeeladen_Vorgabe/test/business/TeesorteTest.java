package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeesorteTest {
	
	Teesorte t;
	
	@AfterEach
	void tearDown() throws Exception {
		this.t = null;
	}

	@Test
	void test() {
		this.t = new Teesorte(8, "Wintertee", "Kraeutertee", "ohne K.", new String[] {"Zimtbluete"});
		assertTrue(() -> this.t.getBezeichnung().equals("Wintertee"));
		assertTrue(() -> this.t.getKategorie().equals("Kraeutertee"));
	}
}




