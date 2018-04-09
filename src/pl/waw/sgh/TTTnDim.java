package pl.waw.sgh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TTTnDim {
    static String FILEPATH = "C:\\Users\\Krzysztof\\Desktop\\tictactoenDim.csv";
    static int n=5; //chce zeby n bylo rowne tyle ile linijek ma plik ale umiem to zrobić tylko w mainie

    public static int[] readLine(String line, int n) {
        // "0, -1, 1"  ->  [0, -1, 1]
        int[] elements = new int[n];
        String[] separatedEl = line.split(",");
        for (int i=0;i<separatedEl.length;i++){

            int el = Integer.parseInt(separatedEl[i]);
            elements[i] = el;
        }
        return elements;
    }

    public static int[][] readTable(String[] lines, int n){
        int [][] tttTable = new int[n][n];
        for (int i=0;i<n;i++){
            tttTable[i]=readLine(lines[i],n);
        }
        return tttTable;
    }

    public static int gameWinner (int[][] state, int n) {
        //rows
        for (int i = 0; i < n; i++) {
            innerLoop:
            for (int j = 0; j < n - 1; j++) {
                if (state[i][j] == state[i][j + 1]) {
                    if (j == 2 && state[i][j] != 0) {
                        int winner;
                        return winner = state[i][j];

                    }
                    continue;
                } else {
                    break innerLoop;
                }
            }
        }
        // columns
        for (int i = 0; i < n; i++) {
            innerLoop:
            for (int j = 0; j < n - 1; j++) {
                if (state[j][i] == state[j + 1][i]) {
                    if (j == 2 && state[j][i] != 0) {
                        int winner;
                        return winner = state[i][j];

                    }
                    continue;
                } else {
                    break innerLoop;
                }
            }
        }
        //diagonals
        columnLoop:
        for (int i = 0; i < n - 1; i++) {
            if (state[i][i] == state[i+1][i+1]) {
                if (i == 2 && state[i][i] != 0) {
                    int winner;
                    return winner = state[i][i];
                }
                continue;
            } else {
                break columnLoop;
            }
        }
        // no winner found
        throw new RuntimeException();
    }

    public static void main(String[] args) {

        File myTTT = new File(FILEPATH);
        Scanner scanner;
        try {
            scanner = new Scanner(myTTT); //inny scanner
        } catch (FileNotFoundException e){
            System.out.println("File not found in " +FILEPATH);
            return;
        }

        int i=0;
        while (scanner.hasNext()){ //niż ten
            i++;
            System.out.println(i);
        }
        int n = i;

        String[] lines = new String[n];

        i=0;
        while (scanner.hasNext() && i < n){
            String line = scanner.nextLine();
            lines[i]=line;
            i++;
        }

        int[][] state;
        try {
            state = readTable(lines, n);
        }
        catch(NumberFormatException e){
            System.out.println("Plik zawiera nielegalny znak");
            return;
        }

        int winner;
//        winner = gameWinner(state);

        try {
            winner = gameWinner(state,n);
        }
        catch (RuntimeException e){
            System.out.println("Game not over");
            return;
        }


        switch (winner) {
            case 1:
                System.out.println("X");
                break;
            case -1:
                System.out.println("O");
                break;
            default:
                System.out.println("Internal error. Game status: " + winner);

        }


    }
}