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

public class Fenetre extends JFrame{

	private boolean operateur = false, secChiffre = false;
	private String lastOp = "";
	private double firstN = 0;

	private JLabel affichage = new JLabel(" ");
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private JPanel panAffichage = new JPanel();

	private Bouton b0 = new Bouton("0");
	private Bouton b1 = new Bouton("1");
	private Bouton b2 = new Bouton("2");
	private Bouton b3 = new Bouton("3");
	private Bouton b4 = new Bouton("4");
	private Bouton b5 = new Bouton("5");
	private Bouton b6 = new Bouton("6");
	private Bouton b7 = new Bouton("7");
	private Bouton b8 = new Bouton("8");
	private Bouton b9 = new Bouton("9");
	private Bouton point = new Bouton(".");
	private Bouton egale = new Bouton("=");
	private GridLayout glChiffre = new GridLayout(4,3);
	JPanel panChiffre = new JPanel();

	private Bouton cancel = new Bouton("C");
	private Bouton plus = new Bouton("+");
	private Bouton moins = new Bouton("-");
	private Bouton fois = new Bouton("x");
	private Bouton div = new Bouton ("/");
	private GridLayout glOpe = new GridLayout(5,1);
	private JPanel panOpe = new JPanel();

	private BorderLayout bl = new BorderLayout();



	public Fenetre() {
		this.setTitle("Calculette");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(250, 300);

		b1.addActionListener(new ChiffreListener());
		b2.addActionListener(new ChiffreListener());
		b3.addActionListener(new ChiffreListener());
		b4.addActionListener(new ChiffreListener());
		b5.addActionListener(new ChiffreListener());
		b6.addActionListener(new ChiffreListener());
		b7.addActionListener(new ChiffreListener());
		b8.addActionListener(new ChiffreListener());
		b9.addActionListener(new ChiffreListener());
		b0.addActionListener(new ChiffreListener());
		point.addActionListener(new ChiffreListener());
		egale.addActionListener(new EgaleListener());
		plus.addActionListener(new PlusListener());
		moins.addActionListener(new MoinsListener());
		fois.addActionListener(new FoisListener());
		div.addActionListener(new DivListener());
		cancel.addActionListener(new CancelListener());

		glChiffre.setHgap(5);
		glChiffre.setVgap(5);
		panChiffre.setLayout(glChiffre);
		panChiffre.add(b1);
		panChiffre.add(b2);
		panChiffre.add(b3);
		panChiffre.add(b4);
		panChiffre.add(b5);
		panChiffre.add(b6);
		panChiffre.add(b7);
		panChiffre.add(b8);
		panChiffre.add(b9);
		panChiffre.add(b0);
		panChiffre.add(point);
		panChiffre.add(egale);

		cancel.setForeground(Color.red);
		glOpe.setHgap(5);
		glOpe.setVgap(5);
		panOpe.setLayout(glOpe);
		panOpe.add(cancel);
		panOpe.add(plus);
		panOpe.add(moins);
		panOpe.add(fois);
		panOpe.add(div);

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
