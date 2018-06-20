package pl.waw.sgh.myapp;

public abstract class Beverage {  //abstract class of beverages with some properties and modified toString

    private int beverageID;
    private double dose;
    private double waterUsed;
    private int temperature;
    private String time;
    private String type;
    private User user;
    private int score;

    public Beverage(int beverageID, User user, double dose, double waterUsed, int temperature, String time, String type, int score) {
        this.beverageID = beverageID;
        this.dose = dose;
        this.waterUsed = waterUsed;
        this.temperature = temperature;
        this.time = time;
        this.type = type;
        this.user = user;
        this.score = score;
    }

    public String attributesToString(){
        return "ID = " + beverageID +
                ", dose = " + dose +
                ", water Used = " + waterUsed +
                ", temperature = " + temperature +
                ", time: " + time +
                ", type: " + type +
                ", user: " + user.getName() +
                ", score = " + score;
    }
    @Override
    public String toString() {
        return "\n"+getClass().getSimpleName() + "(" + attributesToString() + ")";

    }

    public int getBeverageID() {
        return beverageID;
    }
    public void setBeverageID(int beverageID) {
        this.beverageID = beverageID;
    }
    public double getDose() {
        return dose;
    }
    public void setDose(double dose) {
        this.dose = dose;
    }
    public double getWaterUsed() {
        return waterUsed;
    }
    public void setWaterUsed(double waterUsed) {
        this.waterUsed = waterUsed;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}



