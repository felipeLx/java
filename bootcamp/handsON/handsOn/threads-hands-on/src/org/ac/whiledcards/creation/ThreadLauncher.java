package org.ac.whiledcards.creation;

public class ThreadLauncher {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            System.out.println("YO YO I'm thread " + Thread.currentThread().getName() + " in loop " +i);

            Thread thread = new Thread(new MyVeryBeautifulRunnable());
            thread.setName("Peppa nº " + i );
            thread.start();
        }

        MyVeryBeautifulRunnable peppa = new MyVeryBeautifulRunnable();
        peppa.run();
    }
}
