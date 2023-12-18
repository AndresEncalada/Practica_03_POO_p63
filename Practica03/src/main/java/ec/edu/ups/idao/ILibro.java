package ec.edu.ups.idao;

import java.util.List;

import ec.edu.ups.modelos.Libro;

public interface ILibro {
	List<Libro> obtenerLibros();
	Libro obtenerLibro(int id);
	void agregarLibro(Libro libro);
	boolean actualizarLibro(int id, Libro libro);
	boolean eliminarLibro(int id);
	
}
