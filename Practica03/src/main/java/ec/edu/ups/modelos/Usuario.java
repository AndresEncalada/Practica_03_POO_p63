package ec.edu.ups.modelos;

import java.util.ArrayList;

import ec.edu.ups.modelos.Prestamo;

public class Usuario extends Persona {
	private String correo;
	private ArrayList<Prestamo> listaPrestamos;
	
	public Usuario() {
	}

	public Usuario(String correo, int id, String nombre) {
		this.correo = correo;
		this.nombre= nombre;
		this.identificacion=id;
		listaPrestamos=new ArrayList<Prestamo>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getId() {
		return identificacion;
	}
	public void setId(int id) {
		this.identificacion=id;
	}
	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(Prestamo prestamo,boolean v) {
		if(v==true) {
		this.listaPrestamos.add(prestamo);
		}
		else {
		this.listaPrestamos.remove(prestamo);
		}
	}
	@Override
	public void mostrarInformacion() {
		this.toString();
	}
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", id=" + identificacion + "]";
	}
	 
}
