package creaBD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreaBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Properties p = new Properties ();
			String nomArch = "config.properties";
			p.load (new FileInputStream (nomArch));
			
			/* Cargo dinamicamente el driver de MySQL */
			String driver = p.getProperty("driver");
			Class.forName(driver);

			/* Una vez cargado el driver, me conecto con la base de datos */
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			Connection con = DriverManager.getConnection(url, user, password);

			/* Creo la base de datos */
			String creadb = "Create database Certamen";
			Statement stmt = con.prepareStatement(creadb);
			int cant = stmt.executeUpdate(creadb);
			stmt.close();
			System.out.print("Resultado de " + creadb + ": ");
			System.out.println(cant + " bases creadas");

			/* Selecciono base */
			creadb = "Use Certamen";
			stmt = con.prepareStatement(creadb);
			cant = stmt.executeUpdate(creadb);
			stmt.close();
			System.out.print("Resultado de " + creadb + ": ");
			System.out.println(cant + " bases seleccionadas");

			/* Creo tabla Dueños */
			String creatb = "create table Duenios (cedula INT primary key, nombre VARCHAR(45), apellido VARCHAR(45))";
			
			Statement stmt2 = con.createStatement();
			cant = stmt2.executeUpdate(creatb);
			stmt2.close();
			System.out.print("Resultado de " + creatb + ": ");
			System.out.println(cant + " tablas creadas");
			
			/* Creo tabla Mascotas */
			creatb = "create table Mascotas (apodo VARCHAR(45) primary key, raza VARCHAR(45), cedulaDuenio INT, FOREIGN KEY (cedulaDuenio) REFERENCES Duenios (cedula))";
			Statement stmt3 = con.createStatement();
			cant = stmt3.executeUpdate(creatb);
			stmt3.close();
			System.out.print("Resultado de " + creatb + ": ");
			System.out.println(cant + " tablas creadas");

			/* Inserto los registros iniciales */
		    String creareg = "insert into Duenios values (1234567,'Jimi','Hendrix')"; 
			Statement stmt4 = con.createStatement();
			cant = stmt4.executeUpdate(creareg);
			creareg = "insert into Duenios values (2345678,'Janis','Joplin')";
			cant = stmt4.executeUpdate(creareg);
			creareg = "insert into Duenios values (3456789,'Jim','Morrison')";
			cant = stmt4.executeUpdate(creareg);
			creareg = "insert into Duenios values (4567890,'Kurt','Cobain')";
			cant = stmt4.executeUpdate(creareg);
			creareg = "insert into Duenios values (5678901,'Amy','Winehouse')";
			cant = stmt4.executeUpdate(creareg);
			stmt4.close();
			
			/* Cierro la conexion con la base de datos */
			con.close();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
