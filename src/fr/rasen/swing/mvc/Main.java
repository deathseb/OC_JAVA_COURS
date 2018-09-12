package fr.rasen.swing.mvc;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractModel calc = new Calculator();
		AbstractControler controler = new CalculetteControler(calc);
		Calculette calculette = new Calculette(controler);
		calc.addObserver(calculette);
	}

}
