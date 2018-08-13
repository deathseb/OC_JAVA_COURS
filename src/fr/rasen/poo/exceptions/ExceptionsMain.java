package fr.rasen.poo.exceptions;

import fr.rasen.poo.premiereClasse.Ville;

public class ExceptionsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int j = 20, i = 0;
		try {
			System.out.println(j/i);
		} catch (ArithmeticException e) {
			System.out.println("Division par zéro." + e.getMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("Coucou toi.");
		}

		Ville v = null;
		try {
			v = new Ville("Rennes", 12000, "France");
		} catch (NombreHabitantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NomVilleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if ( v == null)
				v = new Ville();
		}
		System.out.println(v.toString());

	}

}
