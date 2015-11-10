package persistencia.consultas;

public class Consultas {
	
	public String listarDueños ()  {
		String query = "select * from Duenios";
		return query;
	}

	public String insertarDueño ()  {
		String query = "insert into Duenios (cedula, nombre, apellido) values (?,?,?)";
		return query;
	}

}
