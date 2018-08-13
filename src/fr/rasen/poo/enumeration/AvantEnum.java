package fr.rasen.poo.enumeration;

public class AvantEnum {
	
	public static final int param1 = 1;
	public static final int param2 = 2;
	
	public void fait(Langage param) {
		if(param == Langage.JAVA)
			System.out.println("Fait à la façon 1.");
		if (param == Langage.PHP)
			System.out.println("Fait à la façon 2");
	}

}
