package fr.rasen.poo.packageFunction;

import java.util.function.Supplier;

public class TestSupplierMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Supplier<String> s1 = () -> new String("hello !");
		System.out.println(s1.get());
		Supplier<Personne> s2 = () -> new Personne(50, "Dédé");
		System.out.println(s2.get());
	}

}
