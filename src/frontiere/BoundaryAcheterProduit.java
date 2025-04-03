package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
//	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!this.controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis d�sol� " + nomAcheteur + ", mais il faut �tre un habitant de notre village pour commercer ici.");
		}
		else {
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous acheter ?");
			
			Gaulois[] vendeurs = this.controlAcheterProduit.getVendeursParProduit(produit);
			if(vendeurs == null) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.");
			}
			else {
				StringBuilder messageBuilder = new StringBuilder();
				
				messageBuilder.append("Chez quel commer�ant souhaitez-vous acheter des " + produit + " ? :\n");
				
				for(int i = 0; i < vendeurs.length; i++) {
					messageBuilder.append((i+1) + ". " + vendeurs[i].getNom() + "\n");
				}
				
				boolean vendeurChoisi = false;
				int indiceVendeur = -1;
				do {
					indiceVendeur = Clavier.entrerEntier(messageBuilder.toString()) -1;
					vendeurChoisi = indiceVendeur < vendeurs.length;
					
					if(!vendeurChoisi) {
						System.out.println("Veuillez entrer un nombre entre 1 et " + vendeurs.length + ".");
					}
				}
				while(!vendeurChoisi);
				
				Gaulois vendeur = vendeurs[indiceVendeur];
				String nomVendeur = vendeur.getNom();
				
				System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + nomVendeur + ".");
				
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteAchetee = this.controlAcheterProduit.acheterProduit(vendeur, quantite);
				
				if(quantiteAchetee == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
				}
				else if(quantiteAchetee < quantite) {
					System.out.println(
						nomAcheteur + " veut acheter " + quantite + " " + produit
						+ ", malheureusement " + nomVendeur + " n'en a pas plus de " + quantiteAchetee + ".\n"
						+ nomAcheteur + " ach�te tout le stock de " + nomVendeur + "."
					);
				}
				else {
					System.out.println(nomAcheteur + " ach�te " + quantite + " " + produit + " � " + nomVendeur + ".");
				}
			}
		}
	}
}