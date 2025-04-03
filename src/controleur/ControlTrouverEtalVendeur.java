package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Gaulois vendeur = this.village.trouverHabitant(nomVendeur);
		if(vendeur == null){
			return null;
		}
		else {
			return this.village.rechercherEtal(vendeur);
		}
	}
}
