package fr.rasen.poo.interfaceFonctionnelles;

public interface Soin {
	 public void soigne();
	 public default String toto(int i) {
		 return "Tout est OK.";
	 }
}
