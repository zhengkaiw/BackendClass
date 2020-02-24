package zhengkaiw.homework2;

import java.util.LinkedList;
import java.util.List;

public class Client<Item> {
    public LinkedList<Item> subset(List<Item> list, int k) {
        if (k > list.size()) {
            throw new UnsupportedOperationException();
        }
        RandomizedQueue<Item> rq = new RandomizedQueue<>();
        for (Item i : list) {
            rq.add(i);
        }
        LinkedList<Item> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(rq.remove());
        }
        return res;
    }

    public boolean isWCPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Dequeue<Character> dq = new Dequeue<>();
        for (char c : str.toCharArray()) {
            char cT;
            if (c == 'A') {
                cT = 'T';
            } else if (c == 'T') {
                cT = 'A';
            } else if (c == 'C') {
                cT = 'G';
            } else if (c == 'G') {
                cT = 'C';
            } else {
                throw new UnsupportedOperationException();
            }
            dq.addFirst(cT);
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.removeFirst());
        }

        return sb.toString().equals(str);
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Client<Integer> c = new Client<>();
        System.out.println(c.subset(list, 5).toString());
        System.out.println(c.isWCPalindrome("ATCGCGAT"));
    }
}
