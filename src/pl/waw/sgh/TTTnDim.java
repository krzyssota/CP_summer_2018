package pl.waw.sgh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TTTnDim {
    static String FILEPATH = "C:\\Users\\Krzysztof\\Desktop\\tictactoenDim.csv";

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
            //innerLoop:
            for (int j = 0; j < n-1; j++) {
                if (state[i][j] == state[i][j + 1]) {
                    if (j == n-2 && state[i][j] != 0) {
                        int winner;
                        return winner = state[i][j];
                    }
                } else {
                    break;
                }
            }
        }
        // columns
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n-1; i++) {
                if (state[i][j] == state[i + 1][j]) {
                    if (i == n-2 && state[i][j] != 0) {
                        int winner;
                        return winner = state[i][j];
                    }
                } else {
                    break;
                }
            }
        }
        //diagonals
        for (int i = 0; i < n-1; i++) {
            if (state[i][i] == state[i+1][i+1]) {
                if (i == n-2 && state[i][i] != 0) {
                    int winner;
                    return winner = state[i][i];
                }
            } else {
                break;
            }
        }
        int k=n-1;
        for (int i = 0; i < n-1; i++) {
            if (state[i][i+k] == state[i+1][i+k-1]) {
                if (i == n-2 && state[i][i+k] != 0) {
                    int winner;
                    return winner = state[i][i+k];
                }
                k-=2;
            } else {
                break;
            }
        }
        // no winner found
        throw new RuntimeException();
    }

    public static void main(String[] args) {

        File myTTT = new File(FILEPATH);
        Scanner scanner1;
        try {
            scanner1 = new Scanner(myTTT);
        } catch (FileNotFoundException e){
            System.out.println("File not found in " +FILEPATH);
            return;
        }

        int countLines=0;
        while (scanner1.hasNext()){
            scanner1.nextLine();
            countLines++;
        }
        int n = countLines;

        String[] lines = new String[n];

        Scanner scanner2;
        try {
            scanner2 = new Scanner(myTTT);
        } catch (FileNotFoundException e){
            System.out.println("File not found in " +FILEPATH);
            return;
        }
        int i=0;
        while (scanner2.hasNext() && i < n){
            String line = scanner2.nextLine();
            lines[i]=line;
            i++;
        }

        int[][] state;
        try {
            state = readTable(lines, n);
        }
        catch(NumberFormatException e){
            System.out.println("Illegal character in the document");
            return;
        }

        int winner;

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