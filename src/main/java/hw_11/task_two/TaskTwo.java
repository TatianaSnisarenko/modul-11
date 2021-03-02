package hw_11.task_two;

import java.util.Arrays;

public class TaskTwo {

    public static String creatingStringOfNumbersWithReplacement(int n) {

        int[] integers = new int[n];
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            integers[i] = i + 1;
        }

        Thread fizzThread = new Thread(() -> {
            fizz(integers, strings);
        });
        fizzThread.start();

        Thread buzzThread = new Thread(() -> {
            buzz(integers, strings);
        });
        buzzThread.start();

        Thread fizzBuzzTread = new Thread(() -> {
            fizzBuzz(integers, strings);
        });
        fizzBuzzTread.start();

        Thread numberThread = new Thread(() -> {
            number(integers, strings);
        });
        numberThread.start();

        while (!areAllTreadsTerminated(fizzThread, buzzThread, fizzBuzzTread, numberThread)) {
            sleepForOneSecond();
        }

        return String.join(", ", Arrays.asList(strings));
    }

    private static void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean areAllTreadsTerminated(Thread... threads) {
        boolean areTerminated = true;
        for (Thread thread : threads) {
            areTerminated = areTerminated && thread.getState() == Thread.State.TERMINATED;
        }
        return areTerminated;
    }

    private static void number(int[] integers, String[] strings) {
        for (int i = 0; i < integers.length; i++) {
            if (strings[i] == null) {
                strings[i] = String.valueOf(integers[i]);
            }
        }
    }

    private static void fizzBuzz(int[] integers, String[] strings) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 5 == 0 && integers[i] % 3 == 0) {
                strings[i] = "fizzbuzz";
            }
        }
    }

    private static void buzz(int[] integers, String[] strings) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 5 == 0 && integers[i] % 3 != 0) {
                strings[i] = "buzz";
            }
        }
    }

    private static void fizz(int[] integers, String[] strings) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 3 == 0 && integers[i] % 5 != 0) {
                strings[i] = "fizz";
            }
        }
    }
}
