package pl.waw.sgh.myapp;

public class User {

    private Integer userID;
    private String Name;
    private String waterMineralization; //TODO GH/KH in 1 liter  add a format GH/KH
    // water should be a separate class?

    public User (Integer userID, String Name, String waterMineralization) {
        this.userID = userID;
        this.Name = Name;
        this.waterMineralization = waterMineralization;
    }

    @Override
    public String toString() {
        return  "ID = " + userID + " " +
                Name +
                ", water Mineralization: " + waterMineralization;
    }

    public Integer getUserID() {
        return userID;
    }
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getWaterMineralization() {
        return waterMineralization;
    }
    public void setWaterMineralization(String waterMineralization) {
        this.waterMineralization = waterMineralization;
    }
}
