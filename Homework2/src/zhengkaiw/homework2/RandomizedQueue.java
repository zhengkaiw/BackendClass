package zhengkaiw.homework2;

import java.util.Random;

public class RandomizedQueue<Item> {

    private Item[] queue;
    private int index = 0;
    private int delete = 0;

    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void add(Item item) {
        if (!isEmpty()) {
            Item[] newQueue = (Item[]) new Object[index + 1];
            for (int i = 0; i < index; i++) {
                newQueue[i] = queue[i];
            }
            queue = newQueue;
        }
        queue[index++] = item;
    }

    public Item remove() {
        if (index == 0) {
            return null;
        }
        Random r = new Random();
        delete = r.nextInt(index);
        Item item = queue[delete];
        Item[] newQueue = (Item[]) new Object[index - 1];
        int start = 0;
        for (int i = 0; i < index; i++) {
            if (i == delete) continue;
            newQueue[start++] = queue[i];
        }
        queue = newQueue;
        index = newQueue.length;
        return item;
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.add(1);
        rq.add(2);
        rq.add(3);
        rq.add(4);
        rq.add(5);
        System.out.println(rq.isEmpty());
        System.out.println(rq.remove());
        System.out.println(rq.remove());
        System.out.println(rq.remove());
        System.out.println(rq.remove());
        System.out.println(rq.remove());
        System.out.println(rq.remove());
        System.out.println(rq.isEmpty());
    }

}
