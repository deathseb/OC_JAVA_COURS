package fr.rasen.swing.Thread;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderScanner extends RecursiveTask<Long>{

	private Path path = null;
	private String filter = "*";
	private long result = 0;

	public FolderScanner(){ }
	public FolderScanner(Path p, String f){
		path = p;
		filter = f;
	}  

	/**
	 * Notre méthode de scan en mode mono thread
	 * @throws ScanException
	 */
	public long sequentialScan() throws ScanException{
		if(path == null || path.equals(""))
			throw new ScanException("Chemin à scanner non valide (vide ou null) !");

		System.out.println("Scan du dossier : " + path + " à la recherche des fichiers portant l'extension " + this.filter);

		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){      
			for(Path nom : listing){
				//S'il s'agit d'un dossier, on le scan grâce à notre objet
				if(Files.isDirectory(nom.toAbsolutePath())){
					FolderScanner f = new FolderScanner(nom.toAbsolutePath(), this.filter);
					result += f.sequentialScan();
				}
			}

		} catch (IOException e) {   e.printStackTrace();  }

		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path, this.filter)){
			for(Path nom : listing){
				result++;
			}
		} catch (IOException e) {  e.printStackTrace(); }

		return result;
	}

	public long parallelScan() throws ScanException{
		List<FolderScanner> list = new ArrayList<>();

		if(path == null || path.equals(""))
			throw new ScanException("Chemin à scanner non valide (vide ou null) !");

		System.out.println("Scan du dossier : " + path + " a la recherche des fichiers portant l'extension " + this.filter);

		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			for(Path nom : listing){
				if(Files.isDirectory(nom.toAbsolutePath())){
					FolderScanner f = new FolderScanner(nom.toAbsolutePath(), this.filter);
					list.add(f);
					f.fork();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path, this.filter)){
			for(Path nom : listing){
				result++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		for(FolderScanner f : list)
			result += f.join();

		return result;    
	}

	/**
	 * Méthode qui défini l'action à faire
	 * dans notre cas, nous lan çons le scan en mode parallèles
	 */
	protected Long compute() {
		long resultat = 0;
		try {
			resultat = this.parallelScan();
		} catch (ScanException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public long getResultat(){  return this.result; }

}
