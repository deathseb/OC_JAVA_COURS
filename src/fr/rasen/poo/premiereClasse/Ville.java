package fr.rasen.poo.premiereClasse;

public class Ville {
	private String nomVille;
	private String nomPays;
	private int nbreHabitants;
	private char categorie;

	public static int nbreInstances = 0;
	private static int nbreInstancesBis = 0;

	public Ville(){
		nbreInstances++;
		nbreInstancesBis++;
		System.out.println("Création d'une ville !");          
		nomVille = "Inconnu";
		nomPays = "Inconnu";
		nbreHabitants = 0;
		this.setCategorie();
	}

	public Ville(String pNom, int pNbre, String pPays){
		nbreInstances++;
		nbreInstancesBis++;
		System.out.println("Création d'une ville avec des paramètres !");
		nomVille = pNom;
		nomPays = pPays;
		nbreHabitants = pNbre;
		this.setCategorie();
	}  

	public String getNom()  {  
		return nomVille;
	}

	public String getNomPays(){
		return nomPays;
	}

	public int getNombreHabitants(){
		return nbreHabitants;
	} 

	public char getCategorie(){
		return categorie;
	} 

	public void setNom(String pNom){
		nomVille = pNom;
	}

	public void setNomPays(String pPays){
		nomPays = pPays;
	}

	public void setNombreHabitants(int nbre){
		nbreHabitants = nbre;
		this.setCategorie();
	}  

	private void setCategorie() {

		int bornesSuperieures[] = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};
		char categories[] = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

		int i = 0;
		while (i < bornesSuperieures.length && this.nbreHabitants > bornesSuperieures[i])
			i++;

		this.categorie = categories[i];
	}

	public String decrisToi(){
		return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ", elle comporte : "+this.nbreHabitants+" habitant(s) => elle est donc de catégorie : "+this.categorie;
	}

	public String comparer(Ville v1){
		String str = new String();

		if (v1.getNombreHabitants() > this.nbreHabitants)
			str = v1.getNom()+" est une ville plus peuplée que "+this.nomVille;

		else
			str = this.nomVille+" est une ville plus peuplée que "+v1.getNom();

		return str;
	}

	public static int getNombreInstancesBis(){
		return nbreInstancesBis;
	}  
}
