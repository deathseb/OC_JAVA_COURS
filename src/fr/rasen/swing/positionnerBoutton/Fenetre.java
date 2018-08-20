package fr.rasen.swing.positionnerBoutton;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.rasen.swing.premiereFenetre.Panneau;

public class Fenetre extends JFrame{

	private Panneau pan = new Panneau();
	private JButton bouton = new JButton("Mon Boutton");
	JPanel container = new JPanel();

	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		container.add(bouton, BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(true);    
		go();
	}

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
}
