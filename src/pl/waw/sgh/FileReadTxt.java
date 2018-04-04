package pl.waw.sgh;
import javax.xml.bind.SchemaOutputResolver;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

import java.io.File;

public class FileReadTxt {
   // final static String FILE = "C:\\myFile.txt";
   // final static String FILE = "..\\..\\..\\myFile.txt";
    final static String FILE = "C:\\Users\\Krzysztof\\myFile.txt"; // not a problem in java in windows
    public static void main(String[] args) {
        System.out.println("File separator" + File.separator); //symbol that system is using
        File myFile=new File(FILE);
        try {
            Scanner scanner = new Scanner(myFile);
            int i = 0;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                i++;
                System.out.println("Line " + i + " : " + line);
            }
        }
        catch (FileNotFoundException e) {
                    e.printStackTrace();
        }
    }
}
