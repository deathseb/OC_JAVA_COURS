package fr.rasen.swing.premiereFenetre;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panneau extends JPanel{

	public void paintComponent(Graphics g) {
	//	System.out.println("Je suis exécuté.");
		g.fillOval(20, 20, 75,  75);
		
		Graphics2D g2d = (Graphics2D)g;         
	    GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30, Color.cyan, true);                
	    g2d.setPaint(gp);
	    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());   
	}
}
