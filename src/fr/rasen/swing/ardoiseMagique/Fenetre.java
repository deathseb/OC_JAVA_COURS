package fr.rasen.swing.ardoiseMagique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame {
	private JMenuBar menu = new JMenuBar();
	
	private JMenu fichier = new JMenu("Fichier");
	private JMenuItem effacer = new JMenuItem("Effacer");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenu edition = new JMenu ("Edition");
	private JMenu formeP = new JMenu("Forme du pointeur");
	private JMenu couleurP = new JMenu("Couleur du pointeur");
	
	
	private JRadioButtonMenuItem rond = new JRadioButtonMenuItem("Rond");
	private JRadioButtonMenuItem carre = new JRadioButtonMenuItem("Carré");
	private JRadioButtonMenuItem vert = new JRadioButtonMenuItem("Vert");
	private JRadioButtonMenuItem bleu = new JRadioButtonMenuItem("Bleu");
	private JRadioButtonMenuItem rouge = new JRadioButtonMenuItem("Rouge");
	
	
	private Panneau panneau = new Panneau();
	
	
	

	
	public Fenetre() {
		this.setTitle("Ardoise Magique ! ");
		this.setSize(new Dimension(700,500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rond);
		bg1.add(carre);
		rond.setSelected(true);
		rond.addActionListener(new FormeListener());
		carre.addActionListener(new FormeListener());
		formeP.add(rond);
		formeP.add(carre);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(vert);
		bg2.add(bleu);
		bg2.add(rouge);
		vert.setSelected(true);
		vert.addActionListener(new CouleurListener());
		bleu.addActionListener(new CouleurListener());
		rouge.addActionListener(new CouleurListener());
		couleurP.add(vert);
		couleurP.add(bleu);
		couleurP.add(rouge);
		
		edition.setMnemonic('e');
		fichier.setMnemonic('f');
		formeP.setMnemonic('o');
		carre.setMnemonic('c');
		
		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});

		effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panneau.efface();
			}
		});
		
		effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N ,KeyEvent.CTRL_DOWN_MASK));
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		
		
		fichier.add(effacer);
		fichier.add(quitter);
		menu.add(fichier);
		edition.add(formeP);
		edition.add(couleurP);
		menu.add(edition);
		this.setJMenuBar(menu);
		
		this.getContentPane().add(panneau, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	class CouleurListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(vert))
				panneau.setColorSelect(Color.green);
			else if (e.getSource().equals(bleu))
				panneau.setColorSelect(Color.blue);
			else 
				panneau.setColorSelect(Color.red);
		}
		
	}
	
	class FormeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(rond))
				panneau.setPointeur("Rond");
			else
				panneau.setPointeur("Carre");
		}
		
	}
}
