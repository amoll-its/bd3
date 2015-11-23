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
import poolConexiones.Conexion;
import poolConexiones.IConexion;

public class DAOMascotas implements IDAOMascotas {

	private int cedulaDueño;

	public DAOMascotas(int cedula) {
		this.cedulaDueño = cedula;
	}
	
	public void DAOMascotas(int cedula) {
		this.cedulaDueño = cedula;
	}
	
	public void insert (EMascota em, IConexion icon) throws SQLException  {

		Connection con = ((Conexion)icon).getConnection();
		
		Consultas cons = new Consultas ();
		String creareg = cons.insertarMascota();
			java.sql.PreparedStatement pstmt = con.prepareStatement(creareg);
			pstmt.setString(1, em.getApodo());
			pstmt.setString(2, em.getRaza());
			pstmt.setInt(3, cedulaDueño);
			int result=pstmt.executeUpdate();
			pstmt.close();

		
	}
	
	public List<VOMascota> listarMascotas(IConexion icon) throws SQLException {

		Connection con = ((Conexion)icon).getConnection();
		
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
			e.printStackTrace();
		}

		return listamas;
	}
	
	public void borrarMascotas(IConexion icon) throws SQLException {

		Connection con = ((Conexion)icon).getConnection();
		
		Consultas cons = new Consultas ();
		String borrarfilas = cons.borrarMascotas();

		java.sql.PreparedStatement pstmt = con.prepareStatement(borrarfilas);
		pstmt.setInt (1, cedulaDueño);
		int result=pstmt.executeUpdate();
		pstmt.close();
				
	}
}
