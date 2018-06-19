package pl.waw.sgh.myapp;

public class Tea extends Beverage {

    public int noSteeps;

    public Tea(int beverageID, User user, double dose, double waterUsed, int temperature, String time, String type, int score, int noSteeps) {
        super(beverageID, user, dose, waterUsed, temperature, time, type, score);
        this.noSteeps = noSteeps;
    }

    public int getNoSteeps() {
        return noSteeps;
    }
    @Override
    public String attributesToString() {
        return super.attributesToString() + ", which steeping: " + noSteeps+"\n";
    }
}
//herbata id 0 rodzaj (biala zielona itp) ratio temperatura czas woda (sklad mineralny)?
