package fr.rasen.swing.ardoiseMagique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panneau extends JPanel{

	private ArrayList<Point> dessin = new ArrayList<Point>(); //pour retenir le tracé effectué
	private Color colorSelect = Color.green;
	private String pointeur = "Carre";
	private int taillePointeur = 10;
	private boolean effacer = true;

	public Panneau() {
		this.addMouseListener(new MouseAdapter() {
			public void MousePressed(MouseEvent e) {
				dessin.add(new Point(colorSelect, e.getX(), e.getY(), taillePointeur));
				repaint();
			}
		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				dessin.add(new Point(colorSelect, e.getX(), e.getY(), taillePointeur));
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

	public void paintComponent(Graphics g) {
		if(effacer) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			effacer = false;
		} else {
			for(Point p : this.dessin){
				g.setColor(p.getColor());
				if(p.getForme().equals("Carre")){
					g.fillRect(p.getPosX(), p.getPosY(), p.getTaille(), p.getTaille());
				}
				else{
					g.fillOval(p.getPosX(), p.getPosY(), p.getTaille(), p.getTaille());
				}
			}
		}
	}
	
	public void efface() {
		this.effacer = true;
		this.dessin = new ArrayList<Point>();
		repaint();
	}

	public void setPointeur(String pointeur) {
		this.pointeur = pointeur;
	}

	public void setColorSelect(Color colorSelect) {
		this.colorSelect = colorSelect;
	}

	
	

}
