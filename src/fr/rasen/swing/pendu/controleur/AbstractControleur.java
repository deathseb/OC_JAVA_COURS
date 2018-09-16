package fr.rasen.swing.pendu.controleur;

import fr.rasen.swing.pendu.modele.AbstractModele;

public abstract class AbstractControleur {

	protected AbstractModele pendu;
	protected String carac = "";
	
	public AbstractControleur (AbstractModele pendu) {
		this.pendu = pendu;
	}
	
	public void setCarac(String str) {
		this.carac = str;
		control();
	}
	
	abstract void control();
}
