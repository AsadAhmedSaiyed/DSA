import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int i;
    private Semaphore fizzSem;
    private Semaphore buzzSem;
    private Semaphore fizzBuzzSem;
    private Semaphore numSem;

    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
        this.fizzSem = new Semaphore(0);
        this.buzzSem = new Semaphore(0);
        this.fizzBuzzSem = new Semaphore(0);
        this.numSem = new Semaphore(1);
    }

    private void release() {
        i++;
        if (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizzSem.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                buzzSem.release();
            } else if (i % 15 == 0) {
                fizzBuzzSem.release();
            } else {
                numSem.release();
            }
        } else {
            fizzSem.release();
            buzzSem.release();
            fizzBuzzSem.release();
            numSem.release();
        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            fizzSem.acquire();
            if (i <= n) {
                printFizz.run();
            }
            release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            buzzSem.acquire();
            if (i <= n) {
                printBuzz.run();
            }
            release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            fizzBuzzSem.acquire();
            if (i <= n) {
                printFizzBuzz.run();
            }
            release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            numSem.acquire();
            if (i <= n) {
                printNumber.accept(i);
            }
            release();
        }
    }
}
