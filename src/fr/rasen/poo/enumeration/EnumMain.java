package fr.rasen.poo.enumeration;

public class EnumMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvantEnum ae = new AvantEnum();
		ae.fait(Langage.JAVA);
		ae.fait(Langage.PHP);
		//ae.fait(4);
		
		for(Langage lang : Langage.values()) {
			if(Langage.JAVA.equals(lang))
				System.out.println("J'aime le : " + lang);
			else
				System.out.println(lang);
		}
		
		Langage l1 = Langage.JAVA;
		Langage l2 = Langage.PHP;
		l1.getEditor();
		l2.getEditor();
	}

}
