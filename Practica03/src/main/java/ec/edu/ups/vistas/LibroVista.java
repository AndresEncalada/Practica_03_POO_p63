package ec.edu.ups.vistas;

import java.util.Scanner;

import ec.edu.ups.modelos.Libro;
import ec.edu.ups.modelos.Usuario;

public class LibroVista {
	private Scanner scan;
	public LibroVista() {
	}
	public Libro ingresarDatos() {
		scan=new Scanner(System.in);
		System.out.println("------Agregar Libro------");
		System.out.print("Ingrese el titulo del libro:");
		String titulo=scan.nextLine();
		System.out.print("\nIngrese su autor:");
		String autor=scan.nextLine();
		System.out.println("\nIngrese el año de publicacion:");
		Integer año=scan.nextInt();
		
		return new Libro(titulo,autor,año,true);
	}
	public Libro actualizarLibro() {
		scan=new Scanner(System.in);
		System.out.println("------Actualizar Libro------");
		System.out.print("Ingrese el titulo del libro:");
		String titulo=scan.nextLine();
		System.out.print("\nIngrese su autor:");
		String autor=scan.nextLine();
		System.out.println("\nIngrese el año de publicacion:");
		Integer año=scan.nextInt();
		
		return new Libro(titulo,autor,año,true);
	}
	public int eliminarLibro() {
		scan=new Scanner(System.in);
		System.out.println("------Prestar Libro------");
		System.out.print("Ingrese el id del libro:");
		Integer id=scan.nextInt();
		return id;
	}
	public int devolverLibro() {
		scan=new Scanner(System.in);
		System.out.println("------Devolver Libro------");
		System.out.print("Ingrese el id del libro:");
		Integer id=scan.nextInt();
		return id;
	}
	public int buscarLibro() {
		scan=new Scanner(System.in);
		System.out.println("------Buscar Libro------");
		System.out.print("Ingrese el id del libro:");
		Integer id=scan.nextInt();
		return id;
	}
	public String mDisp(boolean disp) {
		if(disp==true) {
			return "Si";
		}
		return "No";
	}
	public void mostrarInformacion(Libro libro) {
		System.out.println(libro.getTitulo()+"\nautor: "+libro.getAutor()+"  // año de publicacion: "+libro.getAño()+"// ID:"+libro.getId()+"// Disponible:"+this.mDisp(libro.isDisponible()));
	}
	public void mostrarM(String m) {
		System.out.println(m);
	}
}
