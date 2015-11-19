package persistencia.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EDueño;
import logica.Entidades.EMascota;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import persistencia.consultas.Consultas;
import poolConexiones.IConexion;

public class DAOMascotas implements IDAOMascotas {

	private int cedulaDueño;

	public void DAOMascotas(int cedulaDueño, IConexion icon) {
		this.cedulaDueño = cedulaDueño;
	}

	public void insert (EMascota em, IConexion icon) throws SQLException  {

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
		Connection con = icon.getConnection();
		
		Consultas cons = new Consultas ();
		String creareg = cons.insertarMascota();
			java.sql.PreparedStatement pstmt = con.prepareStatement(creareg);
			pstmt.setString(1, em.getApodo());
			pstmt.setString(2, em.getRaza());
			pstmt.setInt(3, cedulaDueño);
			int result=pstmt.executeUpdate();
			pstmt.close();

		/* cierro la conexión */
//			abd.cierroCon(con);
		
	}
	
	public List<VOMascota> listarMascotas(IConexion icon) throws SQLException {

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

		List <VOMascota> listamas = new LinkedList<VOMascota> (); 
		Consultas cons = new Consultas ();
		String query = cons.listarMascotas();
		try {
			java.sql.PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cedulaDueño);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String apodo = rs.getString ("apodo");
				String raza = rs.getString ("raza"); 
				int cedula = rs.getInt ("cedulaDuenio");
				VOMascota datoMascota = new VOMascota (apodo, raza, cedula);
                listamas.add(datoMascota);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* cierro la conexión */
			abd.cierroCon(con);
		return listamas;
	}
	
	public void borrarMascotas(IConexion icon) throws SQLException {

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
		String borrarfilas = cons.borrarMascotas();

		java.sql.PreparedStatement pstmt = con.prepareStatement(borrarfilas);
		pstmt.setInt (1, cedulaDueño);
		int result=pstmt.executeUpdate();
		pstmt.close();
		
		/* cierro la conexión */
		abd.cierroCon(con);		
		
	}

}
