package poolConexiones;

import java.sql.Connection;

public class Conexion implements IConexion {

	private Connection con;
	
	public Conexion(Connection co){
		con=co;
	}
	
	public  Connection getConnection(){
		
		return con;
		
	}
	
}
