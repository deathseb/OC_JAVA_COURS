package fr.rasen.swing.mvc;

public interface Observable {
	public void addObserver(Observer o);
	public void removeObserver();
	public void notifyObserver(String str);

}
