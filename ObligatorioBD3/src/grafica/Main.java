package grafica;

import java.awt.EventQueue;

public class Main {

  public static void main(String[] args) {
	  
    /* el programa principal únicamente despliega la ventana principal */
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				VentanaDueños window = new VentanaDueños();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});	
  }				
}
