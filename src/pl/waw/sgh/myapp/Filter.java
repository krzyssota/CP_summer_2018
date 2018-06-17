package pl.waw.sgh.myapp;

public class Filter extends Coffee {
    public Filter(int beverageID, User user, double dose, double waterUsed, int temperature, String time, String type, int score, Integer grindLevel, double tds, double ext) {
        super(beverageID, user, dose, waterUsed, temperature, time, type, score, grindLevel, tds, ext);
    }
    @Override                   //will this cheat work?
    public int getNoSteeps(){
        return getNoSteeps();
    }
}

