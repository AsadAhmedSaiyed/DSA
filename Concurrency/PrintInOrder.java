import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PrintInOrder {
    // BF
    class Foo {

        private volatile boolean firstDone = false;
        private volatile boolean secondDone = false;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstDone = true;
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while (!firstDone) {

            }
            printSecond.run();
            secondDone = true;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!secondDone) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    // sync
    class Foo2 {

        private boolean firstDone = false;
        private boolean secondDone = false;

        public Foo2() {

        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstDone = true;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while (!firstDone) {
                wait();
            }
            printSecond.run();
            secondDone = true;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (!secondDone) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class Foo3 {
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);

        public Foo3() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            s1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            s1.acquire();
            printSecond.run();
            s2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            s2.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class Foo4 {
        private CountDownLatch firstDone = new CountDownLatch(1);
        private CountDownLatch secondDone = new CountDownLatch(1);

        public Foo4() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            printFirst.run();
            firstDone.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            firstDone.await();
            printSecond.run();
            secondDone.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            secondDone.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}