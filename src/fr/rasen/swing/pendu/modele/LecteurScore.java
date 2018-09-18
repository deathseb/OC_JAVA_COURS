package fr.rasen.swing.pendu.modele;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class LecteurScore {

	private ObjectInputStream ois;
	private ObjectOutputStream oss;
	private ArrayList<Score> listScore = new ArrayList<Score>();;

	public void lecture() {

		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("src/score.txt"))));

			try {
				listScore = (ArrayList<Score>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}

			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void sauvegarde () {
		try {
			oss = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("src/score.txt"))));
			oss.writeObject(listScore);
			
			oss.close();
		}catch (Exception e) {

		}
	}

	public ArrayList<Score> getListScore() {
		return listScore;
	}

	public void setListScore(ArrayList<Score> listScore) {
		this.listScore = listScore;
	}
	
}
