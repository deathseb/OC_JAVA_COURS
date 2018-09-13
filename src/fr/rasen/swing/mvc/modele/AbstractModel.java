package fr.rasen.swing.mvc.modele;

import java.util.ArrayList;

import fr.rasen.swing.mvc.Observer.Observable;
import fr.rasen.swing.mvc.Observer.Observer;

public abstract class AbstractModel implements Observable{

	protected double result =0;
	protected String operateur = "", operande = "";
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	public abstract void reset();
	
	public abstract void calcul();
	
	public abstract void getResultat();
	
	public abstract void setNombre(String nbre);
	
	public abstract void setOperateur(String operateur);
	
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(String str) {
		if(str.matches("^0[0-9]+"))
			str = str.substring(1, str.length());
		
		for(Observer obs : listObserver) {
			obs.update(str);
		}
	}
	
	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
	}
}
