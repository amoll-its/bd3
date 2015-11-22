package logica.Entidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import logica.excepciones.NonexistentEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.daos.DAODueños;
import persistencia.daos.DAOMascotas;
import persistencia.daos.IDAOMascotas;
import persistencia.fabrica.FabricaAbstracta;
import poolConexiones.IConexion;
import poolConexiones.IPoolConexiones;

public class EDueño {

	private int cedula;
	private String nombre;
	private String apellido;
	private FabricaAbstracta fabrica;
	private IDAOMascotas dmascotas;


	public EDueño (int cedula, String nombre , String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		String nomFab = null;
		String nomPool = null;

		try{
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("server.properties"));
			nomFab = propiedades.getProperty("fabrica");
		}catch (FileNotFoundException e){ 	
		   System.out.println("Error, el archivo de configuración no existe!");
		}
		 catch (IOException e){ 
		   System.out.println("Error, no se puede leer el archivo de configuración!");
		 }
		try {
			fabrica = (FabricaAbstracta) Class.forName(nomFab).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dmascotas = fabrica.crearDAOMascotas(cedula);
		
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

	public List<VOMascota> listarMascotas(IConexion icon) throws SQLException, NonexistentEntityException {

		List <VOMascota> lista = new LinkedList<VOMascota> ();
		lista = dmascotas.listarMascotas(icon);
		
		return lista;			
		
	}

	public void borrarMascotas(IConexion icon) throws SQLException {
		dmascotas.borrarMascotas(icon);
	}
	
}
