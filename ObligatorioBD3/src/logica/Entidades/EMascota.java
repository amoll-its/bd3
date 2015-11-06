package logica.Entidades;

public class EMascota {

	private String apodo;
	private String raza;
	private int cedulaDueño;

	public EMascota (String apodo, String raza, int cedula) {
		this.apodo = apodo;
		this.raza = raza;
		this.cedulaDueño = cedula;
	}
	
	public String getApodo () {
		return apodo;
	}
	
	public String getRaza () {
		return raza;
	}
	
	public int getCedulaDueño () {
		return cedulaDueño;
	}

}
