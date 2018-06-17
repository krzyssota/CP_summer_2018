
package pl.waw.sgh.myapp;

public class Espresso extends Coffee {
    public Espresso(int beverageID, double dose, double waterUsed, int temperature, String time, String type, User user, int score, Integer grindLevel, double tds, double ext) {
        super(beverageID, dose, waterUsed, temperature, time, type, user, score, grindLevel, tds, ext);
    }
  /*@Override
    public double calcExt() {
        return getTds()*getOutWater()/getDose();
    }*/
}

