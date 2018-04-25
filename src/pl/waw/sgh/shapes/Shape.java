package pl.waw.sgh.shapes;

public abstract class Shape implements ShapeCalculation, Comparable<Shape>  {
    protected Double parA = 0d;
    protected Double parB = 0d;

    public Shape(double a, double b) { //constructor
        setParams(a, b);
    }
    public void setParams(double a, double b) {
        parA = a;
        parB = b;
    }

    public Shape(double a) {
        setParam(a);
    }
    public void setParam(double a) {
        parA = a;
    }

    public abstract double calcSurface();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [parA=" + parA + ", parB=" + parB + "]";
    }

    @Override
    public int compareTo(Shape s) {
        Double mySurface = Double.valueOf(this.calcSurface());
        Double otherSurface = Double.valueOf(s.calcSurface());
        return mySurface.compareTo(otherSurface);
    }
}
