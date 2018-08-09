package fr.rasen.poo.héritage;

import fr.rasen.poo.premiereClasse.Ville;

public class HeritageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Capitale cap = new Capitale("Paris", 654987, "France", "la tour Eiffel");
		System.out.println("\n"+cap.decrisToi());
		
		Ville[] tableau = new Ville[6];
		String[] tab = {"Marseille", "Lille", "Caen", "Lyon", "Paris", "Nantes"};
		int[] tab2 = {123456, 78456, 654987, 75832165, 1594, 213};
		
		for(int i=0; i<6; i++) {
			if(i<3) {
				Ville V = new Ville(tab[i], tab2[i], "france");
				tableau[i] = V;
			}
			else {
				Capitale C = new Capitale(tab[i],tab2[i], "france", "la tour Eiffel");
				tableau[i] = C;
			}
		}
		
		for(Object obj : tableau) {
			System.out.println(obj.toString()+"\n");
		}
	}

}
