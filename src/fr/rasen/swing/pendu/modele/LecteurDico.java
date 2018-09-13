package fr.rasen.swing.pendu.modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class LecteurDico {

	private ArrayList<String> dico = new ArrayList<String>();
	private File fileDico = new File("src/dictionnairePendu.txt");

	public LecteurDico() {
		LineNumberReader reader = null;
		try {
			reader = new LineNumberReader(
					new InputStreamReader(
							new FileInputStream(fileDico)));
			String line;
			while ((line = reader.readLine()) != null) {
				dico.add(line);
			}
			dico.trimToSize();
		} catch (Exception e) {
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ArrayList<String> getDico() {
		return dico;
	}
}
