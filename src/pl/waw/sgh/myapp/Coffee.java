package pl.waw.sgh.myapp;

public abstract class Coffee extends Beverage{

    private Integer grindLevel;
    private double tds;
    private double ext;

    public Coffee(int beverageID, double dose, double waterUsed, int temperature, String time, String type, User user, int score, Integer grindLevel, double tds, double ext) {
        super(beverageID, dose, waterUsed, temperature, time, type, user, score);
        this.grindLevel = grindLevel;
        this.tds = tds;
        this.ext = ext;
    }
}
