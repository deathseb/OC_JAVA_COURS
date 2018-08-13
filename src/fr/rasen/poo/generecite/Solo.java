package fr.rasen.poo.generecite;

public class Solo<T> {
	private T valeur;
	
	public Solo() {
		this.valeur = null;
	}
	
	public Solo (T val) {
		this.valeur = val;
	}

	public T getValeur() {
		return valeur;
	}

	public void setValeur(T valeur) {
		this.valeur = valeur;
	}
	
	

}
