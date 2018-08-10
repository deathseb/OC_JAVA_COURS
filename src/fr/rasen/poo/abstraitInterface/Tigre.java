package fr.rasen.poo.abstraitInterface;

public class Tigre extends Felin{

	

	public Tigre(String couleur, int poids) {
		this.couleur = couleur;
		this.poids = poids;
	}

	@Override
	void crier() {
		// TODO Auto-generated method stub
		System.out.println("Je grogne très fort.");
	}

}
