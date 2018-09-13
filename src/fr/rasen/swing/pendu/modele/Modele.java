package fr.rasen.swing.pendu.modele;

import java.util.ArrayList;

import fr.rasen.swing.pendu.observer.Observable;
import fr.rasen.swing.pendu.observer.Observer;

public class Modele implements Observable{
	
	private Dico dico = new Dico(new LecteurDico());
	private String mot = "";
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();

	public Modele(){

		int nbre = (int)(Math.random()*336529);
		mot = dico.getMot(nbre);
	}

	public String getMot() {
		return mot;
	}

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
