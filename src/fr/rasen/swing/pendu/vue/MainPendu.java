package fr.rasen.swing.pendu.vue;

import fr.rasen.swing.pendu.controleur.AbstractControleur;
import fr.rasen.swing.pendu.controleur.Controleur;
import fr.rasen.swing.pendu.modele.AbstractModele;
import fr.rasen.swing.pendu.modele.Modele;

public class MainPendu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractModele am = new Modele();
		AbstractControleur ac = new Controleur(am);
		Fenetre f = new Fenetre(ac);
		am.addObserver(f);
	}

}
