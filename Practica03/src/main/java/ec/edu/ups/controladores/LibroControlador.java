package ec.edu.ups.controladores;

import java.util.List;

import ec.edu.ups.Dao.LibroDAO;
import ec.edu.ups.modelos.Libro;
import ec.edu.ups.modelos.Usuario;
import ec.edu.ups.vistas.LibroVista;

public class LibroControlador {
	//Atributos
	private LibroDAO librodao;
	private LibroVista librovista;
	private Libro libro;
	//Constructor con parametros
	public LibroControlador(LibroDAO librodao, LibroVista librovista) {
		this.librodao=librodao;
		this.librovista=librovista;	
	}
	//Metodo que recibe los datos del libro y lo registra en la lista de libros
	public void crearLibro() {
		libro=librovista.ingresarDatos();
		librodao.agregarLibro(libro);
	}
	//Metodos que llaman a la vista del libro
	public int prestarLibro() {
		return librovista.eliminarLibro();
	}
	public int devolverLibro() {
		return librovista.devolverLibro();
	}
	//Metodo para actualizar un libro
	public void atualizarLibro() {
		libro=librovista.actualizarLibro();
		if(librodao.actualizarLibro(libro.getId(), libro) == true){
            librovista.mostrarM("Los datos se han actualizado.");                    
        }
		else{
            librovista.mostrarM("Ocurrio un error.");                    
        
        }
	}
	//Metodo para eliminar un libro
	public void eliminarLibro(){
        int id =librovista.eliminarLibro();
        if(librodao.eliminarLibro(id) == true){
            librovista.mostrarM("Libro eliminado.");                    
        }
        else{
            librovista.mostrarM("Ocurrio un error.");
        }
    }
	//Metodo para buscar un libro segun un id 
	public void buscarLibro() {
		int id = librovista.buscarLibro();
        libro = librodao.obtenerLibro(id);
        if(libro == null){
            librovista.mostrarM("Libro no encontrado");
        }else{
            librovista.mostrarInformacion(libro);
        }
    }
	//Metodo para obtener el id de un libro
	public int getId() {
		return librovista.buscarLibro();
	}
	//Metodo para mostrar la informacion de un libro 
	public void mostrarLibro(Libro libro) {
		librovista.mostrarInformacion(libro);
	}
	//Metodo para mostrar toda una lista de libros recibidos
	public void mostrarLibros(List<Libro> listaLibros){
        for (Libro libro : listaLibros) {
        	if(libro.isDisponible()==true) {
            librovista.mostrarInformacion(libro);
        	}
        }
	} 
}
