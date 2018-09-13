package fr.rasen.swing.pendu;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccueilPanel extends JPanel{

	private JLabel jl = new JLabel();
	private JLabel icone = new JLabel(new ImageIcon("src/images/pendu/accueil.jpg"));
	
	public AccueilPanel() {
		jl.setText("Bienvenue sur le jeu du PENDU !");
		this.add(jl, BorderLayout.NORTH);
		this.add(icone, BorderLayout.CENTER);
	}
}
