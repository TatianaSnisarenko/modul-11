package hw_11.task_one;

public class FiveSecondsThread implements Runnable {
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();

        while (!currentThread.isInterrupted()) {
            synchronized (this) {
                if (!fiveSecondsPause()) break;
                System.out.println("Five seconds passed");
            }
        }
    }

    private boolean fiveSecondsPause() {
        for (int i = 0; i < 5; i++) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                return false;
            }
            notifyAll();
        }
        return true;
    }
}
