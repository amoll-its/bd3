package persistencia.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import logica.Entidades.EDueño;
import logica.Entidades.EMascota;
import logica.excepciones.PreexistingEntityException;
import persistencia.consultas.Consultas;

public class DAOMascotas {

	private int cedulaDueño;

	public DAOMascotas(int cedulaDueño) {
		this.cedulaDueño = cedulaDueño;
	}

	public void insert (EMascota em) throws PreexistingEntityException {

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
		String creareg = cons.insertarMascota();
		try {
			java.sql.PreparedStatement pstmt = con.prepareStatement(creareg);
			pstmt.setString(1, em.getApodo());
			pstmt.setString(2, em.getRaza());
			pstmt.setInt(3, cedulaDueño);
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
