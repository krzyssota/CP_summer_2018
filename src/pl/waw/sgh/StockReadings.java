package pl.waw.sgh;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StockReadings {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Krzysztof\\Documents\\computer_programming\\homework5");
        File[] listOfFiles = folder.listFiles();

        Scanner scanner;

        for (File file:listOfFiles) {
            if (file.isFile()) {
                System.out.println("File " + file.getName());
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e){
                    System.out.println("File not found in " + folder); //never printing out
                    return;
                }



            } else if (file.isDirectory()) {
                System.out.println("Directory " + file.getName());
            }
        }

       /* for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }*/



        int i=0;
        ArrayList<Integer> open = new ArrayList();
        ArrayList<Integer> close = new ArrayList();
        ArrayList<Integer> change = new ArrayList();

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] lineSplitted = line.split(",");
            Integer openInt = Integer.parseInt(lineSplitted[1]);
            Integer closeInt = Integer.parseInt(lineSplitted[4]);
            open.add(openInt);
            close.add(closeInt);
            int changeInt = (closeInt-openInt)/openInt;
            change.add(changeInt);
            i++;
        }
        System.out.println(open);

    }
}
//2. Write a program that searches for CSV files with stock rates in a given folder and for every one of them:
//
//3. Calculates the percentage change betweeen Close and Open price and adds these values as another column to this CSV file.
//You can replace the old file or create a new one.
//
//Change = (Close-Open)/Open





//17:18
//package pl.waw.sgh;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//
//public class StockReadings {
//    public static void main(String[] args) {
//        File folder = new File("C:\\Users\\Krzysztof\\Documents\\computer_programming\\homework5");
//        File[] listOfFiles = folder.listFiles();
//
//        Scanner scanner;
//
//        for (File file:listOfFiles) {
//            if (file.isFile()) {
//                System.out.println("File " + file.getName());
//                try {
//                    scanner = new Scanner(file);
//                } catch (FileNotFoundException e){
//                    System.out.println("File not found in " + folder); //never printing out
//                    return;
//                }
//
//
//
//            } else if (file.isDirectory()) {
//                System.out.println("Directory " + file.getName());
//            }
//        }
//
//       /* for (int i = 0; i < listOfFiles.length; i++) {
//            if (listOfFiles[i].isFile()) {
//                System.out.println("File " + listOfFiles[i].getName());
//            } else if (listOfFiles[i].isDirectory()) {
//                System.out.println("Directory " + listOfFiles[i].getName());
//            }
//        }*/
//
//
//
//        int i=0;
//        ArrayList<Integer> open = new ArrayList();
//        ArrayList<Integer> close = new ArrayList();
//        ArrayList<Integer> change = new ArrayList();
//
//        while (scanner.hasNext()){
//            String line = scanner.nextLine();
//            String[] lineSplitted = line.split(",");
//            Integer openInt = Integer.parseInt(lineSplitted[1]);
//            Integer closeInt = Integer.parseInt(lineSplitted[4]);
//            open.add(openInt);
//            close.add(closeInt);
//            int changeInt = (closeInt-openInt)/openInt;
//            change.add(changeInt);
//            i++;
//        }
//        System.out.println(open);
//
//    }
//}
////2. Write a program that searches for CSV files with stock rates in a given folder and for every one of them:
////
////3. Calculates the percentage change betweeen Close and Open price and adds these values as another column to this CSV file.
////You can replace the old file or create a new one.
////
////Change = (Close-Open)/Open
