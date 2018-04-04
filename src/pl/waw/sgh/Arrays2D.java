package pl.waw.sgh;

public class Arrays2D {
    public static void main(String[] args) {

        int[][] arr2D = new int[3][4];
        arr2D[0][0] = 42;
        arr2D[0][1]=325;
        arr2D[0][2]=532;

        arr2D[1]=new int[]{24, 235, 2352, 325};

        for (int r=0;r<arr2D.length;r++){
            for (int c=0;c<arr2D[r].length;c++){
                System.out.print(arr2D[r][c] + "  \t"); // \t tab \n new line
            }
            System.out.println();
        }
    }
}
