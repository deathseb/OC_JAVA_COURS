package fr.rasen.swing.pendu.vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.rasen.swing.pendu.controleur.AbstractControleur;
import fr.rasen.swing.pendu.modele.Modele;

public class JeuPanel extends JPanel{

	private String [] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private JButton [] boutons = new JButton[alphabet.length];
	private JLabel jl;
	private Modele m;
	private JPanel panBoutons;
	private JLabel icone;
	private AbstractControleur ac;
	private int score = 0;
	

	public JeuPanel(AbstractControleur ac) {
		jl = new JLabel();
		panBoutons = new JPanel();
		icone = new JLabel(new ImageIcon("src/images/pendu/01.jpg"));
		this.ac = ac;
		m = new Modele();
		jl.setText(ac.getUnderChaine());
		this.add(jl, BorderLayout.NORTH);
		panBoutons.setLayout(new GridLayout(4,7));
		for (int i = 0; i < alphabet.length; i++) {
			boutons[i] = new JButton(alphabet[i]);
			boutons[i].setText(alphabet[i]);
			boutons[i].addActionListener(new BoutonListener());
			panBoutons.add(boutons[i]);
		}
		this.add(panBoutons, BorderLayout.WEST);
		this.add(icone, BorderLayout.EAST);

	}

	public JLabel getJl() {
		return jl;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int erreur) {
		switch(erreur) {
		case 0:
			score += 100;
			break;
		case 1:
			score += 50;
			break;
		case 2: 
			score += 35;
			break;
		case 3 :
			score += 25;
			break;
		case 4: 
			score += 15;
			break;
		case 5:
			score += 10;
			break;
		case 6:
			score += 5;
			break;
		}
	}

	public void getNewMot() {
		ac.getNewMot();
		jl.setText(ac.getUnderChaine());
		for (int i=0; i < boutons.length; i++) { // on réactive les boutons
			boutons[i].setEnabled(true);
		}
	}

	public void changeAffichage (int erreur) {
		switch(erreur) {
		case 0:
			this.removeAll();
			icone.removeAll();
			icone = new JLabel(new ImageIcon("src/images/pendu/01.jpg"));
			this.add(jl, BorderLayout.NORTH);
			this.add(panBoutons, BorderLayout.WEST);
			this.add(icone, BorderLayout.EAST);
			this.revalidate();
			this.repaint();
			break;
		case 1:
			this.removeAll();
			icone.removeAll();
			icone = new JLabel(new ImageIcon("src/images/pendu/02.jpg"));
			this.add(jl, BorderLayout.NORTH);
			this.add(panBoutons, BorderLayout.WEST);
			this.add(icone, BorderLayout.EAST);
			this.revalidate();
			this.repaint();
			break;
		case 2:
			this.removeAll();
			icone.removeAll();
			icone = new JLabel(new ImageIcon("src/images/pendu/03.jpg"));
			this.add(jl, BorderLayout.NORTH);
			this.add(panBoutons, BorderLayout.WEST);
			this.add(icone, BorderLayout.EAST);
			this.revalidate();
			this.repaint();
			break;
		case 3: 
			this.removeAll();
			icone.removeAll();
			icone = new JLabel(new ImageIcon("src/images/pendu/04.jpg"));
			this.add(jl, BorderLayout.NORTH);
			this.add(panBoutons, BorderLayout.WEST);
			this.add(icone, BorderLayout.EAST);
			this.revalidate();
			this.repaint();
			break;
		case 4:
			this.removeAll();
			icone.removeAll();
			icone = new JLabel(new ImageIcon("src/images/pendu/05.jpg"));
			this.add(jl, BorderLayout.NORTH);
			this.add(panBoutons, BorderLayout.WEST);
			this.add(icone, BorderLayout.EAST);
			this.revalidate();
			this.repaint();
			break;
		case 5: 
			this.removeAll();
			icone.removeAll();
			icone = new JLabel(new ImageIcon("src/images/pendu/06.jpg"));
			this.add(jl, BorderLayout.NORTH);
			this.add(panBoutons, BorderLayout.WEST);
			this.add(icone, BorderLayout.EAST);
			this.revalidate();
			this.repaint();
			break;
		case 6:
			this.removeAll();
			icone.removeAll();
			icone = new JLabel(new ImageIcon("src/images/pendu/07.jpg"));
			this.add(jl, BorderLayout.NORTH);
			this.add(panBoutons, BorderLayout.WEST);
			this.add(icone, BorderLayout.EAST);
			this.revalidate();
			this.repaint();
			break;
		case 7:
			this.removeAll();
			icone.removeAll();
			icone = new JLabel(new ImageIcon("src/images/pendu/08.jpg"));
			this.add(jl, BorderLayout.NORTH);
			this.add(panBoutons, BorderLayout.WEST);
			this.add(icone, BorderLayout.EAST);
			this.revalidate();
			this.repaint();
			break;
		}
	}

	class BoutonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = ((JButton) e.getSource()).getText();
			((JButton)e.getSource()).setEnabled(false); //désactive le boutton après avoir cliqué dessus
			ac.setCarac(str);

		}
	}


}
