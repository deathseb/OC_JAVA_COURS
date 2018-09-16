package fr.rasen.swing.pendu.modele;

public class Modele extends AbstractModele{

	private String chaineUnderAffichage = "";
	private String chaineUnder ="";
	private int compteurSansEspace;
	private int compteurAvecEspace;

	public Modele(){
		super();
		for (int i =0; i < this.mot.length(); i++) {
			chaineUnderAffichage += "_ ";
		}
	}

	public void test (String carac) {
		compteurSansEspace = compteurAvecEspace = 0;
		chaineUnder = "";
		for (int i = 0; i < this.mot.length(); i++) {
			if (this.mot.charAt(i) == carac.charAt(0)) {
				chaineUnder = chaineUnder + carac ;
			} else {
				chaineUnder += "_";
			}
		}
		String chaineUnderAffichage2 = chaineUnderAffichage;
		chaineUnderAffichage = "";
		for (int i = 0; i < this.mot.length(); i++) {
			if (chaineUnder.charAt(i) != '_' && chaineUnder.charAt(i) != ' ') {
				chaineUnderAffichage = chaineUnderAffichage + chaineUnder.charAt(compteurSansEspace) + " ";
			} else {
				chaineUnderAffichage = chaineUnderAffichage + chaineUnderAffichage2.charAt(compteurAvecEspace) + " ";
			}
			compteurAvecEspace += 2;
			compteurSansEspace ++;
		}
		this.notifyObserver(chaineUnderAffichage);
	}

	public String getChaineUnderAffichage() {
		return chaineUnderAffichage;
	}

	public void setChaineUnderAffichage(String chaineUnderAffichage) {
		this.chaineUnderAffichage = chaineUnderAffichage;
	}
}
