import java.util.concurrent.*;

class H2O {
    private CyclicBarrier barrier;
    private Semaphore hSem, oSem;
    public H2O() {
        this.barrier = new CyclicBarrier(3);
        this.hSem = new Semaphore(2);
        this.oSem = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		try{
            hSem.acquire();
        barrier.await();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hSem.release();
        }catch(Exception ignore){

        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try{
            oSem.acquire();
        barrier.await();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        oSem.release();
        }catch(Exception ignore){

        }
    }
}