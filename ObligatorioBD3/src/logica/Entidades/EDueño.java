package logica.Entidades;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.daos.DAODueños;
import persistencia.daos.DAOMascotas;
import poolConexiones.IConexion;

public class EDueño {

	private int cedula;
	private String nombre;
	private String apellido;

	public EDueño (int cedula, String nombre , String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public int getCedula () {
		return cedula;
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public String getApellido () {
		return apellido;
	}

	public List<VOMascota> listarMascotas(IConexion icon) throws SQLException {

		DAOMascotas dmascotas = new DAOMascotas (cedula);
		List <VOMascota> lista = new LinkedList<VOMascota> ();
		lista = dmascotas.listarMascotas(icon);
		
		return lista;			
		
	}

	public void borrarMascotas(IConexion icon) throws SQLException {
		DAOMascotas dmascotas = new DAOMascotas (cedula);
		dmascotas.borrarMascotas(icon);
	}
	
}
