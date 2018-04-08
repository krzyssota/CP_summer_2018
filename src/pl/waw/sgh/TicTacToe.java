package pl.waw.sgh;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TicTacToe {
    static String FILEPATH = "C:\\Users\\Krzysztof\\Desktop\\tictactoe.csv";

    public static int[] readLine(String line) {
        // "0, -1, 1"  ->  [0, -1, 1]
        int[] elements = new int[3];
        String[] separatedEl = line.split(",");
        for (int i=0;i<separatedEl.length;i++){

            int el = Integer.parseInt(separatedEl[i]);
            elements[i] = el;
        }
        return elements;
    }

    public static int[][] readTable(String[] lines){
        int [][] tttTable = new int[3][3];
        for (int i=0;i<3;i++){
            tttTable[i]=readLine(lines[i]);
        }
        return tttTable;
    }

    public static int gameWinner (int[][] state) {
            //rows
            if (state[0][0] == state[0][1] && state[0][1] == state[0][2] && state[0][0] != 0) {
                int winner;
                return winner = state[0][0];
            }
            if (state[1][0] == state[1][1] && state[1][1] == state[1][2] && state[1][0] != 0) {
                int winner;
                return winner = state[1][0];
            }
            if (state[2][0] == state[2][1] && state[2][1] == state[2][2] && state[2][0] != 0) {
                int winner;
                return winner = state[2][0];
            }

            //columns
            if (state[0][0] == state[1][0] && state[1][0] == state[2][0] && state[0][0] != 0) {
                int winner;
                return winner = state[0][0];
            }
            if (state[0][1] == state[1][1] && state[1][1] == state[1][2] && state[0][1] != 0) {
                int winner;
                return winner = state[0][1];
            }
            if (state[0][2] == state[1][2] && state[1][2] == state[2][2] && state[0][2] != 0) {
                int winner;
                return winner = state[0][2];
            }

            //diagonals
            if (state[0][0] == state[1][1] && state[1][1] == state[2][2] && state[0][0] != 0) {
                int winner;
                return winner = state[0][0];
            }
            if (state[0][2] == state[1][1] && state[1][1] == state[2][0] && state[0][2] != 0) {
                int winner;
                return winner = state[0][2];
            }
            // no winner found
//            return 0;
            throw new RuntimeException();


//        for (int i=0;i<2;i++) {
//            for (int j = 0; j < 2; j++) {
//                if (state[i][j] == state[i][j + 1] && state[i][j+1]==state[i][j+2]){
//
//                }
//            }
//        }
    }





    public static void main(String[] args) {

        File myTTT = new File(FILEPATH);
        String[] lines = new String[3];


        Scanner scanner;
        try {
            scanner = new Scanner(myTTT);
        } catch (FileNotFoundException e){
            System.out.println("File not found in " +FILEPATH);
            return;
        }

        int i=0;
        while (scanner.hasNext() && i < 3){
            String line = scanner.nextLine();
            lines[i]=line;
            i++;
        }

        int[][] state;
        try {
            state = readTable(lines);
        }
        catch(NumberFormatException e){
            System.out.println("Plik zawiera nielegalny znak");
            return;
        }
    
        int winner;
//        winner = gameWinner(state);

        try {
            winner = gameWinner(state);
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
