package pl.waw.sgh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInput {
    public static void main(String[] args) {
        System.out.println("Please give your name.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello "+name);

        //System.out.println("Please give your age.");
       // int age = scanner.nextInt();
        //System.out.println("Hello you old fart aged "+age);

        int age =0;
        boolean success = false;
        while (!success)
        {
            try {
                System.out.println("Please give your age: ");
                scanner = new Scanner(System.in);
                age = scanner.nextInt();
                success = true;
            } catch (InputMismatchException ie)
            {
                System.out.println("Please try again");
            }

        }
        System.out.println("Age: "+age);
    }
}
