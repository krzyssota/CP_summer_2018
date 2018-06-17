package pl.waw.sgh.myapp;

public class Tea extends Beverage {

    private int noSteeps;

    public Tea(int beverageID, User user, double dose, double waterUsed, int temperature, String time, String type, int score, int noSteeps) {
        super(beverageID, user, dose, waterUsed, temperature, time, type, score);
        this.noSteeps = noSteeps;
    }

    @Override
    public int getNoSteeps() {
        return noSteeps;
    }

    public void setNoSteeps(int noSteeps) {
        this.noSteeps = noSteeps;
    }

    @Override                               //will this cheat work?
    public Integer getGrindLevel() {
        return getGrindLevel();
    }
    @Override                               //will this cheat work?
    public double getTds() {
        return getTds();
    }
}
//herbata id 0 rodzaj (biala zielona itp) ratio temperatura czas woda (sklad mineralny)?
