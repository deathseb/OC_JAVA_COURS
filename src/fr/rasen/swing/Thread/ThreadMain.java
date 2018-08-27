package fr.rasen.swing.Thread;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*TestThread t = new TestThread("A");
		TestThread t2 = new TestThread("  B", t);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("statut du thread " + t.getName() + " = " + t.getState());
		System.out.println("statut du thread " + t2.getName() + " = " +t2.getState());   */

		/*CompteEnBanque cb = new CompteEnBanque();

		Thread t = new Thread(new RunImpl(cb, "Seb"));
		Thread t2 = new Thread(new RunImpl(cb, "Zéro"));
		t.start();
		t2.start();*/

		Path chemin = Paths.get("H:\\LDW");
		String filtre = "*.png";

		FolderScanner fs = new FolderScanner(chemin, filtre);

		int processeurs = Runtime.getRuntime().availableProcessors();
		ForkJoinPool pool = new ForkJoinPool(processeurs);
		Long start = System.currentTimeMillis();

		pool.invoke(fs);

		Long end = System.currentTimeMillis();
		System.out.println("Il y a " + fs.getResultat() + " fichier(s) portant l'extension " + filtre);
		System.out.println("Temps de traitement : " + (end - start));    
	}
}



