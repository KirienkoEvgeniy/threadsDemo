package org.demo;

public class ThreadDemo1 {
    public static void main(String[] args){

        System.out.println("Main thread started...");
        JThread t= new JThread("JThread ");
        t.start();
        try{
            t.join();
        }
        catch(InterruptedException e){

            System.out.printf("%s has been interrupted", t.getName());
        }
        System.out.println("Main thread finished...");
    }

}
class JThread extends Thread {

    JThread(String name){
        super(name);
    }

    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        for(int i=1; i<6; i++) {
            try {
                System.out.println(i);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}

