package backendclass;

public class Problem3 {
    public int CalculateBits(int n) {
        if (n < 0) {
            return -1;
        }
        int counter = 0;
        while (n >= 1) {
            n /= 2;
            counter++;
        }
        return counter;
    }

    public double CalculateBits2(int n) {
        if (n < 0) {
            return -1;
        }
        return 1 + Math.floor(Math.log(n)/Math.log(2));
    }

    public static void main(String[] args) {
        Problem3 p = new Problem3();
        int n = 4;
        System.out.println(p.CalculateBits(n) >= 0 ? p.CalculateBits(n) : "Illegal input");
        System.out.println(p.CalculateBits2(n) >= 0 ? p.CalculateBits2(n) : "Illegal input");
        int input = Integer.valueOf(args[0]);
        System.out.println(p.CalculateBits(input) >= 0 ? p.CalculateBits(input) : "Illegal input");
    }
}
