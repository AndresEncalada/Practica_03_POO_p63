package ec.edu.ups.vistas;

import java.util.Scanner;

import ec.edu.ups.modelos.Libro;
import ec.edu.ups.modelos.Prestamo;
import ec.edu.ups.modelos.Usuario;
public class PrestamoVista {
	private Scanner scan;
	public PrestamoVista() {
		scan=new Scanner(System.in);
	}
	public int ingresarDatos() {
		System.out.print("Ingrese el id de libro:");
		int id=scan.nextInt();
		return id;
	}
	public int ingresarDatosU() {
		System.out.println("------Prestamo & Devolucion------");
		System.out.print("Ingrese el id de Usuario:");
		int id=scan.nextInt();
		return id;
	}
	public void mostrarInformacion(Libro libro, Usuario usuario) {
		System.out.println(libro.getTitulo()+":"+" autor: "+libro.getAutor()+" id: "+libro.getId());
		System.out.println("Libro a cargo de: "+usuario.getNombre());
	}
	public void mostrarM(String m) {
		System.out.println(m);
	}
}

