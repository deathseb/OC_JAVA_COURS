package fr.rasen.poo.premiereClasse;

public class Ville {
	protected String nomVille;
	protected String nomPays;
	protected int nbreHabitants;
	protected char categorie;

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
	
	public String toString() {
		return "\t"+this.nomVille+" est une ville de "+this.nomPays+ ", elle comporte : "+this.nbreHabitants+" habitant(s) => elle est donc de catégorie : "+this.categorie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categorie;
		result = prime * result + nbreHabitants;
		result = prime * result + ((nomPays == null) ? 0 : nomPays.hashCode());
		result = prime * result + ((nomVille == null) ? 0 : nomVille.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ville other = (Ville) obj;
		if (categorie != other.categorie)
			return false;
		if (nbreHabitants != other.nbreHabitants)
			return false;
		if (nomPays == null) {
			if (other.nomPays != null)
				return false;
		} else if (!nomPays.equals(other.nomPays))
			return false;
		if (nomVille == null) {
			if (other.nomVille != null)
				return false;
		} else if (!nomVille.equals(other.nomVille))
			return false;
		return true;
	}
	
	
}
