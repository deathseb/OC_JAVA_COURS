package fr.rasen.swing.TPCalculette;

import javax.swing.JButton;

public class Bouton extends JButton {

	private String name = "";

	public Bouton (String str) {
		super(str);
		this.name = str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
