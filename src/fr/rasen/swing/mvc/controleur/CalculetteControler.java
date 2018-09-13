package fr.rasen.swing.mvc.controleur;

import fr.rasen.swing.mvc.modele.AbstractModel;

public class CalculetteControler extends AbstractControler{

	public CalculetteControler(AbstractModel cal) {
		super(cal);
	}
	@Override
	void control() {
		// TODO Auto-generated method stub
		if (this.listOperateur.contains(this.operateur)) {
			if (this.operateur.equals("="))
				this.calc.getResultat();
			else
				this.calc.setOperateur(this.operateur);
		}
		
		if(this.nbre.matches("^[0-9.]+$"))
			this.calc.setNombre(this.nbre);
		
		this.operateur = "";
		this.nbre = "";
	}

}
