package fr.rasen.swing.pendu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JeuPanel extends JPanel{

	String [] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	JButton [] boutons = new JButton[alphabet.length];

	public JeuPanel() {
		this.setLayout(new GridLayout(4,7));
		for (int i = 0; i < alphabet.length; i++) {
			boutons[i] = new JButton(alphabet[i]);
			boutons[i].addActionListener(new BoutonListener());
			this.add(boutons[i]);
		}
	}

	class BoutonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			((JButton)e.getSource()).setEnabled(false); //désactive le boutton après avoir cliqué dessus
		}

	}
}
