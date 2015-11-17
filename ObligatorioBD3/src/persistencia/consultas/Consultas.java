package persistencia.consultas;

public class Consultas {
	
	public String listarDueños ()  {
		String query = "select * from Duenios";
		return query;
	}

	public String buscarDueño ()  {
		String query = "select * from Duenios where cedula = ?";
		
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

	public String listarMascotas ()  {
		String query = "select * from Mascotas where cedulaDuenio = ?";
		return query;
	}

	public String borrarMascotas ()  {
		String query = "delete from Mascotas where cedulaDuenio = ?";
		return query;
	}
	
	public String borrarDueño ()  {
		String query = "delete from Duenios where cedula = ?";
		return query;
	}
	
}
