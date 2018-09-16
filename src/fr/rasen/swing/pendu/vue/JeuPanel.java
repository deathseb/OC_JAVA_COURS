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
	private JLabel jl = new JLabel();
	private Modele m = new Modele();
	private JPanel panBoutons = new JPanel();
	private JLabel icone = new JLabel(new ImageIcon("src/images/pendu/01.jpg"));
	private AbstractControleur ac;

	public JeuPanel(AbstractControleur ac) {
		this.ac = ac;
		jl.setText(m.getChaineUnderAffichage());
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

	class BoutonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = ((JButton) e.getSource()).getText();
			ac.setCarac(str);
			((JButton)e.getSource()).setEnabled(false); //désactive le boutton après avoir cliqué dessus
		}
	}
	
	
}
