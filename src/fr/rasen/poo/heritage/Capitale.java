package fr.rasen.poo.heritage;

import java.util.Objects;

import fr.rasen.poo.exceptions.NomVilleException;
import fr.rasen.poo.exceptions.NombreHabitantException;
import fr.rasen.poo.premiereClasse.Ville;

public class Capitale extends Ville {
	private String monument;

	public Capitale() {
		super();
		monument = "aucun";
	}

	public Capitale(String nom, int hab, String pays, String monument) throws NombreHabitantException, NomVilleException {
		super(nom, hab, pays);
		this.monument = monument;
	}

	public String decrisToi() {
		String str = super.decrisToi() + "\n \t ==>>" + this.monument + " en est un monument";
		System.out.println("Invocation de super.decrisToi()");
		return str;
	}

	public String getMonument() {
		return monument;
	}

	public void setMonument(String monument) {
		this.monument = monument;
	}

	public String toString() {
		String str = super.toString() + "\n \t ==>>" + this.monument + " en est un monument";
		return str;
	}

	public int hashCode() {
		return Objects.hash(categorie, nbreHabitants, nomPays, nomVille, monument);
	}

	public boolean equals(Object obj) {
		if(this == obj)
			return true;

		if(getClass() != obj.getClass())
			return false;

		Capitale other = (Capitale) obj;
		return Objects.equals(other.getCategorie(), this.getCategorie()) &&
				Objects.equals(other.getNom(), this.getNom() )&& 
				Objects.equals(other.getNombreHabitants(), this.getNombreHabitants())&&
				Objects.equals(other.getNomPays(), this.getNomPays() )&&
				Objects.equals(other.getMonument(), this.getMonument());
	}
}
