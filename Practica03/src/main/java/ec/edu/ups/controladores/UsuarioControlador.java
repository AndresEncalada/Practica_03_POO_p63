package ec.edu.ups.controladores;

import java.util.List;

import ec.edu.ups.Dao.UsuarioDAO;
import ec.edu.ups.modelos.Prestamo;
import ec.edu.ups.modelos.Usuario;
import ec.edu.ups.vistas.UsuarioVista;

public class UsuarioControlador {
	//Atributos de la clase
	private UsuarioDAO usuariodao;
	private Usuario usuario;
	private UsuarioVista usuariovista;
	//Controlador con parametros 
	public UsuarioControlador(UsuarioDAO usuariodao, UsuarioVista usuariovista) {
		this.usuariodao=usuariodao;
		this.usuariovista=usuariovista;
	}
	//Metodo que agrega el usuario a la lista de usuarios
	public void crearUsuario(Usuario usuario) {
		this.usuario=usuario;
		usuariodao.agregarUsuario(usuario);
	}
	//Metodo para actualizar un Usuario
	public void atualizarUsuario() {
		usuario=usuariovista.cambiarDatosUsuario();
		if(usuariodao.actualizarUsuario(usuario.getId(), usuario) == true){
            usuariovista.mostrarM("Los datos se han actualizado.");                    
        }
		else{
            usuariovista.mostrarM("Ocurrio un error.");                    
        
        }
	}
	//Metodo que agrega el prestamo a la lista de prestamos del usuario
	public void agregarPrestamo(Usuario usuario,Prestamo prestamo) {
		usuario.setListaPrestamos(prestamo,true);
	}
	//Metodo que elimina el prestamo a la lista de prestamos del usuario
	public void eliminarPrestamo(Usuario usuario, Prestamo prestamo) {
		usuario.setListaPrestamos(prestamo,false);
	}
	//Metodo para eliminar un usuario de la lista de usuarios
	public void eliminarUsuario(){
        int id = usuariovista.eliminarUsuario();
        if(usuariodao.eliminarUsuario(id) == true){
            usuariovista.mostrarM("Usuarios eliminado.");                    
        }
        else{
            usuariovista.mostrarM("Ocurrio un error.");
        }
    }
	//Metodo para buscar un usuario segun un id solicitado
	public void buscarUsuario() {
		int id = usuariovista.buscarUsuario();
        usuario = usuariodao.obtenerUsuario(id);
        if(usuario == null){
            usuariovista.mostrarM("Usuario no encontrado");
        }else{
            usuariovista.mostrarInformacion(usuario.getNombre(),usuario.getCorreo(),usuario.getId());
        }
    }
	//Metodo para mostrar todos los usuarios registrados
	public void mostrarUsuarios(){
        List<Usuario> listaUsuarios = usuariodao.obtenerUsuarios();
        for (Usuario usuario : listaUsuarios) {
            usuariovista.mostrarInformacion(usuario.getNombre(),usuario.getCorreo(),usuario.getId());
        }
	}
	//Metodo que devuelve toda la lista de prestamos
	public List<Prestamo> mostrarPrestamos(Usuario usuario) {
		return usuario.getListaPrestamos();
	}
}
