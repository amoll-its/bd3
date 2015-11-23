package persistencia.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EDueño;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import persistencia.consultas.Consultas;
import poolConexiones.Conexion;
import poolConexiones.IConexion;

public class DAODueños implements IDAODueños {

	public DAODueños() {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public void DAODueños() {
		// TODO Auto-generated method stub
		
	}

	public List<VODueño> listarDueños (IConexion icon) {
		/* devuelve un lista con todos los dueños */

	
		Connection con = ((Conexion)icon).getConnection();
		
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
			e.printStackTrace();
		}
		return lista;
	}		

	public void insert (EDueño ed, IConexion icon) throws PreexistingEntityException {
		/* inserta un nuevo dueño en la base de datos */

		Connection con = ((Conexion)icon).getConnection();
		
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
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new PreexistingEntityException ("La cédula ya está registrada");
			} else {
				e.printStackTrace();
		    }
		}
		
	}

	public EDueño find (int ced, IConexion icon) throws NonexistentEntityException {
		/* Busca un dueño a partir de su cédula */

		int cedula = 0;
		String nombre = "";
		String apellido = ""; 		
		
		Connection con = ((Conexion)icon).getConnection();
		
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
/*		try {
			abd.cierroCon(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		EDueño ed = new EDueño(cedula,nombre,apellido);	
		return ed;
		
	}

	public void delete (int cedula, IConexion icon) throws NonexistentEntityException {

		// Abro la conexión a la BD
/*		Connection con = null;
		AccesoBD abd = new AccesoBD();
		if (con == null)
		try {
			con = abd.abroCon();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		Connection con =((Conexion)icon).getConnection();
		
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
/*		try {
			abd.cierroCon(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
	}


}
