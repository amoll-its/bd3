package persistencia.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import logica.valueObjects.VODueño;
import persistencia.consultas.Consultas;

public class DAODueños {

	public DAODueños() {
		// TODO Auto-generated constructor stub
	}

	public List<VODueño> listarDueños () {
		/* devuelve un lista con todos los dueños */

		// Abro la conexión a la BD
		Connection con = null;
		AccesoBD abd = new AccesoBD();
		if (con == null)
		try {
			con = abd.abroCon();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		List <VODueño> lista = new LinkedList<VODueño> (); 
		
		Consultas cons = new Consultas ();
		
		String query = cons.listarDueños();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int cedula = rs.getInt ("cedula");
				String nombre = rs.getString ("nombre");
				String apellido = rs.getString ("apellido"); 
				VODueño datoDueño = new VODueño(cedula, nombre, apellido);
                lista.add(datoDueño);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* cierro la conexión */
		try {
			abd.cierroCon(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}		
}
