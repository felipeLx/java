package org.ac.whiledcards.caldas;

public class FabricaDasCaldas {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {

            Thread trabalhador = new Thread(new TrabalhadorDasCaldas("Walter" + i));
            trabalhador.start();

            System.out.println("Gerente: À espera que estes colaboradores acabem...");

            try {

                trabalhador.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Gerente: Finalmente acabaram, vou pa casa!");

    }

}
