package pl.waw.sgh.shapes;

public class IsoscelesTriangle extends AbstractTriangles {

    public IsoscelesTriangle(double a, double b){
        super(a, b);
    }
    @Override
    public double calcSurface() {
        double p = (2*parA+parB)/2;
        return Math.sqrt(p*(p-parA)*(p-parA)*(p-parB));
    }
//    @Override
//    public String toString() {
//        return "My " + super.toString();
//    }
    @Override
    public String toString() {
        return "My "+ this.getClass().getSimpleName() + " [parA=" + parA + ", parB=" + parB+"]";
    }
}