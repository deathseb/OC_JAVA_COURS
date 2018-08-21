package fr.rasen.swing.positionnerBoutton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.rasen.swing.premiereFenetre.Panneau;

public class Fenetre extends JFrame implements ActionListener{

	private Panneau pan = new Panneau();
	private JButton bouton = new JButton("bouton 1");
	private JButton bouton2 = new JButton("bouton 2");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Le JLabel");
	private int compteur = 0;

	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);

		bouton.addActionListener(this);
		bouton2.addActionListener(this);

		JPanel south = new JPanel();
		south.add(bouton);
		south.add(bouton2);
		container.add(south, BorderLayout.SOUTH);

		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);
		label.setForeground(Color.blue);
		label.setHorizontalAlignment(JLabel.CENTER);
		container.add(label, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
		go();	}

	private void go(){  
		int x = pan.getPosX(), y = pan.getPosY();
		boolean backX = false;
		boolean backY = false;
		while(true){
			if(x < 1)
				backX = false;

			if(x > pan.getWidth()-50)
				backX = true;

			if(y < 1)
				backY = false;

			if(y > pan.getHeight()-50)
				backY =true;

			if(!backX)
				pan.setPosX(++x);
			else
				pan.setPosX(--x);

			if(!backY)
				pan.setPosY(++y);
			else
				pan.setPosY(--y);

			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == bouton)
		    label.setText("Vous avez cliqué sur le bouton 1");

		  if(arg0.getSource() == bouton2)
		    label.setText("Vous avez cliqué sur le bouton 2");
	}
}
