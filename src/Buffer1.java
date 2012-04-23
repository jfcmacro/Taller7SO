// Buffer1.java

import Semaphore.Semaphore;
import Semaphore.Implementation;

/* Ejemplo de Un productor y consumidor utilizando la clase Buffer1
 */

public class Buffer1 {

    static final int BufferSize = 5;
    private Object[] buffer = new Object[BufferSize];

    private int in;
    private int out;
    private Semaphore items, spaces;

    public Buffer1() {
	in = 0;
	out = 0;
	items = new SemaphoreImplementation(0);
	spaces = new SemaphoreImplementation(BufferSize);
    }

    public void insert(Object item) {
	spaces.semWait();
	buffer[in] = item;
	in = (in + 1) % BufferSize;
	items.semSignal();
    }

    public Object remove() {
	Object item;
	items.semWait();
	item = buffer[out];
	out = (out + 1) % BufferSize;
	spaces.semSignal();
	return item;
    }
}
