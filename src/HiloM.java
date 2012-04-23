// HiloM.java

import java.util.Random;   // Para generar valores aleatorios

public class HiloM extends Thread {

    // Variable que mantiene un conjunto de hilos
    static Thread conjuntoThread[] = new Thread[10];

    // Constructor del Hilo Multiple
    public HiloM() { }

    public void run() {

	Random rand = new Random();
	// Cada hilo espera un valor aleatorio en 0 y 8 segundos
	int valorAEsperar = rand.nextInt(8000);

	try {
	    Thread.sleep(valorAEsperar); // Duerme el hilo por un momento
	} catch (InterruptedException ie) { }

	System.out.println("Termine: " + Thread.currentThread());
    }

    public static void main(String []args) {

	try {
	    for (int i = 0; i < conjuntoThread.length; i++) {
		conjuntoThread[i] = new HiloM();
		conjuntoThread[i].start();
		System.out.println("Inicio: " + conjuntoThread[i]);
	    }

	    for (int i = 0; i < conjuntoThread.length; i++) {
		conjuntoThread[i].join();
	    }
	} catch (Exception e) {
	    System.err.println(e);
	    System.exit(1);
	}
    }
}
