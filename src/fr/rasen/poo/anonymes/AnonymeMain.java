package fr.rasen.poo.anonymes;

import fr.rasen.poo.patternStrategie.Guerrier;
import fr.rasen.poo.patternStrategie.Operation;
import fr.rasen.poo.patternStrategie.Personnage;
import fr.rasen.poo.patternStrategie.Soin;

public class AnonymeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personnage pers = new Guerrier();
		pers.soigner();
		pers.setSoin(new Operation());
		pers.soigner();
		
		pers.setSoin(new Soin() {
			public void soigner() {
				System.out.println("Je soigne avec une classe anonyme.");
			}
		});
	}

}
