package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private Druide panoramix;
	private Gaulois bonemine;
	private ControlLibererEtal controlLibererEtal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeurTest;
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		panoramix = new Druide("Panoramix",2,5,8);
		village.ajouterHabitant(panoramix);
		bonemine = new Gaulois("Bonemine",5);
		village.ajouterHabitant(bonemine);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeurTest);
	}
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}
	@Test
	void testisVendeur() {
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
	}

}
