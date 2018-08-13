package fr.rasen.poo.collections;

import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add(12);
		al.add("Une chaine de caractères");
		al.add(12.20f);
		al.add('d');
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println("Donnée à l'indice " + i + " = " + al.get(i));
		}
	}

}
