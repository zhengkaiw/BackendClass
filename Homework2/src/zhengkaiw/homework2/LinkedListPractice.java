package zhengkaiw.homework2;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

public class LinkedListPractice {

    // reverse LinkedList recursively
    public ListNode reverseLinkedListRecursively(ListNode head) {
        return helper(head, null);
    }
    private ListNode helper(ListNode head, ListNode temp) {
        if (head == null) return temp;
        ListNode next = head.next;
        head.next = temp;
        return helper(next, head);
    }

    // reverse LinkedList iteratively
    public ListNode reverseLinkedListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, prev = dummy;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode findNthNode(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        return findNthNode(head.next, n - 1);
    }

    public ListNode findNthNodeFromEnd(ListNode head, int n) {
        return findNthNode(reverseLinkedListRecursively(head), n);
    }

    public boolean findCircle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        LinkedListPractice p = new LinkedListPractice();
        //System.out.println(p.reverseLinkedListRecursively(l1).val);
        //p.reverseLinkedListIteratively(l1);
        //System.out.println(p.deleteNode(l1, 2).next.val);
        System.out.println(p.findNthNode(l1, 3).val);
        System.out.println(p.findNthNodeFromEnd(l1, 2).val);
        System.out.println(p.findCircle(l1)); // l4.next = l2;
    }
}
