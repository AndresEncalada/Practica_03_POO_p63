package ec.edu.ups.Dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.idao.IBiblioteca;
import ec.edu.ups.modelos.Libro;
import ec.edu.ups.modelos.Usuario;

public class BibliotecaDAO implements IBiblioteca {
	List<Libro> listaLibros;
	List<Usuario> listaUsuarios;
	public BibliotecaDAO() {
		listaLibros=new ArrayList<Libro>();
		listaUsuarios=new ArrayList<Usuario>();
	}
	@Override
	public void agregarLibro( Libro libro) {
		listaLibros.add(libro);
	}
	@Override
	public void registrarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);	
	}
	@Override
	public List<Libro> verLibros() {	
		return this.listaLibros;
	}
	@Override
	public List<Usuario> verUsuarios() {
		return listaUsuarios;
	}
	@Override
	public boolean buscarUsuario(Usuario usuario) {
		for(int i=0;i<listaUsuarios.size();i++) {
			if(listaUsuarios.get(i).getNombre()==usuario.getNombre()) {
				return true;
			}
		}
		return false;
	}
	@Override
	public Libro buscarLibro(int id) {
		for(Libro libro: listaLibros) {
			if(libro.getId()==id) {
				return libro;
			}
		}
		return null;
	}

	@Override
	public Usuario buscarUsuario(int id) {
		for(Usuario usuario: listaUsuarios) {
			if(usuario.getId()==id) {
				return usuario;
			}
		}
		return null;
	}
	@Override
	public Libro actualizardispLibro(Libro libro,boolean disp) {
		libro.setDisponible(disp);
		return libro;
	}
	@Override
	public boolean actualizarListaLibro(Libro libro) {
		for(int i=0;i<listaLibros.size();i++) {
			if(libro.getId()==listaLibros.get(i).getId()) {
				listaLibros.set(i, libro);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean actualizarListaUsuario(Usuario usuario) {
		for(int i=0;i<listaUsuarios.size();i++) {
			if(usuario.getId()==listaUsuarios.get(i).getId()) {
				listaUsuarios.set(i, usuario);
				return true;
			}
		}
		return false;
	}

	@Override
	public void eliminarLibro(Libro libro) {
		listaLibros.remove(libro);
	}

	@Override
	public void eliminarUsuaro(Usuario usuario) {
		listaUsuarios.remove(usuario);
		
	}
}
