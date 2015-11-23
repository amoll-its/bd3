package logica;

import java.io.Serializable;

public class Monitor  implements Serializable{
	private int cantLectores;
	private boolean escribiendo;
	private static Monitor instancia;
	
	private final static long serialVersionUID = 1;
	
	private Monitor() { 
		cantLectores = 0;
		escribiendo = false;
	}
	
	public static Monitor getInstancia(){
		if (instancia == null)
			instancia = new Monitor();
		return instancia;
	}
	
	public synchronized void comienzoLectura() {
		while (escribiendo == true)
			try {
				wait();
			} catch (InterruptedException e) {
		}
		cantLectores++;
	}

	public synchronized void comienzoEscritura() {
		while (cantLectores > 0 || escribiendo == true)	
			try {
				wait();
			} catch (InterruptedException e) {
			}
		escribiendo = true;
	}

	public synchronized void terminoLectura() {	
		cantLectores--;
		notifyAll();
	}

	public synchronized void terminoEscritura() {
		escribiendo = false;
		notifyAll();
	}

}
