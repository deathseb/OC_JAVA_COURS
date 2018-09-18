package fr.rasen.swing.pendu.vue;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.rasen.swing.pendu.controleur.AbstractControleur;
import fr.rasen.swing.pendu.observer.Observer;

public class Fenetre extends JFrame implements Observer{
	private AbstractControleur ac;

	private JMenuBar menu = new JMenuBar();

	private JMenu fichier = new JMenu("Fichier");
	private JMenuItem nouveau = new JMenuItem("Nouveau");
	private JMenuItem scores = new JMenuItem("Scores");
	private JMenuItem regle = new JMenuItem("Règles");
	private JMenuItem quitter = new JMenuItem("Quitter");

	private JMenu apropos = new JMenu("A Propos");
	private JMenuItem propos = new JMenuItem("A Propos");
	private AccueilPanel accueil = new AccueilPanel();
	private JeuPanel jeu;
	private ScorePanel score = new ScorePanel();
	private ReglesPanel regles = new ReglesPanel();
	private boolean victoire = true;
	private int erreur = 0;

	private Container ecran = this.getContentPane();


	public Fenetre(AbstractControleur ac) {
		this.ac = ac;
		jeu = new JeuPanel(ac);
		this.setTitle("Pendu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(1000, 750);
		ecran.add(accueil);

		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});

		regle.addActionListener(new RegleListener());

		nouveau.addActionListener(new JeuListener());

		fichier.add(nouveau);
		fichier.add(scores);
		fichier.add(regle);
		fichier.add(quitter);

		apropos.add(propos);

		menu.add(fichier);
		menu.add(apropos);

		this.setContentPane(ecran);
		this.setJMenuBar(menu);
		this.setVisible(true);
	}

	public void victoire() {
		jeu.setScore(erreur);
		System.out.println(jeu.getScore());
		jeu.getNewMot(); //génère un nouveau mot et le met dans le JLabel sous sa forme underscore
		erreur = 0;
		jeu.changeAffichage(erreur);
		ecran.repaint();
	}

	class RegleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ecran.removeAll();
			ecran.add(regles);
			ecran.revalidate();
			ecran.repaint();
		}

	}

	class JeuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ecran.removeAll();
			ecran.add(jeu);
			ecran.revalidate();
			ecran.repaint();
		}

	}

	@Override
	public void update(String str) {
		// TODO Auto-generated method stub
		ecran.removeAll();
		String ancienneChaine = jeu.getJl().getText();
		if (ancienneChaine.equals(str)) {
			erreur ++;
			jeu.changeAffichage(erreur);
		}
		if (erreur >= 8) {
			ecran.removeAll();
			ecran.add(score);
			ecran.revalidate();
			ecran.repaint();
		}else {
			jeu.getJl().removeAll();
			jeu.getJl().setText(str);
			ecran.add(jeu);
			ecran.revalidate();
			ecran.repaint();
		}
		this.victoire = true;
		for (int i =0; i < str.length(); i++) {
			if (str.charAt(i) == '_') {
				this.victoire = false;
			}
		}
		if (victoire) {
			victoire();
		}
	}
}
