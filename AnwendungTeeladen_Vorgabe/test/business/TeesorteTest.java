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
	
	//Testfall: 325, GutenTagTee, ja, SchwarzerTee, Zitrone 

	@Test
	void test() {
		this.t = new Teesorte(325, "GutenTagTee", "SchwarzerTee", "ja", new String[] {"Zitrone"});
		assertTrue(() -> this.t.getBezeichnung().equals("GutenTagTee"));
		
		Throwable exc = assertThrows(IllegalArgumentException.class, () -> {new Teesorte(325, "GutenTagTee", "SchwarzerTee", "ja", null);});
		
	} 
}





