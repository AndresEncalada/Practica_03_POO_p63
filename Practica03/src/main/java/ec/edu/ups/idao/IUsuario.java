package ec.edu.ups.idao;

import java.util.List;

import ec.edu.ups.modelos.Usuario;

public interface IUsuario {
	List<Usuario> obtenerUsuarios();
	Usuario obtenerUsuario(int id);
	void agregarUsuario(Usuario usuario);
	boolean actualizarUsuario(int id, Usuario usuario);
	boolean eliminarUsuario(int id);
	
}
