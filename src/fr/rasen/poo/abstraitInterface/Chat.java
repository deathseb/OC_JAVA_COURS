package fr.rasen.poo.abstraitInterface;

public class Chat extends Felin{


	public Chat(String couleur, int poids) {
		this.couleur = couleur;
		this.poids = poids;
	}

	@Override
	void crier() {
		// TODO Auto-generated method stub
		System.out.println("Je miaule sur les toits.");
	}

}
