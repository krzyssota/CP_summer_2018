package pl.waw.sgh;
import java.io.*;
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

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File " + file.getName());
                try {
                    copyAndImproveFile(file);
                }catch (FileNotFoundException e){
                    System.out.println("File: "+file.getName()+ " not found in "+folder);
                }
            }
        }
    }
    public static void copyAndImproveFile (File file) throws FileNotFoundException { //plikuj nie interesuje przypadek gdy pliku nie ma

        Scanner scanner = new Scanner(file);

        File outfile = new File("C:\\Users\\Krzysztof\\Documents\\computer_programming\\homework5\\"+"_"+file.getName());

        try {
            FileWriter fw = new FileWriter(outfile);
            BufferedWriter out = new BufferedWriter(fw);

            out.write(scanner.nextLine()+",Percentage Change"); //omit first row - coolumn names
            out.newLine();
            while (scanner.hasNext()) {

                String line = scanner.nextLine();
                out.write(addPercentageChangeField(line));
                out.newLine();
            }

            out.close();
            fw.close();
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
    public static String addPercentageChangeField (String line){
        String[] lineSplitted = line.split(",");
        Double openD = Double.parseDouble(lineSplitted[1]);
        Double closeD = Double.parseDouble(lineSplitted[4]);

        Double changeD = ((closeD - openD) / openD) * 100;
        return line+","+String.format(Locale.US, "%.4f", changeD);
    }
}
//2. Write a program that searches for CSV files with stock rates in a given folder and for every one of them:
//
//3. Calculates the percentage change betweeen Close and Open price and adds these values as another column to this CSV file.
//You can replace the old file or create a new one.
//
//Change = (Close-Open)/Open