package ec.edu.ups.controladores;

import java.util.List;

import ec.edu.ups.controladores.*;
import ec.edu.ups.Dao.BibliotecaDAO;
import ec.edu.ups.Dao.LibroDAO;
import ec.edu.ups.Dao.PrestamoDAO;
import ec.edu.ups.Dao.UsuarioDAO;
import ec.edu.ups.modelos.*;
import ec.edu.ups.vistas.BibliotecaVista;
import ec.edu.ups.vistas.LibroVista;
import ec.edu.ups.vistas.PrestamoVista;
import ec.edu.ups.vistas.UsuarioVista;

public class BibliotecaControlador {
	//Atributos de la clase
	private PrestamoDAO pdao;
	private PrestamoVista pvista;
	private PrestamoControlador pC;
	
	private Biblioteca biblioteca;
	private BibliotecaDAO bibliotecadao;
	private BibliotecaVista bibliotecavista;
	
	private LibroDAO ldao;
	private Libro libro;
	private LibroVista lvista;
	private LibroControlador lcont;
	
	private UsuarioDAO udao;
	private Usuario usuario;
	private UsuarioVista uvista;
	private UsuarioControlador uC;
	
	//Constructor con parametors
	public BibliotecaControlador(BibliotecaDAO bibliotecadao, BibliotecaVista bibliotecavista) {
		this.pdao=new PrestamoDAO();
		this.pvista=new PrestamoVista();
		this.pC=new PrestamoControlador(pdao,pvista);
		
		this.udao=new UsuarioDAO();
		this.uvista=new UsuarioVista();
		this.uC=new UsuarioControlador(udao,uvista);
		
		this.ldao=new LibroDAO();
		this.lvista=new LibroVista();
		this.lcont=new LibroControlador(ldao,lvista);
		
		this.bibliotecadao=bibliotecadao;
		this.bibliotecavista=bibliotecavista;
	}
	//Metodo que crea la biblioteca y agrega los detalles de la biblioteca
		public void buscarporID(){
			int id=lcont.getId();
			Libro libro=this.verLibro(id);
			if(libro==null) {
				
			}
			else {
				lcont.mostrarLibro(libro);
			}
		}
		public void verPrestamosPorUsuario() {
		//Obtiene el id del usuario
		int idU=pC.obtenerIdU();
		//Si el usuario es nulo se muestra el mensaje de error, si no
		//se muestra la lista de prestamos que posee el usuario
		if(this.verUsuario(idU)==null) {
			bibliotecavista.mostrarM("Usuario no encontrado");
		}
		else {
		pC.mostrarPrestamos(uC.mostrarPrestamos(this.verUsuario(idU)));
		}
	}
		public void verLibrosDisponibles() {
			lcont.mostrarLibros(this.verLibros());

		}
		public void prestarLibro() {
			//Se obtiene el id del usuario 
			int id=lcont.prestarLibro();
			//Se instancia un libro 
			Libro libro=this.verLibro(id);
			if(libro==null) {
				
			}
			else {
				//Si el libro esta disponible prosigue con el programa
			if(libro.isDisponible()==true) {
				//Se obtiene el id del usuario
				int idU=pC.obtenerIdU();
				if(this.verUsuario(idU)==null) {
				}
				else {
				//Se agrega el prestamo a la lista de prestamos que posee el usuario
				uC.agregarPrestamo(this.verUsuario(idU), pC.crearPrestamo(this.verUsuario(idU), this.verLibros(), id));
				this.prestarLibro(libro);
				}
			}
			else {
				System.out.println("Libro no disponible");
			}
			}
		
		}
		public void devolverLibro() {
			//Se repite el proceso de arriba pero en ese caso se intercambian los metodos por los de devolucion
			int id=lcont.devolverLibro();
			Libro libro=this.verLibro(id);
			if(libro==null) {
			}
			else {
			if(libro.isDisponible()==false) {
				int idU=pC.obtenerIdU();
				if(this.verUsuario(idU)==null) {
				}
				else {
				uC.eliminarPrestamo(this.verUsuario(idU), pC.crearPrestamo(this.verUsuario(idU), this.verLibros(), id));
				this.devolverLibro(libro);
				}
			}
			else {
				System.out.println("El libro no fue prestado");
			}
			}
		
		}
	
	public void crearBiblioteca() {
		this.biblioteca=new Biblioteca("Biblioteca CCE","Calle Luis Cordero");
	}
	//Metodo que devuelve la lista de libros registrados
	public List<Libro> verLibros() {
		List<Libro> lista=bibliotecadao.verLibros();
		return lista;
	}
	//Metodo que retorna un libro segun el id de libro
	public Libro verLibro(int id) {
		if(bibliotecadao.buscarLibro(id)==null) {
			bibliotecavista.mostrarM("Libro no encontrado");
		}
		else {
			return bibliotecadao.buscarLibro(id);
		}
		return null;
	}
	//Metodo que retorna un usuario segun el id del usuario
	public Usuario verUsuario(int id) {
		if(bibliotecadao.buscarUsuario(id)==null) {
			bibliotecavista.mostrarM("Usuario no encontrado");
		}
		else {
			return bibliotecadao.buscarUsuario(id);
		}
		return null;
	}
	//Metodo que registra un libro en la biblioteca
	public void agregarLibro() {
		libro=lvista.ingresarDatos();
		bibliotecadao.agregarLibro(libro);
	}
	//Metodo que registra un usuario en la biblioteca
	public void agregarUsuario() {
		usuario=uvista.ingresarDatos();
		if(bibliotecadao.buscarUsuario(usuario)==false) {
			bibliotecadao.registrarUsuario(usuario);
		}
		else {
			bibliotecavista.mostrarM("Usuario ya registrado");
		}
	}
	//Metodos que son parte del CRUD
	public void actualizarLibro(Libro libro) {
		bibliotecadao.actualizarListaLibro(libro);
	}
	public void actualizarUsuario(Usuario usuario){
		bibliotecadao.actualizarListaUsuario(usuario);
	}
	//Metodo para prestar un libro
	public void prestarLibro(Libro libro) {
		//Actualiza la disponibilidad del libro
		bibliotecadao.actualizardispLibro(libro, false);
		bibliotecavista.prestarLibro();
	}
	//Metodo para devolver un libro
	public void devolverLibro(Libro libro) {
		//Actualiza la disponibilidad del libro
		bibliotecadao.actualizardispLibro(libro, true);
		bibliotecavista.devolverLibro();
	}
}
