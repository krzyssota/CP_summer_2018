package pl.waw.sgh;

public class Chocolate {

    public static void main(String[] args) {
        int res = makeChocolate(4, 1,8);
        System.out.println(res);
    }

    public static int makeChocolate(int small, int big, int goal) {
        int noSmall = goal-5*big;
                if (noSmall>small)
                    return(-1);
    return(noSmall);
    }
}
