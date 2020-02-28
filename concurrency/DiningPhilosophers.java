package leetcode.concurrency;

/**
 * DiningPhilosophers
 */
public class DiningPhilosophers {
    static Object[] arr = new Object[5];

    // call the run() method of any runnable to execute its code
    public static void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
            Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        int rightFork = philosopher - 1;
        int leftFork = philosopher;
        if (rightFork < 0) {
            rightFork = 4;
        }

        Object rightLock = arr[rightFork];
        Object leftLock = arr[leftFork];

        if (rightLock == null) {
            arr[rightFork] = new Object();
            rightLock = arr[rightFork];
        }
        if (leftLock == null) {
            arr[leftFork] = new Object();
            leftLock = arr[leftFork];
        }

        synchronized (rightLock) {
            synchronized (leftLock) {
                pickRightFork.run();
                pickLeftFork.run();
                eat.run();
                putRightFork.run();
                putLeftFork.run();
            }
        }

    }

    public static void main(String[] args) {

    }
}