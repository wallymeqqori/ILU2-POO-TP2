package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import villagegaulois.Village;



class ControlVerifierIdentiteTest {

	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	private Chef abraracourcix;
	private Druide panoramix;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}	
	
	
	
	
	@Test
	void testControlVerifierIdentite() {
		fail("Not yet implemented");
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

}
