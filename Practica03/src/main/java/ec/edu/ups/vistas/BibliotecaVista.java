package ec.edu.ups.vistas;

import java.util.Scanner;

public class BibliotecaVista {
	private Scanner scan;
	public BibliotecaVista() {
		scan=new Scanner(System.in);
	}
	public void prestarLibro() {
		System.out.println("---------------------------------------------");
		System.out.println("Libro prestado y retirado de la biblioteca!");
		System.out.println("Presione Enter para continuar");
		System.out.println("---------------------------------------------");
		Scanner esp=new Scanner(System.in);
		String es=esp.nextLine();
	}
	public void devolverLibro() {
		System.out.println("---------------------------------------------");
		System.out.println("Libro devuelto a la biblioteca!");
		System.out.println("Presione Enter para continuar");
		System.out.println("---------------------------------------------");
		Scanner esp=new Scanner(System.in);
		String es=esp.nextLine();
	}
	public void mostrarM(String m) {
		System.out.println(m);
	}
}
