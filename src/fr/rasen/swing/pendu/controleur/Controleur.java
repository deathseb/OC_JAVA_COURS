package fr.rasen.swing.pendu.controleur;

import fr.rasen.swing.pendu.modele.AbstractModele;

public class Controleur extends AbstractControleur{

	public Controleur (AbstractModele am) {
		super(am);
	}

	@Override
	void control() {
		// TODO Auto-generated method stub
		switch (this.carac) {

		case "e" : 
			this.pendu.test(this.carac);
			this.pendu.test("é");
			this.pendu.test("è");
			this.pendu.test("ê");
			this.pendu.test("ë");
			break;
			
		case "a": 
			this.pendu.test(this.carac);
			this.pendu.test("à");
			this.pendu.test("â");
			this.pendu.test("ä");
			break;
			
		case "o": 
			this.pendu.test(this.carac);
			this.pendu.test("ô");
			this.pendu.test("ö");
			break;
		case "u": 
			this.pendu.test(this.carac);
			this.pendu.test("ù");
			this.pendu.test("ü");
			this.pendu.test("û");
			break;
			
		case "i": 
			this.pendu.test(this.carac);
			this.pendu.test("î");
			this.pendu.test("ï");
			break;
			
		case "c":
			this.pendu.test(this.carac);
			this.pendu.test("ç");
			break;
			
		default:
			this.pendu.test(this.carac);
			break;
		}
	}
}
