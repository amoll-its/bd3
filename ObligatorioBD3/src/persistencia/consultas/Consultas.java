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

	public String insertarMascota ()  {
		String query = "insert into Mascotas (apodo, raza, cedulaDuenio) values (?,?,?)";
		return query;
	}

}
