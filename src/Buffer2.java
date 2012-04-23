// Buffer2.java

import Semaphore.Semaphore;
import Semaphore.SemaphoreImplementation;

/*
 * Esta clase implementa un Buffer que puede se utilizado
 * por más de un productor y más de un consumidor.
 * Ver: Bacon, Harris. Operating Systems. Pag: 329
 */

public class Buffer2 {

    static final int BufferSize = 5;
    private Object[] buffer = new Object[BufferSize];

    private int in;
    private int out;
    private Semaphore items, spaces, guard;

    public Buffer2() {
	in = 0;
	out = 0;
	items = new SemaphoreImplementation(0);
	spaces = new SemaphoreImplementation(BufferSize);
	guard = new SemaphoreImplementation(1);
    }

    public void insert(Object item) {
	spaces.semWait();
	guard.semWait();
	buffer[in] = item;
	in = (in + 1) % BufferSize;
	guard.semSignal();
	items.semSignal();
    }

    public Object remove() {
	Object item;
	items.semWait();
	guard.semWait();
	item = buffer[out];
	out = (out + 1) % BufferSize;
	spaces.semSignal();
	return item;
    }
}
