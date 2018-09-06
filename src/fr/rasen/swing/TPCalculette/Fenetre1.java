package fr.rasen.swing.TPCalculette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Fenetre1 extends JFrame{

	private boolean operateur = false, secChiffre = false;
	private String lastOp = "";
	private double firstN = 0;

	private JLabel affichage = new JLabel(" ");
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private JPanel panAffichage = new JPanel();

	private GridLayout glChiffre = new GridLayout(4,3);
	JPanel panChiffre = new JPanel();

	private GridLayout glOpe = new GridLayout(5,1);
	private JPanel panOpe = new JPanel();

	private BorderLayout bl = new BorderLayout();
	private String[] charBouton = {"0","1","2","3","4","5","6","7","8","9","+","-","/","x","C","."};
	private Bouton[] boutons = new Bouton[charBouton.length];
	



	public Fenetre1() {
		this.setTitle("Calculette");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(250, 300);

		
		for (int i =0; i < boutons.length; i++) {
			boutons[i] = new Bouton(charBouton[i]);
			switch(i) {
			case 11 :
				boutons[i].addActionListener(new PlusListener());
				panOpe.add(boutons[i]);
				break;
			case 12:
				boutons[i].addActionListener(new MoinsListener());
				panOpe.add(boutons[i]);
				break;
			case 13:
				boutons[i].addActionListener(new DivListener());
				panOpe.add(boutons[i]);
				break;
			case 14:
				boutons[i].addActionListener(new FoisListener());
				panOpe.add(boutons[i]);
				break;
			case 15:
				boutons[i].addActionListener(new CancelListener());
				boutons[i].setForeground(Color.red);
				panOpe.add(boutons[i]);
				break;
			default : 
				boutons[i].addActionListener(new ChiffreListener());
				panChiffre.add(boutons[i]);
				break;
			}
				
		}
		

		glChiffre.setHgap(5);
		glChiffre.setVgap(5);
		panChiffre.setLayout(glChiffre);

		affichage.setBorder(blackline);
		affichage.setHorizontalAlignment(JLabel.RIGHT);
		affichage.setPreferredSize(new Dimension(225, 30));
		panAffichage.add(affichage);

		bl.setHgap(5);
		bl.setVgap(5);
		this.getContentPane().setLayout(bl);
		this.getContentPane().add(panChiffre, BorderLayout.CENTER);
		this.getContentPane().add(panOpe, BorderLayout.EAST);
		this.getContentPane().add(panAffichage, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public void calcul() {
		if(lastOp == "+") {
			firstN = firstN + Double.parseDouble(affichage.getText());
		}
		if (lastOp == "-") {
			firstN = firstN - Double.parseDouble(affichage.getText());
		}
		if (lastOp == "x") {
			firstN = firstN * Double.parseDouble(affichage.getText());
		}
		if (lastOp == "/") {
			try {
				firstN = firstN / Double.parseDouble(affichage.getText());
			} catch (Exception e) {
				firstN = 0;
			}
		}
	}

	class EgaleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			calcul();
			affichage.setText(String.valueOf(firstN));
		}

	}

	class CancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			operateur = false;
			secChiffre = false;
			lastOp = "";
			firstN = 0;
			affichage.setText("0");
		}

	}

	class ChiffreListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (operateur && secChiffre) {
				secChiffre = false;
				affichage.setText("0");
			}
			if (affichage.getText() == "0" || affichage.getText() == " ") {
				affichage.setText(((Bouton)e.getSource()).getText());
			} else {
				affichage.setText(affichage.getText() + ((Bouton)e.getSource()).getText());
			}
		}

	}

	class PlusListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (operateur) {
				calcul();
				affichage.setText(String.valueOf(firstN));
			} else {
				firstN = Double.parseDouble(affichage.getText());
				operateur = true;
				secChiffre = true;
				lastOp = "+";
				affichage.setText("");
			}
		}

	}

	class MoinsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (operateur) {
				calcul();
				affichage.setText(String.valueOf(firstN));
			} else {
				firstN = Double.parseDouble(affichage.getText());
				operateur = true;
				secChiffre = true;
				lastOp = "-";
				affichage.setText("");
			}
		}

	}

	class FoisListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (operateur) {
				calcul();
				affichage.setText(String.valueOf(firstN));
			} else {
				firstN = Double.parseDouble(affichage.getText());
				operateur = true;
				secChiffre = true;
				lastOp = "x";
				affichage.setText("");
			}
		}

	}

	class DivListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (operateur) {
				calcul();
				affichage.setText(String.valueOf(firstN));
			} else {
				firstN = Double.parseDouble(affichage.getText());
				operateur = true;
				secChiffre = true;
				lastOp = "/";
				affichage.setText("");
			}
		}

	}
}
