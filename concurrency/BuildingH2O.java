package leetcode.concurrency;

public class BuildingH2O {
    class H2O {

        int counter = 0;

        public H2O() {

        }

        public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            while (counter == 2) {
                wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            ++counter;
            notifyAll();
        }

        public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
            while (counter < 2) {
                wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            counter = 0;
            notifyAll();
        }
    }
}
