package fr.rasen.poo.heritage;

import fr.rasen.poo.exceptions.NomVilleException;
import fr.rasen.poo.exceptions.NombreHabitantException;
import fr.rasen.poo.premiereClasse.Ville;

public class HeritageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Capitale cap;
		try {
			cap = new Capitale("Paris", 654987, "France", "la tour Eiffel");
			System.out.println("\n"+cap.decrisToi());
		} catch (NombreHabitantException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NomVilleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Ville[] tableau = new Ville[6];
		String[] tab = {"Marseille", "Lille", "Caen", "Lyon", "Paris", "Nantes"};
		int[] tab2 = {123456, 78456, 654987, 75832165, 1594, 213};

		for(int i=0; i<6; i++) {
			if(i<3) {
				Ville V;
				try {
					V = new Ville(tab[i], tab2[i], "france");
					tableau[i] = V;
				} catch (NombreHabitantException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NomVilleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			else {
				Capitale C;
				try {
					C = new Capitale(tab[i],tab2[i], "france", "la tour Eiffel");
					tableau[i] = C;
				} catch (NombreHabitantException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NomVilleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		for(Object obj : tableau) {
			System.out.println(obj.toString()+"\n");
		}
	}

}
