// CIIRunnable.java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CIIRunnable implements Runnable {

    public void run() {

	int i = 0;
	while (true) {

	    try {
		// Esta clase duerme durante un segundo y espera
		// ser terminada por un hilo exterior.

		Thread.currentThread().sleep(1000);
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

	// Primero se crea una clase hilo que tenga como constructor
	// una instancia de la clase que implementa Runnable
	Thread t = new Thread(new CIIRunnable());

	t.start();

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

	    t.interrupt();
	} catch (IOException ioe) {
	    System.out.println("No pudo manejar la entrada de datos");
	}
    }
}
