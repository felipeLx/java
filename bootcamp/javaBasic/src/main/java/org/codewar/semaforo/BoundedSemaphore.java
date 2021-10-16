package org.codewar.semaforo;

/*
upper bound on how many signals it can store. We can change the semaphore implementation to have an upper bound
 */
public class BoundedSemaphore {
    private int signals = 0;
    private int bound   = 5; // we can delimited the bound of the threads

    public BoundedSemaphore(int upperBound){
        this.bound = upperBound;
    }

    public synchronized void take() throws InterruptedException{
        while(this.signals == bound) wait();
        this.signals++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException{
        while(this.signals == 0) wait();
        this.signals--;
        this.notify();
    }
}
