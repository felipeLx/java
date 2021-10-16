package org.codewar.semaforo;

import java.util.concurrent.Semaphore;

public class ProcessadorThread extends Thread {
    private int idThread;
    private Semaphore semaphore;

    public ProcessadorThread(int id, Semaphore semaphore) {
        this.idThread = id;
        this.semaphore = semaphore;
    }

    private void processar() {
        try {
            System.out.println("Thread #" + idThread + " processando");
            Thread.sleep((long) (Math.random() * 10000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void entrarRegiaoNaoCritica() {
        System.out.println("Thread #" + idThread + " em região não crítica");
        processar();
    }

    private void entrarRegiaoCritica() {
        System.out.println("Thread #" + idThread
                + " entrando em região crítica");
        processar();
        System.out.println("Thread #" + idThread + " saindo da região crítica");
    }

    @Override
    public void run() {
        entrarRegiaoNaoCritica();
        try {
            semaphore.acquire();
            entrarRegiaoCritica();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        int numeroDePermicoes = 2;
        int numeroDeProcessos = 6;
        Semaphore semaphore = new Semaphore(numeroDePermicoes);
        ProcessadorThread[] processos = new ProcessadorThread[numeroDeProcessos];
        for (int i = 0; i < numeroDeProcessos; i++) {
            processos[i] = new ProcessadorThread(i, semaphore);
            processos[i].start();
        }
    }
}
