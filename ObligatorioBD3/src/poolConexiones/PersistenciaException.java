package poolConexiones;


public class PersistenciaException extends Exception {
	private String serror;
	
	public PersistenciaException(String err) {
		serror=err;
	}
	
	public String getError(){
		return serror;
	}
}
