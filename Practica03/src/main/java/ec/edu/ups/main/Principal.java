package ec.edu.ups.main;

import java.util.Scanner;

import ec.edu.ups.Dao.*;
import ec.edu.ups.controladores.*;
import ec.edu.ups.modelos.Libro;
import ec.edu.ups.vistas.*;

public class Principal {
	public static void main(String args[]) {
		boolean menu=true;
		//Instancia de todos los DAO's, vistas y controladores
		BibliotecaDAO bibliotecadao=new BibliotecaDAO();
		BibliotecaVista bibliotecavista=new BibliotecaVista();
		BibliotecaControlador bibliotecaC=new BibliotecaControlador(bibliotecadao,bibliotecavista);
		while(menu==true) {		
			//Muestra de las opciones del menu
			Scanner scanm1=new Scanner(System.in);
			System.out.println("|---------------------Menu----------------------|");
			System.out.println("| 1. Agregar un nuevo libro a la biblioteca     |");
			System.out.println("| 2. Registrar nuevo usuario                    |");
			System.out.println("| 3. Ver prestamos por usuario                  |");
			System.out.println("| 4. Buscar libros disponibles                  |");
			System.out.println("| 5. Prestar libro a un usuario                 |");
			System.out.println("| 6. Devolver un libro                          |");
			System.out.println("| 7. Salir                                      |");
			System.out.println("|-----------------------------------------------|");
			System.out.println();
			System.out.print("Ingrese la opcion a realizar:");
			int ent=scanm1.nextInt();
			if(ent<1||ent>6) {
				System.out.println("Opcion invalida. Presione Enter para Continuar");
				Scanner scan1=new Scanner(System.in);
				String enin=scan1.nextLine();
			}
			//Opcion para registrar el libro en la biblioteca
			if(ent==1) {
				bibliotecaC.agregarLibro();		
			}
			//Opcion para registrar el usuario en la biblioteca
			if(ent==2) {
				 bibliotecaC.agregarUsuario();
			}
			//Opcion para mostrar los prestamos del usuario
			if(ent==3) {
				bibliotecaC.verPrestamosPorUsuario();
			}
			while(ent==4) {
				//Apertura de un segundo menu 
				Scanner scanm=new Scanner(System.in);
				System.out.println("|------------------------------|");
				System.out.println("|1. Buscar por ID              |");
				System.out.println("|2. Ver todos los disponibles  |");
				System.out.println("|3. Salir                      |");
				System.out.println("|------------------------------|");
				//Se pide la opcion al usuario
				System.out.print("Ingrese la opcion a realizar:");
				int entr=scanm.nextInt();
				System.out.println();
				if(entr<1||entr>3) {
					System.out.println("Opcion invalida. Presione Enter para Continuar");
					Scanner scan1=new Scanner(System.in);
					String enin=scan1.nextLine();
				}
				//Opcion para buscar un libro por su Id
				if(entr==1) {
					bibliotecaC.buscarporID();
				}
				if(entr==3) {
					break;
				}
				//Opcion que muestra todos los libros que esten disponibles 
				if(entr==2) {
						bibliotecaC.verLibrosDisponibles();			
				}
			}
			//Opccion para prestar un libro a un usuario
			if(ent==5) {
				bibliotecaC.prestarLibro();
			}
			if(ent==6) {
				bibliotecaC.devolverLibro();
			}
			if(ent==7) {
				break;
			}
		}
	}
}
