package backendclass;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public boolean isPalindrome(String str) {
        char[] cs = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : cs) {
            list.add(c);
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private int lo, maxLengh;

    public String longestPalindrome(String str) {
        if (str.length() < 2) {
            return str;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            helper(str, i, i);
            helper(str, i, i + 1);
        }
        return str.substring(lo, lo + maxLengh);
    }

    private void helper(String str, int m, int n) {
        while (m >= 0 && n < str.length() && str.charAt(m) == str.charAt(n)) {
            m--;
            n++;
        }
        if (maxLengh < n - m - 1) {
            maxLengh = n - m - 1;
            lo = m + 1;
        }
    }

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "ca";
        Problem2 p = new Problem2();
        System.out.println(p.isPalindrome(s1));
        System.out.println(p.isPalindrome(s2));

        System.out.println(p.longestPalindrome(s1));
        System.out.println(p.longestPalindrome(s2));
    }
}
