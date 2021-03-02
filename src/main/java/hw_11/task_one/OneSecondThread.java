package hw_11.task_one;

import java.util.Date;

public class OneSecondThread implements Runnable {

    @Override
    public void run() {
        Date startTime = new Date();
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            synchronized (this) {
                if (!oneSecondPause()) break;
            }
            System.out.println("Time passed from the start of Program = "
                    + ((new Date().getTime() - startTime.getTime()) / 1000) + " seconds");
        }
    }

    private boolean oneSecondPause() {
        try {
            wait(1000);
        } catch (InterruptedException e) {
            return false;
        }
        notifyAll();
        return true;
    }
}