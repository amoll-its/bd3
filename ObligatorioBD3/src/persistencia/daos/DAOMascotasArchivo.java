package persistencia.daos;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import logica.Entidades.EMascota;
import logica.excepciones.NonexistentEntityException;
import logica.valueObjects.VODueño;
import logica.valueObjects.VOMascota;
import poolConexiones.IConexion;

public class DAOMascotasArchivo implements IDAOMascotas {

	final static Charset ENCODING = StandardCharsets.UTF_8;
	private static String datafolder="data/";
	private int cedulaDueño;

	public DAOMascotasArchivo(int cedula) {
		this.cedulaDueño = cedula;
	}

	public void DAOMascotas(int cedula) {
		this.cedulaDueño = cedula;
	}

	public void insert(EMascota em, IConexion icon) {

		List<String> contenido = new LinkedList<String> ();
		contenido.add(em.getApodo());
		contenido.add(em.getRaza());
		
		File folder = new File(datafolder);
		String nomarch = Integer.toString(cedulaDueño);
		Path path = Paths.get(folder + "/" + "mascotas-" + nomarch + ".txt");
		try {
			Files.write(path, contenido, ENCODING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<VOMascota> listarMascotas(IConexion icon) throws NonexistentEntityException {

		List <VOMascota> listamas = new LinkedList<VOMascota> (); 
		List<String> contenido = null;

		File folder = new File(datafolder);
		String nomarch = Integer.toString(cedulaDueño);
		Path path = Paths.get(folder + "/" + "mascotas-" + nomarch + ".txt");
		try {
			contenido = Files.readAllLines(path, ENCODING);
		} catch (IOException e) {
			throw new NonexistentEntityException ("No se encuentra el registro");
		}		

		int i = 0;
		while (i < contenido.size()) {
			
			String apodo = contenido.get(i);
			String raza = contenido.get(i+1);
			VOMascota datoMascota = new VOMascota (apodo, raza, cedulaDueño);
            listamas.add(datoMascota);
			i=i+2;
		}						
		return listamas;
	}

	public void borrarMascotas(IConexion icon) {

		File folder = new File(datafolder);
		String nomarch = Integer.toString(cedulaDueño);
		Path path = Paths.get(folder + "/" + "mascotas-" + nomarch + ".txt");
		try {
		    Files.deleteIfExists(path);
		} catch (IOException e) {
		    System.err.println(e);
		}		
	}

}
