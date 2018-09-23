package fr.rasen.swing.pendu.modele;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LecteurScore {

	private ObjectInputStream ois;
	private ObjectOutputStream oss;
	private List<Score> listScore = new ArrayList<Score>();

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

		trie();
	}

	public void sauvegarde () {
		trie();
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

	public List<Score> getListScore() {
		return listScore;
	}

	public void setListScore(ArrayList<Score> listScore) {
		this.listScore = listScore;
	}

	public void trie() {
		List l = new ArrayList();
		Score s = null;
		for (int i =0; i < 10; i++) { // limite aux 10 meilleurs scores
			int k =0;
			if (!listScore.isEmpty()) {
				s = listScore.get(k);
				for (int j=0; j < listScore.size(); j++) {
					if (listScore.get(j).getScore()>s.getScore()) {
						k = j;
						s = listScore.get(j);
					}
				}

				l.add(s);
				listScore.remove(k);
			}
		}
		listScore = l;
	}
	
	public String toString() {
		String str = "";
		for (int i=0; i < listScore.size(); i++) {
			str = str + (i+1) + " -> " + listScore.get(i).toString();
		}
		return str;
	}
}
