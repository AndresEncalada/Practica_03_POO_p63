package ec.edu.ups.modelos;

import java.util.ArrayList;

public class Biblioteca {
	private String nombre;
	private String direccion;
	public Biblioteca(String nombre, String direccion) {
		this.nombre=nombre;
		this.direccion=direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
}
