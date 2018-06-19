package pl.waw.sgh.myapp;

public abstract class Coffee extends Beverage{

    public Integer grindLevel;
    public double tds;
    private double ext;

    public Coffee(int beverageID, User user, double dose, double waterUsed, int temperature, String time, String type, int score, Integer grindLevel, double tds, double ext) {
        super(beverageID, user, dose, waterUsed, temperature, time, type, score);
        this.grindLevel = grindLevel;
        this.tds = tds;
        this.ext = ext;
    }

    @Override
    public String attributesToString() {
        return super.attributesToString() + ", grind level: " + grindLevel + ", TDS = " + tds +"\n";
    }


    public double getExt() {
        return ext;
    }
    public void setExt(double ext) {
        this.ext = ext;
    }
}
