package ec.edu.ups.modelos;

import java.util.Objects;

public class Libro {
	private String titulo;
	private String autor;
	private int año;
	private int id;
	private boolean disponible;
	public Libro(){}
	public Libro(String titulo, String autor, int año, boolean disponible) {
		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
		this.id=this.hashCode();
		this.disponible = disponible;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", año=" + año + ", id=" + id + ", disponible="
				+ disponible + "]";
	}
	
}
