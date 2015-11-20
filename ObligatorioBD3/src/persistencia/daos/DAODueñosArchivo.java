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

import logica.Entidades.EDueño;
import logica.excepciones.NonexistentEntityException;
import logica.excepciones.PreexistingEntityException;
import logica.valueObjects.VODueño;
import poolConexiones.IConexion;

public class DAODueñosArchivo implements IDAODueños {

	final static Charset ENCODING = StandardCharsets.UTF_8;
	  
	public DAODueñosArchivo() {
		// TODO Auto-generated constructor stub
	}

	public List<VODueño> listarDueños(IConexion con) {

		List<String> contenido = null;
		List <VODueño> lista = new LinkedList<VODueño> (); 
		
		File folder = new File("/home/amoll/1/");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				String nomarch = file.getName();
				String namecheck = nomarch.substring(0, Math.min(nomarch.length(), 7));
			    if (namecheck.equals("duenio-")) {
//					System.out.println("Procesando: " + nomarch);
					Path path = Paths.get(folder + "/" + nomarch);
//					System.out.println("Cargando: " + folder + "/" + nomarch);
					try {
						contenido = Files.readAllLines(path, ENCODING);
						int cedula = Integer.parseInt(contenido.get(0));
						String nombre = contenido.get(1);
						String apellido = contenido.get(2); 
						VODueño datoDueño = new VODueño(cedula, nombre, apellido);
		                lista.add(datoDueño);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
			    }
			}
		}
		return lista;
	}

	@Override
	public void insert(EDueño ed, IConexion con) throws PreexistingEntityException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EDueño find(int ced, IConexion con) throws NonexistentEntityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int cedula, IConexion con) throws NonexistentEntityException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DAODueños() {
		// TODO Auto-generated method stub
		
	}

}
