package pl.waw.sgh.shapes;

public abstract class AbstractTriangles {
    protected Double parA = 0d;
    protected Double parB = 0d;
    protected Double parC = 0d;

    public AbstractTriangles (double a, double b, double c) { //constructor of scalene traingle
        set3Params(a, b, c);
    }
    public void set3Params(double a, double b, double c) {
        parA = a;
        parB = b;
        parC = c;
    }

    public AbstractTriangles (double a, double b) { //constructor for Isosceles Triangle
        set2Params(a, b);
    }
    public void set2Params(double a, double b) {
        parA = a;
        parB = b;
    }

    public AbstractTriangles (double a) { //constructor for Equilateral Triangle
        set1Params(a);
    }
    public void set1Params(double a) {
        parA = a;
    }

    public abstract double calcSurface();

    /*@Override
    public String toString() {
        return this.getClass().getSimpleName() + " [parA=" + parA + ", parB=" + parB +", parC="+parC+"]";
    }*/
}
