package Threads;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyThread myThread = new MyThread("red", 1000);
        myThread.start();

        RunnableThread runnableThread = new RunnableThread(1000);
        Thread t = new Thread(runnableThread);
        t.start();

    }
}

class MyThread extends Thread {
    private final String name;
    private final int delay;
    int first = 0;
    int second = 1;
    int next;

    public MyThread(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.print(first + " ");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            next = first + second;
            first = second;
            second = next;
        }

    }
}

class RunnableThread implements Runnable {
    private final int delay;
    int first = 0;
    int second = 1;
    int next;

    public RunnableThread(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.print(first + " ");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            next = first + second;
            first = second;
            second = next;
        }


    }
}

