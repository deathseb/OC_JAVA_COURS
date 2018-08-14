package fr.rasen.poo.reflexivite;

import java.lang.reflect.Constructor;

public class ReflexiviteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Class c = String.class;
		Class c2 = new String().getClass();

		System.out.println("La superclasse de la classe " + String.class.getName() + " est : " + String.class.getSuperclass());

		Class[] faces = c.getInterfaces();

		System.out.println("il y a " + faces.length + " interfaces implémentées);");
		for(int i = 0; i < faces.length; i++)
			System.out.println(faces[i]);

		java.lang.reflect.Method[] m = c.getMethods();
		System.out.println("Il y a " + m.length + " méthodes dans cette classe");

		for(int i=0; i<m.length; i++) {
			System.out.println(m[i]);

			Class[] p = m[i].getParameterTypes();
			for(int j = 0; j < p.length; j++)
				System.out.println(p[j].getName());

			System.out.println("-----------------------------------------");
		}

		Field[] f = c.getDeclaredFields();

		System.out.println("Il y a " + f.length + " champs dans cette classe");

		for(int i = 0; i < f.length; i++)
			System.out.println(f[i].getName());

		Constructor[] construc = c.getConstructors();   
		System.out.println("Il y a " + construc.length + " constructeurs dans cette classe");
		for(int i = 0; i < construc.length; i++){
			System.out.println(construc[i].getName());

			Class[] param = construc[i].getParameterTypes();                        
			for(int j = 0; j < param.length; j++)
				System.out.println(param[j]);

			System.out.println("-----------------------------\n");
		}
		 */

		String nom = Paire.class.getName();
		try {
			Class cl = Class.forName(nom);
			Object o = cl.newInstance();
			Class[] types = new Class[] {String.class, String.class};
			Constructor ct = cl.getConstructor(types);
			Object o2 = ct.newInstance(new String[] {"valeur 1", "valeur 2"});
			java.lang.reflect.Method m = cl.getMethod("toString", null);

			System.out.println("----------------------------------------");
			System.out.println("Méthode " + m.getName() + " sur o2: " +m.invoke(o2, null));
			System.out.println("Méthode " + m.getName() + " sur o: " +m.invoke(o, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
