package fr.rasen.swing.pendu.vue;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.rasen.swing.pendu.modele.LecteurScore;
import fr.rasen.swing.pendu.modele.Score;

public class ScorePanel extends JPanel{

	private LecteurScore ls = new LecteurScore();
	private JTextArea jta = new JTextArea();
	
	public void affichageScore() {
		ls.lecture();
		jta.setEditable(false);
		jta.setText(ls.toString());
		this.add(jta);
	}
	
	public void sauvegarde(int score, String nom) {
		ls.lecture();
		Score s = new Score(score, nom);
		ls.getListScore().add(s);
		ls.sauvegarde();
	}
}
