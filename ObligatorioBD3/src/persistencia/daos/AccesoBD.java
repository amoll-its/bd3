package persistencia.daos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import logica.valueObjects.VODueño;
import persistencia.consultas.Consultas;

public class AccesoBD {
		
	public Connection abroCon () throws FileNotFoundException, IOException {
		Connection con = null;
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
			con = DriverManager.getConnection(url, user, password);

			/* Selecciono BD */
			String comando = "Use " + p.getProperty("dbname");
			Statement stmt = con.prepareStatement(comando);
			int result = stmt.executeUpdate(comando);
			stmt.close();		
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public void cierroCon (Connection con) throws SQLException {
		/* Cierro la conexion con la base de datos */
		con.close();		
	}
	
}
