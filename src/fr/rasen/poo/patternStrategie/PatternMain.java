package fr.rasen.poo.patternStrategie;

public class PatternMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnage[] tPers = {new Guerrier(), new Civil(), new Medecin()};
		
		for(int i = 0; i< tPers.length; i++) {
			System.out.println("\nInstance de " + tPers[i].getClass().getName());
			System.out.println("********************************************************");
			tPers[i].combattre();
			tPers[i].seDeplacer();
			tPers[i].soigner();
		}
	}

}
