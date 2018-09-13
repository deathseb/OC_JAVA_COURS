package fr.rasen.swing.pendu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	private JMenuBar menu = new JMenuBar();
	
	private JMenu fichier = new JMenu("Fichier");
	private JMenuItem nouveau = new JMenuItem("Nouveau");
	private JMenuItem scores = new JMenuItem("Scores");
	private JMenuItem regle = new JMenuItem("Règles");
	private JMenuItem quitter = new JMenuItem("Quitter");
	
	private JMenu apropos = new JMenu("A Propos");
	private JMenuItem propos = new JMenuItem("A Propos");
	
	private JPanel ecran = new JPanel();
	
	
	public Fenetre() {
		this.setTitle("Pendu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(1000, 750);
		ecran.add(new AccueilPanel());
		
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
	
	class RegleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ecran.removeAll();
			ecran.add(new ReglesPanel());
			ecran.revalidate();
		}
	
	}
	
	class JeuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ecran.removeAll();
			ecran.add(new JeuPanel());
			ecran.revalidate();
		}
		
	}
}
