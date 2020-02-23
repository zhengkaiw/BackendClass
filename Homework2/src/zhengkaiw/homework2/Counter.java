package zhengkaiw.homework2;

public class Counter {

    long count = 0;

    public synchronized void add(long value){
        this.count += value;
        System.out.println(CounterThread.currentThread().getName() + " " + value);
    }

}

class CounterThread extends Thread {

    protected Counter counter = null;

    public CounterThread(Counter counter, String name){
        this.counter = counter;
        this.setName(name);
    }

    public void run() {
        for(int i=0; i<10; i++){
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.add(i);
        }
    }
}

class Example {

    public static void main(String[] args){
        Counter counter = new Counter();
        Thread  threadA = new CounterThread(counter, "A");
        Thread  threadB = new CounterThread(counter, "B");

        threadA.start();
        System.out.println(counter.count);
        threadB.start();
        System.out.println(counter.count);
    }
}