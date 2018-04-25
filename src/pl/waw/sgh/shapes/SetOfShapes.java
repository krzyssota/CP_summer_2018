package pl.waw.sgh.shapes;

import java.util.HashSet;
import java.util.Set;

public class SetOfShapes {
    public static void main(String[] args) {
        ShapeCalculation s1=new Rectangle(5,4);
        ShapeCalculation s2=new Circle(4);
        ShapeCalculation s3=new Rectangle(5,6);

        Set<ShapeCalculation> shapeSet = new HashSet<>();     //set is an unorganized ArrayList
        shapeSet.add(s1);
        shapeSet.add(s2);
        shapeSet.add(s3);
        shapeSet.add(s2);

        //in sets use for each loop

        for (ShapeCalculation s:shapeSet){
            System.out.println(s);
        }

    }
}
