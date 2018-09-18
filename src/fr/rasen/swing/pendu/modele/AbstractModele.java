package fr.rasen.swing.pendu.modele;

import java.util.ArrayList;

import fr.rasen.swing.pendu.observer.Observable;
import fr.rasen.swing.pendu.observer.Observer;

public abstract class AbstractModele implements Observable{
	
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	protected String chaineUnderAffichage = "";
	protected String chaineUnder ="";
	private Dico dico = new Dico(new LecteurDico());
	protected String mot = "";

	public AbstractModele() {
		getNewMot();
	}
	
	
	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	

	public String getChaineUnderAffichage() {
		return chaineUnderAffichage;
	}


	public void setChaineUnderAffichage(String chaineUnderAffichage) {
		this.chaineUnderAffichage = chaineUnderAffichage;
	}


	public String getChaineUnder() {
		return chaineUnder;
	}


	public void setChaineUnder(String chaineUnder) {
		this.chaineUnder = chaineUnder;
	}


	public void getNewMot() {
		int nbre = (int)(Math.random()*336529);
		mot = dico.getMot(nbre);
		chaineUnderAffichage = "";
		chaineUnder = "";
		for (int i =0; i<mot.length(); i++) {
			chaineUnderAffichage = chaineUnderAffichage + "_ ";
			chaineUnder = chaineUnder + "_";
		}
	}
	
	public abstract void test(String carac);
	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		this.listObserver.add(o);
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		listObserver = new ArrayList<Observer>();
	}

	@Override
	public void notifyObserver(String str) {
		// TODO Auto-generated method stub
		for(Observer obs : listObserver) {
			obs.update(str);
		}
	}
}
