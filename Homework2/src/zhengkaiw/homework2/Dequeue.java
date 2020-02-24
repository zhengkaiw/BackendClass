package zhengkaiw.homework2;

public class Dequeue<Item> {

    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    int size;

    public Dequeue() {
        head = new DoubleLinkedListNode(null);
        tail = new DoubleLinkedListNode(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(Item item) {
        if (item == null) {
            return;
        }
        DoubleLinkedListNode node = new DoubleLinkedListNode(item);
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            return;
        }
        DoubleLinkedListNode node = new DoubleLinkedListNode(item);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    public Item removeFirst() {
        DoubleLinkedListNode node = head.next;
        head.next = node.next;
        node.next.prev = head;
        size--;
        return node.item;
    }

    public Item removeLast() {
        DoubleLinkedListNode node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = tail;
        size--;
        return node.item;
    }

    class DoubleLinkedListNode {
        Item item;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;

        public DoubleLinkedListNode(Item item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Dequeue<Integer> dq = new Dequeue<>();
        System.out.println(dq.isEmpty());
        dq.addFirst(2);
        dq.addFirst(1);
        dq.addLast(3);
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.isEmpty());
        System.out.println(dq.removeLast());
        System.out.println(dq.isEmpty());
    }
}
