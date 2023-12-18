package ec.edu.ups.Dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.idao.IPrestamo;
import ec.edu.ups.modelos.*;

public class PrestamoDAO implements IPrestamo {
	List<Prestamo> listaPrestamos;
	public PrestamoDAO() {
		listaPrestamos=new ArrayList<Prestamo>();
	}
	@Override
	public List<Prestamo> obtenerPrestamos() {
		return listaPrestamos;
	}

	@Override
	public Prestamo obtenerPrestamo(int id) {
		for(Prestamo prestamo: listaPrestamos) {
			if(prestamo.getLibro().getId()==id) {
				return prestamo;
			}
		}
		return null;
	}

	@Override
	public void agregarPrestamo(Prestamo prestamo) {
		listaPrestamos.add(prestamo);
	}

	@Override
	public boolean actualizarPrestamo(int id,Prestamo prestamo) {
		for(int i=0;i<listaPrestamos.size();i++) {
			if(listaPrestamos.get(i).getLibro().getId()==id) {
				listaPrestamos.set(i, prestamo);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean eliminarPrestmao(int id) {
		for(int i=0;i<listaPrestamos.size();i++) {
			if(listaPrestamos.get(i).getLibro().getId()==id) {
				listaPrestamos.remove(i);
				return true;
			}
		}
		return false;
	}

}
