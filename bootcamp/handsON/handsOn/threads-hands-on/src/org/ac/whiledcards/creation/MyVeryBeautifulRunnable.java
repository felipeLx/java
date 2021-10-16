package org.ac.whiledcards.creation;

public class MyVeryBeautifulRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println("Hello! I'm " + Thread.currentThread().getName());
    }
}
