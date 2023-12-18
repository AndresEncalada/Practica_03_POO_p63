package ec.edu.ups.vistas;

import java.util.Scanner;

import ec.edu.ups.modelos.Usuario;

public class UsuarioVista {
	private Scanner scan;
	public UsuarioVista() {
		scan=new Scanner(System.in);
	}
	public Usuario ingresarDatos() {
		System.out.println("------Usuario nuevo------");
		System.out.print("Ingrese su nombre:");
		String nombre=scan.nextLine();
		System.out.print("\n Ingrese su correo:");
		String correo=scan.nextLine();
		System.out.println("\n Ingrese su ID:");
		int id=scan.nextInt();
		
		return new Usuario(correo,id,nombre);
	}
	public Usuario cambiarDatosUsuario() {
		System.out.println("------Actualizar Datos Usuario------");
		System.out.print("Ingrese su nombre:");
		String nombre=scan.nextLine();
		System.out.print("\n Ingrese su correo:");
		String correo=scan.nextLine();
		System.out.print("\n Ingrese su ID:");
		int id=scan.nextInt();
		System.out.println();
		return new Usuario(correo,id,nombre);
	}
	public Integer eliminarUsuario() {
		System.out.println("------Eliminar Usuario------");
		System.out.print("Ingrese el id del usuario:");
		int id=scan.nextInt();
		return id;
	}
	public Integer buscarUsuario() {
		System.out.println("------Buscar Cliente------");
		System.out.print("Ingrese el id del usuario:");
		int id=scan.nextInt();
		return id;
	}
	public void mostrarInformacion(String nombre, String correo, int id) {
		System.out.println(nombre+":"+" id:"+id+" correo:"+correo);
	}
	public void mostrarM(String m) {
		System.out.println(m);
	}
}
