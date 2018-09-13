package fr.rasen.swing.pendu;


public interface Observable {

	public void addObserver(Observer o);
	public void removeObserver();
	public void notifyObserver(String str);
}
