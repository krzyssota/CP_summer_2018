package pl.waw.sgh;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println("Prime numbers up to:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        if (n==1) {
//            System.out.println(1);
//        }
//        if(n==2) {
//            System.out.println(1/2);
//        }
//        if (n==3) {
//            System.out.println(1/2/3);
//        }
//        if (n>=4) {
//            for (int j = 1; j < 4; j++) {
//                System.out.println(j);
//            }
        String primeNumbers = "";
        int divisionCheck = 0;
        int keepCount = 0;

        for (int i = 1; i <= n; i++) {
            divisionCheck =0;
            for (int p =i ; p>=1; p--) {
                if (i % p == 0) {
                   divisionCheck+=1;
                }
            }
            if (divisionCheck == 2) {
                primeNumbers = primeNumbers + " " + i;
                keepCount+=1;


            }
        }
        System.out.println("Prime numbers up to " + n + " are " + primeNumbers);
        System.out.println("There are " + keepCount + " of those numbers.");

    }
}
