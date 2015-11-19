package persistencia.daos;

import java.util.List;

import logica.Entidades.EMascota;
import logica.valueObjects.VOMascota;
import poolConexiones.IConexion;

public interface IDAOMascotas {
	
		public void DAOMascotas(int cedulaDueño, IConexion icon);
		public void insert (EMascota em, IConexion icon);
		public List<VOMascota> listarMascotas(IConexion icon);
		public void borrarMascotas(IConexion icon);
}
