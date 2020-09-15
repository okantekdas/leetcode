package leetcode.concurrency;

import java.util.function.IntConsumer;

/* https://leetcode.com/problems/print-zero-even-odd/ */
public class ZeroEvenOdd {
    private int n;

    boolean isZeroNext = true;
    boolean isOddNext = false;
    boolean isEvenNext = false;

    int counter = 0;
    int number = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {

        while (counter < 2 * n) {
            while (!isZeroNext) {
                this.wait();
            }

            if (counter != 2 * n) {
                isZeroNext = false;
                if (number % 2 == 0) {
                    isEvenNext = true;
                } else {
                    isOddNext = true;
                }
                counter++;
                printNumber.accept(0);
            } else {
                isEvenNext = true;
                isOddNext = true;
            }
            this.notifyAll();
        }

    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {

        while (counter < 2 * n) {
            while (!isEvenNext) {
                this.wait();
            }
            if (counter != 2 * n) {
                isZeroNext = true;
                isEvenNext = false;
                counter++;
                printNumber.accept(number++);
            } else {
                isZeroNext = true;
                isOddNext = true;
            }
            this.notifyAll();

        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {

        while (counter < 2 * n) {
            while (!isOddNext) {
                this.wait();
            }
            if (counter != 2 * n) {
                isZeroNext = true;
                isOddNext = false;
                counter++;
                printNumber.accept(number++);

            } else {
                isZeroNext = true;
                isEvenNext = true;
            }
            this.notifyAll();
        }

    }

    static ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);

    public static void main(String[] args) {

        Runnable zero = new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(new IntConsumer() {

                        @Override
                        public void accept(int arg0) {
                            System.out.println(arg0);
                        }

                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable odd = new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(new IntConsumer() {

                        @Override
                        public void accept(int arg0) {
                            System.out.println(arg0);
                        }

                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable even = new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(new IntConsumer() {

                        @Override
                        public void accept(int arg0) {
                            System.out.println(arg0);
                        }

                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread z = new Thread(zero);
        Thread o = new Thread(odd);
        Thread e = new Thread(even);

        o.start();
        e.start();
        z.start();

    }
}
