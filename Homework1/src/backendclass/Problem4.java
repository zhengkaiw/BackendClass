package backendclass;

import java.util.Arrays;

public class Problem4 {
    public String noonSnooze(int num) {
        int hour = num / 60;
        int min = num % 60;
        int ampm = 0;

        if (hour >= 12) {
            ampm = hour / 12;
            if (hour % 12 == 0) {
                hour = 12;
            } else {
                hour = hour % 12;
            }
        }
        return hour + ":" + (min == 0 ? "00" : min) + (ampm % 2 == 0 ? "pm" : "am");
    }

    public static void main(String[] args) {
        Problem4 p = new Problem4();
        int num = 100;
        System.out.println(p.noonSnooze(num));

    }
}
