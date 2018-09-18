package fr.rasen.swing.pendu.vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.rasen.swing.pendu.modele.LecteurScore;
import fr.rasen.swing.pendu.modele.Score;

public class ScorePanel extends JPanel{

	private LecteurScore ls = new LecteurScore();
	private JLabel jl = new JLabel();
	
	public void affichageScore() {
		ls.lecture();
		jl.setText(ls.getListScore().toString());
		this.add(jl);
	}
	
	public void sauvegarde(int score, String nom) {
		ls.lecture();
		Score s = new Score(score, nom);
		ls.getListScore().add(s);
		ls.sauvegarde();
	}
}
