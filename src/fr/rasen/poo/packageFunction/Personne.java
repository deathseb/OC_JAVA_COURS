package fr.rasen.poo.packageFunction;

public class Personne {

	private String nom;
	private int age;

	public Personne(int age, String nom) {
		this.age = age;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public int getAge() {
		return age;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
