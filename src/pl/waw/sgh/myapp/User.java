package pl.waw.sgh.myapp;

public class User { //every use has an own water with unique mineral content

    private Integer userID;
    private String Name;
    private String waterMineralization;

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
