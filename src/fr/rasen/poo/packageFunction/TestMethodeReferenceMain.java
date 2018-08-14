package fr.rasen.poo.packageFunction;

import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class TestMethodeReferenceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ToDoubleFunction<String> stringToDoubleLambda = (s) -> Double.parseDouble(s);
		ToDoubleFunction<String> stringToDoubleRef = Double::parseDouble;
		System.out.println(stringToDoubleLambda.applyAsDouble("0.1234567"));
		System.out.println(stringToDoubleRef.applyAsDouble("0.1234567"));

		Consumer<String> stringPrinterLambda = (s) -> System.out.println(s);
		Consumer<String> stringPrinterRef = System.out::println;
		stringPrinterLambda.accept("Bonjour !");
		stringPrinterRef.accept("Bonjour !");


		ToIntFunction<String> testNew = Integer::new;
		Integer i = testNew.applyAsInt("1235");
		System.out.println("New Integer created : " + i.getClass());	
	}

}
