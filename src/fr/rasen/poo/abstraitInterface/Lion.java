package fr.rasen.poo.abstraitInterface;

public class Lion extends Felin {


	public Lion(String couleur, int poids) {
		this.couleur = couleur;
		this.poids = poids;
	}

	@Override
	void crier() {
		// TODO Auto-generated method stub
		System.out.println("Je rugis dans la savane.");
	}

}
