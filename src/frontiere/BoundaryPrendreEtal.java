package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!this.controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol� " + nomVendeur + ", mais il faut �tre un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour vendeur " + nomVendeur + ", je vais regarder si je peux trouver un �tal.");
			
			if(!this.controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol�" + nomVendeur + ", je n'ai plus d'�tal qui ne soit pas d�j� occup�e.");
			}
			else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un �tal pour vous !\nIl me faudrait quelques renseignements :");
		
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		
		int indiceEtal = this.controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if(indiceEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + (indiceEtal+1));
		}
	}
}
