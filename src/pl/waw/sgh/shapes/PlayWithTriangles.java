package pl.waw.sgh.shapes;

public class PlayWithTriangles {

    public static void main(String[] args) {

        AbstractTriangles[] myTriangles = new AbstractTriangles[3];
        myTriangles[0] = new ScaleneTriangle(3, 4, 5);
        myTriangles[1] = new IsoscelesTriangle(3, 4);
        myTriangles[2] = new EquilateralTriangle(3);

        for (AbstractTriangles t : myTriangles) {
            System.out.println(t.toString());
            System.out.println("Surface: " + t.calcSurface());
        }
    }
}
