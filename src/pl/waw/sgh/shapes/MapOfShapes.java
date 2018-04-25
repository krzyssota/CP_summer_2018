package pl.waw.sgh.shapes;

import java.util.HashMap;
import java.util.Map;

public class MapOfShapes {
    public static void main(String[] args) {
        Map<String, ShapeCalculation> myMap = new HashMap<>();
        myMap.put("Rect 1", new Rectangle(4,6)); //index and an object
        myMap.put("Circle 1", new Circle(4));
        myMap.put("Rect 2", new Rectangle(2,3));
        myMap.put("Circle 1", new Circle(10));

        for (String idx: myMap.keySet()){
            ShapeCalculation s=myMap.get(idx);
            System.out.println(s);
        }

    }
}
