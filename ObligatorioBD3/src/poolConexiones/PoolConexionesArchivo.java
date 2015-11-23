package poolConexiones;

import logica.Monitor;
import logica.excepciones.PersistenciaException;

public class PoolConexionesArchivo implements IPoolConexiones {

    private int cantLectores;
    private boolean escribiendo;
    private Monitor m;
	
	public PoolConexionesArchivo() {
        this.cantLectores=0;
        this.escribiendo=false;
        m= new Monitor();
	}

	public IConexion obtenerConexion(boolean mod) throws PersistenciaException {
    	if (mod) {
    		// COMIENZA ESCRITURA
    		m.comienzoEscritura();
		} else {
    		// COMIENZA LECTURA
			m.comienzoLectura();
    	}
		return null;
	}

	public void liberarConexion(IConexion conex, boolean res,  boolean escribe) throws PersistenciaException {
    	// TERMINA ESCRITURA
    	if (escribe){
    		m.terminoEscritura();
    	} else {
    	// TERMINA LECTURA
			m.terminoLectura();
    	}
		
	}

}
