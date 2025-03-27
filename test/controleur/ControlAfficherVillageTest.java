package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;
import personnages.Druide;
import personnages.Gaulois;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private Druide panoramix;
	private Gaulois bonemine;
	private ControlAfficherVillage controlAfficherVillage;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		panoramix = new Druide("Panoramix",2,5,8);
		village.ajouterHabitant(panoramix);
		bonemine = new Gaulois("Bonemine",5);
		village.ajouterHabitant(bonemine);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] nomsVillageois = village.donnerVillageois();
		assertTrue(nomsVillageois[0].equals("Abraracourcix"));
		assertTrue(nomsVillageois[1].equals("le druide Panoramix"));
		assertFalse(nomsVillageois[1].equals("Panoramix"));
		assertTrue(nomsVillageois[2].equals("Bonemine"));
		assertFalse(nomsVillageois[2].equals("Asterix"));
	}

	@Test
	void testDonnerNomVillage() {
		assertTrue(controlAfficherVillage.donnerNomVillage().equals("le village des irréductibles"));
		assertFalse(controlAfficherVillage.donnerNomVillage().equals("Nom de village non conforme"));
	}

	@Test
	void testDonnerNbEtals() {
		assertTrue(controlAfficherVillage.donnerNbEtals() == 5);
		village.installerVendeur(abraracourcix, "fleur", 5);
		assertTrue(controlAfficherVillage.donnerNbEtals() == 5);
	}
}
