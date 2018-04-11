package pl.waw.sgh;

public class Bowls {

    //for this task it would be better to use loop

    static int numberPins = 1;

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        int rows = 9999;
        long result = countPins(rows);
        System.out.println("There are "+result+" pins in "+rows+" rows.");
        long stopTime=System.currentTimeMillis();
        System.out.println("Calculating took "+ (stopTime-startTime) +" ms");

    }
    public static long countPins(int rows) {
        if (rows==1) return numberPins;
        numberPins+=rows;
        return countPins(rows-1);
    }
}
