package pl.waw.sgh;
public class Booleans {

    public static void main(String[] args){

        boolean p = true;
        boolean q=false;
        //and
        boolean res = p && q;
        //or
        boolean res1=p||q;
        //XOR
        boolean res2=p^q;
        // negation
        boolean res3=!res2;

        System.out.println("res=" + res);
        System.out.println("res1=" + res1);
        System.out.println("res2=" + res2);
        System.out.println("res3=" + res3);

        if (res1/*==true*/) {
            System.out.println("res1 is true");
        }
    }
}
