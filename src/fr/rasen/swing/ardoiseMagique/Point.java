package fr.rasen.swing.ardoiseMagique;

import java.awt.Color;

public class Point {

	private Color color = Color.green;
	private int posX;
	private int posY;
	private int taille;
	private String forme = "CARRE";
	
	
	

	public Point(Color c, int x, int y, int t) {
		this.color = c;
		this.posX = x;
		this.posY = y;
		this.taille = t;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getTaille() {
		return taille;
	}


	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public String getForme() {
		return forme;
	}


	public void setForme(String forme) {
		this.forme = forme;
	}

	
}
