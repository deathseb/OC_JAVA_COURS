package fr.rasen.swing.mvc.vue;

import fr.rasen.swing.mvc.controleur.AbstractControler;
import fr.rasen.swing.mvc.controleur.CalculetteControler;
import fr.rasen.swing.mvc.modele.AbstractModel;
import fr.rasen.swing.mvc.modele.Calculator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractModel calc = new Calculator();
		AbstractControler controler = new CalculetteControler(calc);
		Calculette calculette = new Calculette(controler);
		calc.addObserver(calculette);
	}

}
