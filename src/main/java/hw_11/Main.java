package hw_11;

import hw_11.task_one.FiveSecondsThread;
import hw_11.task_one.OneSecondThread;
import hw_11.task_two.TaskTwo;

public class Main {
    public static void main(String[] args) {

        System.out.println("Testing task two:");
        System.out.println(TaskTwo.creatingStringOfNumbersWithReplacement(15));

        printingDelimeter();

        System.out.println("Testing task one: ");
        Thread fiveSecondsThread = new Thread(new FiveSecondsThread());
        Thread eachSecondThread = new Thread(new OneSecondThread());

        eachSecondThread.start();
        fiveSecondsThread.start();

        try {
            Thread.sleep(23000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fiveSecondsThread.interrupt();
        eachSecondThread.interrupt();
    }

    private static void printingDelimeter() {
        System.out.println();
        System.out.println("---------------------");
        System.out.println();
    }
}
