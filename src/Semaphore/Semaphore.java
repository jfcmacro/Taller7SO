// Semaphore.java

package Semaphore;

/* Esta clase implementa las operaciones básicas
   de un semáforo. Ver: Bacon, Harris. Operating
   Systems pág: 306.
*/

public interface Semaphore {
    public void semWait();
    public void semSignal();
}
