package persistencia.daos;

import java.util.List;

import logica.Entidades.EMascota;
import logica.valueObjects.VOMascota;
import poolConexiones.IConexion;

public class DAOMascotasArchivo implements IDAOMascotas {

	private int cedulaDueño;

	public DAOMascotasArchivo(int cedula) {
		this.cedulaDueño = cedula;
	}

	public void DAOMascotas(int cedula) {
		this.cedulaDueño = cedula;
	}

	public void insert(EMascota em, IConexion icon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VOMascota> listarMascotas(IConexion icon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarMascotas(IConexion icon) {
		// TODO Auto-generated method stub
		
	}

}
