package fr.rasen.swing.premiereFenetre;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	private Panneau pan = new Panneau();


	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setContentPane(pan);
		this.setVisible(true);
		go();
	}

	private void go() {
		for (;;) {
			int x = pan.getPosX(), y = pan.getPosY();
			boolean backX=false;
			boolean backY = false;

			while(true) {
				if( x < 1) {
					backX = false;
				}

				if (x > pan.getWidth()-50)
					backX=true;

				if(y < 1) {
					backY = false;
				}

				if (y > pan.getHeight()-50)
					backY = true;
				
				
				if(!backX) {
					pan.setPosX(++x);
				} else
					pan.setPosX(--x);

				
				if(!backY)
					pan.setPosY(++y);
				else
					pan.setPosY(--y);

				pan.repaint();

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
