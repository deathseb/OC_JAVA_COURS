package fr.rasen.poo.patternStrategie;

public abstract class Personnage {

	protected EspritCombatif espritCombatif = new Pacifiste();
	protected Soin soin = new AucunSoin();
	protected Deplacement deplacement = new Marcher();
	
	public Personnage() {
		
	}
	
	public Personnage (EspritCombatif ec, Soin s, Deplacement d) {
		this.espritCombatif = ec;
		this.soin = s;
		this.deplacement = d;
	}
	
	public void seDeplacer() {
		deplacement.deplacer();
	}
	
	public void combattre() {
		espritCombatif.combat();
	}
	
	public void soigner() {
		soin.soigner();
	}

	public void setEspritCombatif(EspritCombatif espritCombatif) {
		this.espritCombatif = espritCombatif;
	}

	public void setSoin(Soin soin) {
		this.soin = soin;
	}

	public void setDeplacement(Deplacement deplacement) {
		this.deplacement = deplacement;
	}
	

}
