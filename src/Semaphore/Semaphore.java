// Semaphore.java

package Semaphore;

/* Esta clase implementa las operaciones b�sicas
   de un sem�foro. Ver: Bacon, Harris. Operating
   Systems p�g: 306.
*/

public interface Semaphore {
    public void semWait();
    public void semSignal();
}
