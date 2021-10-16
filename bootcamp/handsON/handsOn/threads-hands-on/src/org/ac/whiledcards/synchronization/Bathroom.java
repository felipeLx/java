package org.ac.whiledcards.synchronization;

public class Bathroom implements Runnable {

    public static void main(String[] args) {

        Bathroom wc = new Bathroom();

        Thread rafa = new Thread(wc);
        rafa.setName("Rafa");

        Thread tiago = new Thread(wc);
        tiago.setName("Tiago");

        rafa.start();
        tiago.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread marta = new Thread(wc.new BathroomKeeper(wc));
        marta.setName("Marta");
        marta.start();

    }


    public synchronized void goToBathroom() {

        System.out.println(Thread.currentThread().getName() + " entered the bathroom");

        try {

            //Thread.sleep(2000);
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is finally leaving the bathroom");

    }

    @Override
    public void run() {
        goToBathroom();
    }

    private class BathroomKeeper implements Runnable {

        private Bathroom wc;

        public BathroomKeeper(Bathroom wc) {
            this.wc = wc;
        }

        public void shout() {

            synchronized (wc) {
                System.out.println(Thread.currentThread().getName() + ": Get the hell out!!!");
                wc.notifyAll();
            }
        }

        @Override
        public void run() {
            shout();
        }
    }
}
