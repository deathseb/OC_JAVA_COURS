package fr.rasen.poo.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Personne> listP = Arrays.asList(
				new Personne(1.80, 70, "A", "Nicolas", Couleur.BLEU),
				new Personne(1.56, 50, "B", "Nicole", Couleur.VERRON),
				new Personne(1.75, 65, "C", "Germain", Couleur.VERT),
				new Personne(1.68, 50, "D", "Michel", Couleur.ROUGE),
				new Personne(1.96, 65, "E", "Cyrille", Couleur.BLEU),
				new Personne(2.10, 120, "F", "Denis", Couleur.ROUGE),
				new Personne(1.90, 90, "G", "Olivier", Couleur.VERRON)
				);

		Stream<Personne> sp = listP.stream();
		sp.forEach(System.out::println);

		//Stream.iterate(1, (x) -> x+1).forEach(System.out::println);

		System.out.println("\nAprès le filtre");
		sp = listP.stream();
		sp.filter(x -> x.getPoids() > 50).forEach(System.out::println);

		
		
		
		System.out.println("\nAprès le filtre et le map");
		sp = listP.stream();
		sp.filter(x -> x.getPoids() > 50).map(x -> x.getPoids()).forEach(System.out::println);

		
		
		
		System.out.println("\nAprès le filtre, le map et le reduce");
		sp = listP.stream();
		Double sum = sp.filter(x -> x.getPoids() > 50)
				.map(x -> x.getPoids())
				.reduce(0.0d, (x,y) -> x+y );
		System.out.println(sum);

		
		
		
		System.out.println("\nAprès le filtre et le map et reduce");
		sp = listP.stream();
		Optional<Double> sum2 = sp	.filter(x -> x.getPoids() > 250)
				.map(x -> x.getPoids())
				.reduce((x,y) -> x+y);
		if(sum2.isPresent())
			System.out.println(sum2.get());
		else
			System.out.println("Aucun aggrégat de poids...");
		
		
		
		String fileName = "src/dictionnaire.txt";
		try(Stream<String> sf = Files.lines(Paths.get(fileName))){
			sf.forEach(System.out::println);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
