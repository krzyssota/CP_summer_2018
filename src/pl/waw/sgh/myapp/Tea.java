package pl.waw.sgh.myapp;

public class Tea extends Beverage {

    private int noSteeps;

    public Tea(int beverageID, double dose, double waterUsed, int temperature, String time, String type, User user, int score, int noSteeps) {
        super(beverageID, dose, waterUsed, temperature, time, type, user, score);
        this.noSteeps = noSteeps;
    }
}
//herbata id 0 rodzaj (biala zielona itp) ratio temperatura czas woda (sklad mineralny)?
