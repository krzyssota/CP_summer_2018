package pl.waw.sgh.myapp;

import sun.rmi.runtime.Log;

public class TestLogBase {
    public static void main(String[] args) {
        LogBase logBase = new LogBase();
        User u1 = logBase.createUser("Krzys", "50/50");
        User u2 = logBase.createUser("Janka", "100/70");

        Beverage bev1 = logBase.createBeverage(0, u1, 12, 200, 95, "120s", "Kenya", 8,  15, 1.3, 0 );
        Beverage bev2 = logBase.createBeverage(0, u1, 12, 200, 97, "120s", "Kenya", 9,  14, 1.4, 0 );
        Beverage bev3 = logBase.createBeverage(2, u2, 6,  400, 70, "60s",  "Green", 10, 0,  0,   1 );
        Beverage bev4 = logBase.createBeverage(2, u2, 6,  600, 70, "180s", "Green", 7,  0,  0,   2 );
       /* int fet, User user, double dose, double waterUsed, int temperature, String time, String type,
        int score, Integer grindLevel, double tds,  int noSteeps */
        System.out.println(logBase);
    }
}
