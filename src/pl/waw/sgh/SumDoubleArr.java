package pl.waw.sgh;

public class SumDoubleArr {
    public static double sumDoubles(Double[] array) {
        double dSum = 0.0;
        for (double el:array){
            dSum+=el;
        }
        return dSum;
    }

    public static void main(String[] args) {
        Double[] dArr = new Double [args.length];
        for (int i=0; i<args.length; i++){
            try {
            dArr[i] = Double.parseDouble(args[i]);
            } catch (NumberFormatException ne) {
                System.out.println("Argument" + i + "was ignored.");
            }

        }
        double sum = sumDoubles(dArr);
        System.out.println(sum);
    }
}

