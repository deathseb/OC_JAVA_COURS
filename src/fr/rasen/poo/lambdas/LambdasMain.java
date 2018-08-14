package fr.rasen.poo.lambdas;

public class LambdasMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dialoguer d = new Dialoguer() {
			public void parler(String question) {
				System.out.println("Tu as dis : " + question);
			}
		};
		d.parler("Bonjour.");
		
		Dialoguer d2 = (s) -> System.out.println("Tu as dis : " + s);
		d2.parler("Bonjour.");
	}

}
