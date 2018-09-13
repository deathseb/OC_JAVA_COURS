package fr.rasen.swing.pendu.modele;

import java.util.ArrayList;

public class Dico {

	private ArrayList<String> dico = new ArrayList<String>();
	private String mot;

	public Dico(LecteurDico ld) {
		dico = ld.getDico();
	}

	public ArrayList<String> getDico() {
		return dico;
	}

	public void setDico(ArrayList<String> dico) {
		this.dico = dico;
	}

	public String getMot(int nbre) {
		return dico.get(nbre);
	}

	public void setMot(String mot) {
		this.mot = mot;
	}


}
