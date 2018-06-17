package pl.waw.sgh.myapp;

public abstract class Coffee extends Beverage{

    public Integer grindLevel;
    private double tds;
    private double ext;

    public Coffee(int beverageID, User user, double dose, double waterUsed, int temperature, String time, String type, int score, Integer grindLevel, double tds, double ext) {
        super(beverageID, user, dose, waterUsed, temperature, time, type, score);
        this.grindLevel = grindLevel;
        this.tds = tds;
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "grindLevel=" + grindLevel +
                ", tds=" + tds +
                ", ext=" + ext +
                '}';
    }
    @Override
    public Integer getGrindLevel() {
        return grindLevel;
    }
    public void setGrindLevel(Integer grindLevel) {
        this.grindLevel = grindLevel;
    }
    @Override
    public double getTds() {
        return tds;
    }
    public void setTds(double tds) {
        this.tds = tds;
    }
    public double getExt() {
        return ext;
    }
    public void setExt(double ext) {
        this.ext = ext;
    }
}
