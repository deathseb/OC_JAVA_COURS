package fr.rasen.poo.collections;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable ht = new Hashtable();
		ht.put(1,"printemps");
		ht.put(10,"été");
		ht.put(12, "automne");
		ht.put(45, "hiver");
		
		Enumeration e = ht.elements();
		
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}

}
