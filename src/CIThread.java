// CIThread.java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CIThread extends Thread {

    public CIThread() {
    }

    public void run() {

	int i = 0;
	while (true) {

	    try {
		// Esta clase duerme durante un segundo y espera
		// ser terminada por un hilo exterior.

		sleep(1000);
		System.out.println("He ejecutado " + i + " veces");
		i++;
	    } catch (InterruptedException ie) {
		// Ha sido interrumpido externamente
		System.out.println("");
		break;
	    } catch (Exception e) {
		// Ignora otro tipo de interrupciones
	    }
	}
    }

    public static void main(String args[]) {

	// Listo para crear un nuevo hilo de ejecución

	CIThread hilo = new CIThread();

	hilo.start();

	for (int i = 0; i < 10; i++) {

	    try {
		Thread.currentThread().sleep(1500);
	    } catch (InterruptedException ie) { } // La ignora

	}

	try {

	    // Crear un mecanismo de lectura
	    BufferedReader br =
		new BufferedReader(new InputStreamReader(System.in));

	    System.out.println("Señale el hilo para que termine");
	    br.readLine();

	    hilo.interrupt();
	} catch (IOException ioe) {
	    System.out.println("No pudo manejar la entrada de datos");
	}
    }
}
