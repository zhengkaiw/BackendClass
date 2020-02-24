package zhengkaiw.homework2;

public class CountingSemaphore {
    private int signals = 0;

    public synchronized void take() {
        this.signals++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (this.signals == 0) wait();
        this.signals--;
        this.notify();
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread  threadA = new CounterThread(counter, "A");
        Thread  threadB = new CounterThread(counter, "B");

        threadA.start();
        threadB.start();
    }

}
