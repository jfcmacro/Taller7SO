// SemaphoreImplementation.java

package Semaphore;

/*
 * Se implmenta un semaforo de conteo, siempre
 * su valor debe ser iniciado en uno.
 * Ver: Bacon, Harris. Operating Systems
 */

public class SemaphoreImplementation implements Semaphore {

    public SemaphoreImplementation(int count) {

	this.count = count;
    }

    private int count = 0;

    public SemaphoreImplementation() {
    }

    public synchronized void semWait() {
	count--;

	while (count < 0) {
	    try {
		wait();
	    } catch (InterruptedException ie) { }
	}
    }

    public synchronized void semSignal() {

	count++;

	if (count >= 0) {
	    notifyAll();
	}
    }
}
