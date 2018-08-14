package fr.rasen.poo.packageFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumerMain {

	public static void main(String[] args) {

		List<Personne> lPersonne = Arrays.asList(
				new Personne(10, "toto"),
				new Personne(20, "titi"),
				new Personne(30, "tata"),
				new Personne(40, "tutu")
				);

		System.out.println(lPersonne);
		Consumer<Personne> c = (Personne p) -> p.setAge(p.getAge() + 13);
		for(Personne p : lPersonne)
			c.accept(p);
		System.out.println(lPersonne);
	}
}
