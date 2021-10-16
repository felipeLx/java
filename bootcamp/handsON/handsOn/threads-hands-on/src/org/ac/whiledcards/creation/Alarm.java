package org.ac.whiledcards.creation;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {

    private Timer timer;


    public static void main(String[] args) {

        System.out.println("This is thread " + Thread.currentThread().getName());


        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of times to ring?");
        int numRings = scanner.nextInt();

        System.out.println("Ring interval in seconds?");
        int ringInterval = scanner.nextInt();

        Alarm alarm = new Alarm();
        alarm.start(ringInterval, numRings);

        Alarm alarm2 = new Alarm();
        alarm2.start(ringInterval, numRings);


        System.out.println("This is the end of main method");
    }

    private void start(int ringInterval, int numRings) {

        System.out.println("thread in method start " + Thread.currentThread().getName());

        timer = new Timer();
        timer.scheduleAtFixedRate(new Ring(numRings), ringInterval * 1000, ringInterval * 1000);
    }

    private void stop() {
        timer.cancel();
    }


    private class Ring extends TimerTask {

        private int numRings;

        public Ring(int numRings) {
            this.numRings = numRings;
        }

        @Override
        public void run() {

            System.out.println("My name is " + Thread.currentThread().getName());
            System.out.println("Ring ring...");

            numRings--;

            if (numRings == 0) {
                System.out.println("Alarm canceled");
                stop();
            }

        }
    }


}
