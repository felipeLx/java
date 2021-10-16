package org.codewar.semaforo;

public class RecevingThread {
    Semaphore semaphore = null;

    public RecevingThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run() throws InterruptedException {
        while(true){
            this.semaphore.release();
            //receive signal, then do something...
        }
    }
}
