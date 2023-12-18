package ec.edu.ups.controladores;

import java.util.List;

import ec.edu.ups.Dao.PrestamoDAO;
import ec.edu.ups.modelos.Libro;
import ec.edu.ups.modelos.Prestamo;
import ec.edu.ups.modelos.Usuario;
import ec.edu.ups.vistas.PrestamoVista;



public class PrestamoControlador {
	//Atributos
	private PrestamoDAO prestamodao;
	private Prestamo prestamo;
	private PrestamoVista prestamovista;
	//Constructor con parametros
	public PrestamoControlador(PrestamoDAO prestamodao, PrestamoVista prestamovista) {
		this.prestamodao=prestamodao;
		this.prestamovista=prestamovista;
	}
	//Meotodo para pedir el id de un usuario
	public int obtenerIdU() {
		return prestamovista.ingresarDatosU();
	}
	//Metodo que genera un prestamo 
	public Prestamo crearPrestamo(Usuario usuario, List<Libro> listaLibros,int id) {
		for(Libro libro:listaLibros) {
			if(libro.getId()==id) {
				prestamo=new Prestamo(libro,usuario);
				prestamodao.agregarPrestamo(prestamo);
				return prestamo;
			}
		}
		if(prestamo==null) {
			prestamovista.mostrarM("Libro no encontrado");
		}
		return null;
	}
	//Metodo para buscar un prestamo segun el id
	public void buscarPrestamo(int id) {
        prestamo = prestamodao.obtenerPrestamo(id);
        if(prestamo == null){
            prestamovista.mostrarM("Prestamo no encontrado");
        }else{
            prestamovista.mostrarInformacion(prestamo.getLibro(),prestamo.getUsuario());
        }
    }
	//Metodo que muestra toda la lista de prestamos
	public void mostrarPrestamos(List<Prestamo> listaPrestamos){
        for (Prestamo prestamo : listaPrestamos) {
            prestamovista.mostrarInformacion(prestamo.getLibro(),prestamo.getUsuario());
        }
	}
}

