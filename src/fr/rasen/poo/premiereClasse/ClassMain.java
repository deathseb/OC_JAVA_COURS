package fr.rasen.poo.premiereClasse;

import fr.rasen.poo.exceptions.NomVilleException;
import fr.rasen.poo.exceptions.NombreHabitantException;

public class ClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ville v = new Ville();                
		System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.nbreInstances);
		System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.getNombreInstancesBis());

		try {
			Ville v1 = new Ville("Marseille", 1236, "France");
		} catch (NombreHabitantException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NomVilleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.nbreInstances);
		System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.getNombreInstancesBis());

		try {
			Ville v2 = new Ville("Rio", 321654, "Br�sil");
		} catch (NombreHabitantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomVilleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.nbreInstances);
		System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.getNombreInstancesBis());
	}

}
