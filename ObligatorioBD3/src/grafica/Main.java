package grafica;

import java.awt.EventQueue;

import grafica.ventanas.*;

public class Main {

  public static void main(String[] args) {
	  
    /* el programa principal únicamente despliega la ventana principal */
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				VentanaMain wmain = new VentanaMain();
//				window.frame.setVisible(true);
				wmain.visible();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});	
  }				
}
