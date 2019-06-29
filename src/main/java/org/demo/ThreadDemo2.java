package org.demo;

import java.util.Random;

public class ThreadDemo2 {

//    static ThreadDemoB threadDemoB;
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread started...");
        int n = new Random().nextInt(10) + 1;
        System.out.println(n);
        ThreadDemoB threadDemoB = new ThreadDemoB("ThreadDemoB");
        threadDemoB.start();

            Thread.sleep(n*1000);

        threadDemoB.interrupt();
        System.out.println("Main thread finished...");
    }
}

class ThreadDemoB extends Thread{
    ThreadDemoB(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        while (!isInterrupted()) {
            try {
                System.out.println("Sleeping...");
                sleep(10000);
                System.out.println("Done sleeping, no interrupt.");
            } catch (InterruptedException e) {
                System.out.println("ThreadDemoB was interrupted!");
                e.printStackTrace();
            }
        }
    }
}

