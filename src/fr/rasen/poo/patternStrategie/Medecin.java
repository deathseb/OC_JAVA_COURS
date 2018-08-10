package fr.rasen.poo.patternStrategie;

public class Medecin extends Personnage{

	public Medecin() {
		this.soin = new PremierSoin();
	}
	
	public Medecin(EspritCombatif e, Soin s, Deplacement d) {
		super(e,s,d);
	}
}

