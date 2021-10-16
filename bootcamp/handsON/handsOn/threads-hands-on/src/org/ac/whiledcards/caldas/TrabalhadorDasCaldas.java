package org.ac.whiledcards.caldas;

public class TrabalhadorDasCaldas implements Runnable {


    private String name;

    public TrabalhadorDasCaldas(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println(name + " : Aqui a fazer uma loiça...");

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Estava a dormir mas acordaram-me...");
                e.printStackTrace();
            }
        }

        System.out.println(name + " : Não faço nem mais um caralho!");


    }
}
