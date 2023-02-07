package ExecutorServices;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        executorService.execute(new Runnable() {
            private int delay;
            int first = 0;
            int second = 1;
            int next;

            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter any number");
                int number = scanner.nextInt();

                for (int i = 0; i < number; i++) {
                    System.out.print(first + " ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    next = first + second;
                    first = second;
                    second = next;
                }


            }
        });

    }
}

