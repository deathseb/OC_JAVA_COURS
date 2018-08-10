package fr.rasen.poo.abstraitInterface;

public abstract class Animal {

	protected int poids;
	protected String couleur;

	public void manger() {
		System.out.println("Je mange de la viande.");
	}
	public void boire() {
		System.out.println("Je bois de l'eau.");
	}
	
	public String toString() {
		String str = "Je suis un object de la " + this.getClass() + ", je suis " + this.couleur
				+ ", je pèse " + this.poids;
		return str;
		
	}
	abstract void deplacement();
	abstract void crier();
	
}
