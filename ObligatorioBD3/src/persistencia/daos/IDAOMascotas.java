package persistencia.daos;

import java.sql.SQLException;
import java.util.List;

import logica.Entidades.EMascota;
import logica.valueObjects.VOMascota;
import poolConexiones.IConexion;

public interface IDAOMascotas {
	
		public void DAOMascotas(int cedulaDueño);
		public void insert (EMascota em, IConexion icon) throws SQLException;
		public List<VOMascota> listarMascotas(IConexion icon) throws SQLException;
		public void borrarMascotas(IConexion icon) throws SQLException;
}
