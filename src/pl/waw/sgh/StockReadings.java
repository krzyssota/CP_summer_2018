package pl.waw.sgh;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class StockReadings {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Krzysztof\\Documents\\computer_programming\\homework5");
        File[] listOfFiles = folder.listFiles();

        Scanner scanner;

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File " + file.getName());
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found in " + folder); //never printing out
                    return;
                }

                ArrayList<Double> open = new ArrayList();
                ArrayList<Double> close = new ArrayList();
                ArrayList<Double> change = new ArrayList();

                scanner.nextLine(); //omit first row - coolumn names

                while (scanner.hasNext()) {

                    String line = scanner.nextLine();
                    String[] lineSplitted = line.split(",");
                    /*System.out.println("Current line: "+line);*/

                    Double openD = Double.parseDouble(lineSplitted[1]);
                    Double closeD = Double.parseDouble(lineSplitted[4]);

                    open.add(openD);
                    close.add(closeD);

                    Double changeD = ((closeD - openD) / openD) * 100;
                    change.add(changeD);

                }

             /*   DecimalFormat twoDecimalPlaces = new DecimalFormat("#.00");*/
                for (int i = 0; i < open.size(); i++){
                    System.out.println(open.get(i) + "\t" + close.get(i) + "\t" + String.format(Locale.US, "%.4f", change.get(i)) + "%");
//                    System.out.println(open.get(i) + "\t" + close.get(i) + "\t" + twoDecimalPlaces.format(change.get(i)) + "%");
                }

            }
        }
    }
}
//2. Write a program that searches for CSV files with stock rates in a given folder and for every one of them:
//
//3. Calculates the percentage change betweeen Close and Open price and adds these values as another column to this CSV file.
//You can replace the old file or create a new one.
//
//Change = (Close-Open)/Open