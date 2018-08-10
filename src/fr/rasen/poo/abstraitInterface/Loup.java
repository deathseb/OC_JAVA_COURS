package fr.rasen.poo.abstraitInterface;

public class Loup extends Canin{

	public Loup(String couleur, int poids) {
		this.couleur = couleur;
		this.poids = poids;
	}

	@Override
	void crier() {
		// TODO Auto-generated method stub
		System.out.println("Je hurle à la Lune en faisant ouhouh.");
	}

}
