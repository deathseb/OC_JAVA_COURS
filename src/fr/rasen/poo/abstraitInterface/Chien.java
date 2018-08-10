package fr.rasen.poo.abstraitInterface;

public class Chien extends Canin implements Rintintin{



	public Chien(String couleur, int poids) {
		this.couleur = couleur;
		this.poids = poids;
	}

	public Chien() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void crier() {
		// TODO Auto-generated method stub
		System.out.println("J'aboie sans raison.");
	}

	@Override
	public void faireCalin() {
		// TODO Auto-generated method stub
		System.out.println("Je te fais un câlin.");
	}

	@Override
	public void faireLechouille() {
		// TODO Auto-generated method stub
		System.out.println("Je fais le beau.");
	}

	@Override
	public void faireLeBeau() {
		// TODO Auto-generated method stub
		System.out.println("Je fais des léchouilles.");
	}

}
