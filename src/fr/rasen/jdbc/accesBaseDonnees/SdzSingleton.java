package fr.rasen.jdbc.accesBaseDonnees;

public class SdzSingleton {
	private volatile static SdzSingleton single;
	private String name = "";

	private SdzSingleton(){
		this.name = "Mon singleton";
		System.out.println("\n\t\tCRÉATION DE L'INSTANCE ! ! !");
	}

	public static SdzSingleton getInstance(){
		if(single == null){
			synchronized(SdzSingleton.class){
				if(single == null)
					single = new SdzSingleton();
			}
		}      
		return single;
	}

	public String getName(){
		return this.name;
	}
}
