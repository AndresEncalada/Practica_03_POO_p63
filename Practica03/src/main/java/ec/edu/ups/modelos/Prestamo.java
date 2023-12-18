package ec.edu.ups.modelos;

import java.time.LocalDate;
import java.util.Date;
import ec.edu.ups.modelos.*;

public class Prestamo {
	private Libro libro;
	private Usuario usuario;
	private LocalDate fechaprestamo;
	private LocalDate fechaDevolucion;
	public Prestamo(){
	}
	public Prestamo(Libro libro, Usuario usuario) {
		this.libro = libro;
		this.usuario = usuario;
		this.fechaprestamo = LocalDate.now();
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDate getFechaprestamo() {
		return fechaprestamo;
	}
	public void setFechaprestamo(LocalDate fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	@Override
	public String toString() {
		return "Prestamo [usuario=" + usuario + ", fechaprestamo=" + fechaprestamo + ", fechaDevolucion="
				+ fechaDevolucion + "]";
	}
	
	
	
}
