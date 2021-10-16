package org.codewar.semaforo;

/*
count the number of signals sent to it by take() method calls.
We can change the Semaphore to do so. This is called a counting semaphore.
 */
public class CountingSemaphore {
    private int signals = 0;

    public synchronized void take() {
        this.signals++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException{
        while(this.signals == 0) wait();
        this.signals--;
    }
}
