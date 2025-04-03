package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;



class ControlVerifierIdentiteTest {

	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	private Chef abraracourcix;
	private Gaulois gaulois;
	private Gaulois[] liste_gaulois;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		this.controlVerifierIdentite = new ControlVerifierIdentite(village);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		this.gaulois = new Gaulois("Gaulois",1);
		this.village.ajouterHabitant(gaulois);
	}	
	
	
	
	
	@Test
	void testControlVerifierIdentite() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(this.controlVerifierIdentite.verifierIdentite(this.gaulois.getNom()));
		assertFalse(this.controlVerifierIdentite.verifierIdentite("FauxGaulois"));
	}
	@Test

	void testVerifierIdentiteBeaucoupDeGaulois() {

	    this.liste_gaulois = new Gaulois[9];


	    for (int i = 0; i < 9; i++) {
	        this.liste_gaulois[i] = new Gaulois("GAULOIS_" + i, 10);
	        this.village.ajouterHabitant(liste_gaulois[i]);
	    }

	    for (int i = 0; i < 9; i++) {
	        assertTrue(controlVerifierIdentite.verifierIdentite("GAULOIS_" + i));
	    }
	}

}
