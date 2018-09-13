package fr.rasen.swing.pendu.vue;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ReglesPanel extends JPanel {

	private JTextArea jta = new JTextArea();
	
	public ReglesPanel() {
		jta.setText("Le jeu du PENDU : \n\n"
				+ "Vous avez 7 coups pour trouver le mot caché ! Et si vous réussissez : on recommence !\n"
				+ "Plus vous avez trouvé de mots, plus votre score grandira !! Alors, à vous de jouer !\n\n\n"
				+ "COMPTE DES POINTS : \n"
				+ "\t Mot trouvé sans erreur : ..... 100 Points\n"
				+ "\t Mot trouvé avec 1 erreur : ..... 50 Points\n"
				+ "\t Mot trouvé avec 2 erreurs : ..... 35 Points\n"
				+ "\t Mot trouvé avec 3 erreurs : ..... 25 Points\n"
				+ "\t Mot trouvé avec 4 erreurs : ..... 15 Points\n"
				+ "\t Mot trouvé avec 5 erreurs : ..... 10 Points\n"
				+ "\t Mot trouvé avec 6 erreurs : ..... 5 Points\n\n"
				+ "Je vous souhaite bien du plaisir...\n"
				+ "Et, si jamais vous pensez pouvoir trouver un mot en un coup, c'est que vous pensez que le dictionnaire est petit !\n"
				+ "Hors, pour votre information, il comprend plus de 336 000 mots... donc bonne chance !! :) ");
		
		jta.setEditable(false);
		this.add(jta);
	}
}
