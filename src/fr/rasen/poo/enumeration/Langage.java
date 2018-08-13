package fr.rasen.poo.enumeration;

public enum Langage {
	JAVA ("Langage JAVA", "Eclipse"),
	C ("Langage C", "Code Block"),
	CPlus ("Langage C++", "Visual studio"),
	PHP ("Langage PHP", "PS Pad");
	
	private String name = "";
	private String editor = "";
	
	Langage(String name, String editor){
		this.name = name;
		this.editor = editor;
	}
	
	public void getEditor() {
		System.out.println("Editeur : " + editor);
	}

	public String toString() {
		return name;
	}
	

}
