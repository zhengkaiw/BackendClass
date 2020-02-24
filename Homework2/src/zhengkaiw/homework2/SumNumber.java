package zhengkaiw.homework2;

public class SumNumber {
    public int CalculateSum(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int j = i;
                while (Character.isDigit(str.charAt(j)) && j < str.length()) {
                    j++;
                    if (j == str.length()) {
                        break;
                    }
                }
                count += Integer.valueOf(str.substring(i, j));
                i = j - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "1abc2x30yz67";
        SumNumber sn = new SumNumber();
        System.out.println(sn.CalculateSum(s));
    }
}
