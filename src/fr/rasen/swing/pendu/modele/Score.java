package fr.rasen.swing.pendu.modele;

import java.io.Serializable;

public class Score implements Serializable{

	private int score;
	private String nom;
	
	public Score (int s, String n) {
		this.score = s;
		this.nom = n;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom + " -> " + score + "\n";
	}
}
