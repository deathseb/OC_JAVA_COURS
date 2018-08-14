package fr.rasen.poo.flux;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FluxMain {

	public static void main (String[] args) {
		/*File f = new File("test.txt");
		System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
		System.out.println("Nom du fichier : " + f.getName());
		System.out.println("Est-ce qu'il existe ? " + f.exists());
		System.out.println("Est-ce un répertoire ? " + f.isDirectory());
		System.out.println("Est-ce un fichier ? " + f.isFile());

		System.out.println("Affichage des lecteurs à la racine du PC : ");
		for(File file : f.listRoots()) {
			System.out.println(file.getAbsolutePath());
			try {
				int i = 1;
				for(File nom : file.listFiles()) {
					System.out.println("\t\t " + ((nom.isDirectory()) ? nom.getName() + "/" : nom.getName()));
					if((i%4) == 0) {
						System.out.println("\n");
					}
					i++;
				}
				System.out.println("\n");

			} catch (NullPointerException e) {

			}
		}*/


		/*FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(new File("src/test.txt"));
			fos = new FileOutputStream(new File("src/test2.txt"));
			byte[] buf = new byte[8];
			int n = 0;
			while ((n=fis.read(buf)) >= 0) {
				fos.write(buf);
				for(byte bit : buf) {
					System.out.println("\t" + bit + "(" + (char) bit + ")");
				}
				System.out.println("");
				buf = new byte[8];
			}
			System.out.println("Copie terminée !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/

		FileInputStream fis;
		BufferedInputStream bis;
		FileChannel fc;
		try {
			fis = new FileInputStream(new File("src/dictionnaire.txt"));
			bis = new BufferedInputStream(new FileInputStream(new File("src/dictionnaire.txt")));
			byte[] buf = new byte[8];
			long startTime = System.currentTimeMillis();
			/*while(fis.read(buf) != -1);
			System.out.println("Temps de lecture avec FileInputStream : " + (System.currentTimeMillis() - startTime));
			 */
			startTime = System.currentTimeMillis();
			while(bis.read(buf) != -1);
			System.out.println("Temps de lecture avec BufferedInputStream : " + (System.currentTimeMillis() - startTime));

			fis = new FileInputStream(new File("src/dictionnaire.txt"));
			fc = fis.getChannel(); 
			int size = (int)fc.size();
			ByteBuffer bBuff = ByteBuffer.allocate(size);
			long time = System.currentTimeMillis();
			fc.read(bBuff);
			bBuff.flip();
			System.out.println("Temps d'exécution avec un nouveau buffer : " + (System.currentTimeMillis() - time));

			byte[] tabByte = bBuff.array();


			fis.close();
			bis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*FileInputStream fis;
		FileOutputStream fos;
		BufferedInputStream bis;
		BufferedOutputStream bos; 

		try {
			fis = new FileInputStream(new File("src/dictionnaire.txt"));
			fos = new FileOutputStream(new File("src/dictionnaire2.txt"));
			bis = new BufferedInputStream(new FileInputStream(new File("src/dictionnaire.txt")));
			bos = new BufferedOutputStream(new FileOutputStream(new File("src/dictionnaire3.txt")));
			byte[] buf = new byte[8];

			long startTime = System.currentTimeMillis();

			while(fis.read(buf) != -1){
				fos.write(buf);
			}
			System.out.println("Temps de lecture + écriture avec FileInputStream et FileOutputStream : " + (System.currentTimeMillis() - startTime));

			startTime = System.currentTimeMillis();

			while(bis.read(buf) != -1){
				bos.write(buf);
			}
			System.out.println("Temps de lecture + écriture avec BufferedInputStream et BufferedOutputStream : " + (System.currentTimeMillis() - startTime));

			fis.close();
			bis.close();
			fos.close();
			bos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}     	*/

		/*ObjectInputStream ois;
	    ObjectOutputStream oos;
	    try {
	      oos = new ObjectOutputStream(
	              new BufferedOutputStream(
	                new FileOutputStream(
	                  new File("src/game.txt"))));

	      //Nous allons écrire chaque objet Game dans le fichier
	      oos.writeObject(new Game("Assassin Creed", "Aventure", 45.69));
	      oos.writeObject(new Game("Tomb Raider", "Plateforme", 23.45));
	      oos.writeObject(new Game("Tetris", "Stratégie", 2.50));
	      //Ne pas oublier de fermer le flux !
	      oos.close();

	      //On récupère maintenant les données !
	      ois = new ObjectInputStream(
	              new BufferedInputStream(
	                new FileInputStream(
	                  new File("src/game.txt"))));

	      try {
	        System.out.println("Affichage des jeux :");
	        System.out.println("*************************\n");
	        System.out.println(((Game)ois.readObject()).toString());
	        System.out.println(((Game)ois.readObject()).toString());
	        System.out.println(((Game)ois.readObject()).toString());
	      } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	      }

	      ois.close();

	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } */
	}

}
