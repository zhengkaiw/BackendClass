package backendclass;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node (int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Problem1 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n1.random = n3;
        n2.random = n1;
        n3.random = n1;

        Node node = n1;
        while (node != null) {
            System.out.print(node.val + " ");
            System.out.println(node.random.val);
            node = node.next;
        }

        node = p.copyRandomList(n1);
        while (node != null) {
            System.out.print(node.val + " ");
            System.out.println(node.random.val);
            node = node.next;
        }
    }
}
