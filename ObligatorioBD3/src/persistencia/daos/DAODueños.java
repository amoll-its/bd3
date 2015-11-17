package persistencia.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EDueño;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PreexistingEntityException;
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

	public void insert (EDueño ed) throws PreexistingEntityException {
		/* inserta un nuevo dueño en la base de datos */

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

		Consultas cons = new Consultas ();
		String creareg = cons.insertarDueño();
		try {
			java.sql.PreparedStatement pstmt = con.prepareStatement(creareg);
			pstmt.setInt(1, ed.getCedula());
			pstmt.setString(2, ed.getNombre());
			pstmt.setString(3, ed.getApellido());
			int result=pstmt.executeUpdate();
			pstmt.close();
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

		
	}

	public EDueño find (int ced) throws NonexistentEntityException {
		/* Busca un dueño a partir de su cédula */

		int cedula = 0;
		String nombre = "";
		String apellido = ""; 		
		
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

		Consultas cons = new Consultas ();
		String buscad = cons.buscarDueño();
		try {
			java.sql.PreparedStatement pstmt = con.prepareStatement(buscad);
			pstmt.setInt(1, ced);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cedula = rs.getInt ("cedula");
				nombre = rs.getString ("nombre");
				apellido = rs.getString ("apellido"); 
			}
			rs.close();
			pstmt.close();
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

		EDueño ed = new EDueño(cedula,nombre,apellido);	
		return ed;
		
	}

	public void delete (int cedula) throws NonexistentEntityException {

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
		
		Consultas cons = new Consultas ();
		String borrarfila = cons.borrarDueño();
		try {
			java.sql.PreparedStatement pstmt = con.prepareStatement(borrarfila);
			pstmt.setInt(1, cedula);
			int result=pstmt.executeUpdate();
			pstmt.close();
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
		
	}
	
}
