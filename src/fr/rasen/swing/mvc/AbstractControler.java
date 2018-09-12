package fr.rasen.swing.mvc;

import java.util.ArrayList;

public abstract class AbstractControler {

	protected AbstractModel calc;
	protected String operateur ="", nbre ="";
	protected ArrayList<String> listOperateur = new ArrayList<String>();
	
	public AbstractControler (AbstractModel cal) {
		this.calc = cal;
		this.listOperateur.add("+");
	    this.listOperateur.add("-");
	    this.listOperateur.add("*");
	    this.listOperateur.add("/");
	    this.listOperateur.add("=");
	}
	
	public void setOperateur(String ope) {
		this.operateur = ope;
		control();
	}
	
	public void setNombre(String nbre) {
		this.nbre = nbre;
		control();
	}
	
	public void reset() {
		this.calc.reset();
	}
	
	abstract void control();
}
