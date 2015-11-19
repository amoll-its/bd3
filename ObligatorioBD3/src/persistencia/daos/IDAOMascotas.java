package persistencia.daos;

import java.util.List;

import logica.Entidades.EMascota;
import logica.valueObjects.VOMascota;

public interface IDAOMascotas {
	
		public void DAOMascotas(int cedulaDueño);
		public void insert (EMascota em);
		public List<VOMascota> listarMascotas();
		public void borrarMascotas();
}
