package ec.edu.ups.Dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.idao.IUsuario;
import ec.edu.ups.modelos.Usuario;

public class UsuarioDAO implements IUsuario{
	List<Usuario> listaUsuarios;
	public UsuarioDAO() {
		listaUsuarios=new ArrayList<Usuario>();
	}
	@Override
	public List<Usuario> obtenerUsuarios() {
		return listaUsuarios;
	}

	@Override
	public Usuario obtenerUsuario(int id) {
		for(Usuario usuario:listaUsuarios) {
			if(usuario.getId()==id){
				return usuario;
			}
		}
		return null;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}

	@Override
	public boolean actualizarUsuario(int id, Usuario usuario) {
		for(int i=0;i<listaUsuarios.size();i++) {
			if(listaUsuarios.get(i).getId()==id) {
				listaUsuarios.set(i, usuario);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean eliminarUsuario(int id) {
		for(int i=0;i<listaUsuarios.size();i++) {
			if(listaUsuarios.get(i).getId()==id) {
				listaUsuarios.remove(i);
				return true;
			}
		}
		return false;
	}

}
