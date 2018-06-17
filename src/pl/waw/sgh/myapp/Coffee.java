package pl.waw.sgh.myapp;

public abstract class Coffee extends Beverage{

    private Integer grindLevel;
    private double tds;
    private double ext;

    public Coffee(int beverageID, User user, double dose, double waterUsed, int temperature, String time, String type, int score, Integer grindLevel, double tds, double ext) {
        super(beverageID, user, dose, waterUsed, temperature, time, type, score);
        this.grindLevel = grindLevel;
        this.tds = tds;
        this.ext = ext;
    }
}
