package zhengkaiw.homework2;

import java.util.*;

public class ThreadPractice {

}

class TicketNumberHandler {
    private long nextUniqueNumber = 1;

    public Long getTicketNumber() {
        return nextUniqueNumber++;
    }
}

class TicketNumberHandler3 extends TicketNumberHandler {
    private static TicketNumberHandler3 INSTANCE;

    private TicketNumberHandler3() {};

    public static TicketNumberHandler3 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new TicketNumberHandler3();
        }
        return INSTANCE;
    }
}

class BuyTicket {
    public static void main(String[] args) {
        int userNumber = 10000;
        Set<Thread> threadSet = new HashSet<>();

        List<TicketNumberHandler> hanlderList = new Vector<>();
        List<Long> ticketNumberList = new Vector<>();

        for (int i = 0; i < userNumber; i++) {
            Thread t = new Thread() {
                public void run() {
                    TicketNumberHandler handler = TicketNumberHandler3.getInstance();
                    hanlderList.add(handler);

                    Long ticketNumber = handler.getTicketNumber();
                    ticketNumberList.add(ticketNumber);
                }
            };
            threadSet.add(t);
        }
        System.out.println("Current amount of user: " + threadSet.size());

        long beginTime = System.currentTimeMillis();
        for (Thread t : threadSet) {
            t.start();
        }

        long endTime;
        while (true) {
            if (Thread.activeCount() == 1) {
                endTime = System.currentTimeMillis();
                break;
            }
        }

        System.out.println("");
    }
}