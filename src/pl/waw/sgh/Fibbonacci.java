package pl.waw.sgh;

public class Fibbonacci {
    public static void main(String[] args) {
        int n = 6;
        String firstNFibbonacci = "";
        int fn2 = 1;
        int fn1 = 1;
        int fn=0;
        if (n==1) {
            System.out.println("First fibbonacci number is 1");
        }
        if (n==2) {
            System.out.println("First two fibbonacci numbers are 1 1");
        }
        if (n>=3) {
            for (int i = 3; i <= n; i++) {
                fn = fn1 + fn2;
                fn2 = fn1;
                fn1 = fn;
                firstNFibbonacci = firstNFibbonacci + " " + fn;
            }
            System.out.println("First " + n + " fibbonacci numbers are: 1 1" + firstNFibbonacci);
        }
        int m = n;
        String fibbonacciNumbersUpTo = "";
        int fm2 = 1;
        int fm1 = 1;
        int fm=0;
        if (m==1) {
            System.out.println("Fibbonacci numbers up to 1: 1 1");
        }
        if (m>1) {
            for (int i = 2; i <= m; i++) {
                while (fm1+fm2<=n) {
                    fm = fm1 + fm2;
                    fm2 = fm1;
                    fm1 = fm;
                    fibbonacciNumbersUpTo =  fibbonacciNumbersUpTo + " " + fm;
                }
            }
            System.out.println("Fibbonacci numbers up to " + n + ": 1 1" + fibbonacciNumbersUpTo);
        }

    }
}
