package pl.waw.sgh.shapes;

public class EquilateralTriangle extends AbstractTriangles {

    public EquilateralTriangle(double a, double b, double c){
        super(a, b, c);
    }
   /* @Override
    public double calcSurface() {
        return parA*parA*Math.sqrt(3)*0.25;
    }*/





//    @Override
//    public String toString() {
//        return "My " + super.toString();
//    }




    @Override
    public String toString() {
        return "My " + this.getClass().getSimpleName() + " [parA=" + parA + "]";
    }
}
