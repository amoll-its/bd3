package logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CargoFabrica {

	public CargoFabrica() {
		// TODO Auto-generated constructor stub
	}

	public String nombre () {
		String nomfab = null;
		try{
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream("conexion.properties"));
			nomfab = propiedades.getProperty("fabrica");
		}catch (FileNotFoundException e){ 	
		   System.out.println("Error, El archivo no exite");
		}
		 catch (IOException e){ 
		   System.out.println("Error, No se puede leer el archivo");
		 }
		return nomfab;
	}

}
