package fr.rasen.swing.mvc;

public class Calculator extends AbstractModel{


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.result = 0;
		this.operande = "0";
		this.operateur = "";
		notifyObserver(String.valueOf(this.result));
	}

	@Override
	public void calcul() {
		// TODO Auto-generated method stub
		if(this.operateur.equals(""))
			this.result = Double.parseDouble(this.operande);
		else {
			if(!this.operande.equals("")) {
				if(this.operateur.equals("+")) {
					this.result += Double.parseDouble(this.operande);
				}
				if(this.operande.equals("-")) {
					this.result -= Double.parseDouble(this.operande);
				}
				if(this.operateur.equals("*"))
					this.result *= Double.parseDouble(this.operande);          
				if(this.operateur.equals("/")){
					try{
						this.result /= Double.parseDouble(this.operande);
					}catch(ArithmeticException e){
						this.result = 0;
					}
				}
			}
		}
		this.operande = "";
		notifyObserver(String.valueOf(this.result));
	}

	@Override
	public void getResultat() {
		// TODO Auto-generated method stub
		calcul();
	}

	@Override
	public void setNombre(String nbre) {
		// TODO Auto-generated method stub
		this.operande += result;
		notifyObserver(this.operande);
	}

	@Override
	public void setOperateur(String operateur) {
		// TODO Auto-generated method stub
		calcul();
		this.operateur = operateur;
		if (!operateur.equals("="))
			this.operande = "";
	}

}
