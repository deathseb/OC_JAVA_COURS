package fr.rasen.poo.patternStrategie;

public class Guerrier extends Personnage{

	public Guerrier() {
		this.espritCombatif = new CombatPistolet();
	}
	
	public Guerrier(EspritCombatif e, Soin s, Deplacement d) {
		super(e,s,d);
	}
}
