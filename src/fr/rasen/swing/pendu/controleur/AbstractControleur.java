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
	
	public void getNewMot() {
		pendu.getNewMot();
	}
	
	public String getUnderChaine() {
		return pendu.getChaineUnderAffichage();
	}
	
	public String getMot() {
		return pendu.getMot();
	}
	
	abstract void control();
}
