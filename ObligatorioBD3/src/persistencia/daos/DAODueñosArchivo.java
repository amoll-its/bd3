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
	private static String datafolder="data/";
	  
	public DAODueñosArchivo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DAODueños() {
		// TODO Auto-generated method stub
		
	}

	public List<VODueño> listarDueños(IConexion icon) {

		List<String> contenido = null;
		List <VODueño> lista = new LinkedList<VODueño> (); 
		
		File folder = new File(datafolder);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				String nomarch = file.getName();
				String namecheck = nomarch.substring(0, Math.min(nomarch.length(), 7));
			    if (namecheck.equals("duenio-")) {
					Path path = Paths.get(folder + "/" + nomarch);
					try {
						contenido = Files.readAllLines(path, ENCODING);
						int cedula = Integer.parseInt(contenido.get(0));
						String nombre = contenido.get(1);
						String apellido = contenido.get(2); 
						VODueño datoDueño = new VODueño(cedula, nombre, apellido);
		                lista.add(datoDueño);

					} catch (IOException e) {
						e.printStackTrace();
					}		
			    }
			}
		}
		return lista;
	}

	public void insert(EDueño ed, IConexion con) throws PreexistingEntityException {

		List<String> contenido = new LinkedList<String> ();

		contenido.add(Integer.toString(ed.getCedula()));
		contenido.add(ed.getNombre());
		contenido.add(ed.getApellido());

		File folder = new File(datafolder);
		String nomarch = Integer.toString(ed.getCedula());
		Path path = Paths.get(folder + "/" + "duenio-" + nomarch + ".txt");
		
		try {
			Files.write(path, contenido, ENCODING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public EDueño find(int ced, IConexion con) throws NonexistentEntityException {

		int cedula = 0;
		String nombre = "";
		String apellido = ""; 		
		List<String> contenido = null;

		// intento cargar el archivo correspondiente al dueño.
		File folder = new File(datafolder);
		String nomarch = Integer.toString(ced);
		Path path = Paths.get(folder + "/" + "duenio-" + nomarch + ".txt");
		try {
			contenido = Files.readAllLines(path, ENCODING);
			cedula = Integer.parseInt(contenido.get(0));
			nombre = contenido.get(1);
			apellido = contenido.get(2); 
		} catch (IOException e) {
			throw new NonexistentEntityException ("No se encuentra el registro");
		}		
		EDueño ed = new EDueño(cedula,nombre,apellido);	
		return ed;
	}

	public void delete(int cedula, IConexion con) throws NonexistentEntityException {

		File folder = new File(datafolder);
		String nomarch = Integer.toString(cedula);
		Path path = Paths.get(folder + "/" + "duenio-" + nomarch + ".txt");
		try {
		    Files.deleteIfExists(path);
		} catch (IOException e) {
		    System.err.println(e);
		}		
		
	}

}
